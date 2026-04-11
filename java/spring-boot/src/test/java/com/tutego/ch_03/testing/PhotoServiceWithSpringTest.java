package com.tutego.ch_03.testing;

import com.tutego.ch_02.beanQualification.PhotoService;
import com.tutego.ch_02.beanQualification.thumbnail.AwtBicubicThumbnail;
import com.tutego.ch_02.classpathScanning.FileSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import static com.tutego.ch_03.testing.PhotoServiceWithoutSpringTest.MINIMAL_JPG;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@TestPropertySource(properties = "spring.shell.interactive.enabled=false")
@SpringBootTest(classes = {
        PhotoService.class,
        AwtBicubicThumbnail.class,
        FileSystem.class
        // PhotoServiceWithSpringTest.Config.class can be manually injected into the context when defined as a @Bean in a @TestConfiguration
        // @MockBean and @SpyBean replace the beans of the same type with their mocked counterparts
})
public class PhotoServiceWithSpringTest {

    private final static Logger logger = LoggerFactory.getLogger(PhotoServiceWithSpringTest.class);

    // @TestConfiguration
    static class Config {
        // @Bean
        // @Primary <-- conflicts with the existing @Primary annotation
        public FileSystem dummyFileSystem() {
            logger.info("dummyFileSystem is picked by the test Spring context");
            return new FileSystem();
        }
    }

    @MockBean
    private FileSystem fileSystem;

    @SpyBean
    private AwtBicubicThumbnail thumbnail;

    @Autowired
    private PhotoService photoService;

    @BeforeEach
    void setupFileSystem() {
        given(fileSystem.getFreeDiskSpace()).willReturn(1L);
        given(fileSystem.load(anyString())).willReturn(MINIMAL_JPG);
    }

    @Test
    // by default the context is initialized once, and re-used across tests, but this behavior can be customized
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @DisplayName("successful photo upload")
    void successful_photo_upload() {
        var imageName = photoService.upload(MINIMAL_JPG);
        assertThat(imageName).isNotEmpty();
        verify(fileSystem, times(2)).store(anyString(), any(byte[].class));
        verify(thumbnail).thumbnail(any(byte[].class));
    }


}
