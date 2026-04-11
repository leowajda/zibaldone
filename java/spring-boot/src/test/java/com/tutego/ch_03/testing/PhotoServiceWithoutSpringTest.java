package com.tutego.ch_03.testing;

import com.tutego.ch_02.beanQualification.PhotoService;
import com.tutego.ch_02.beanQualification.thumbnail.AwtBicubicThumbnail;
import com.tutego.ch_02.classpathScanning.FileSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PhotoServiceWithoutSpringTest {

    public static final byte[] MINIMAL_JPG = Base64.getDecoder().decode(
            "/9j/4AAQSkZJRgABAQEASABIAAD/2wBDAP////////////////////////////////////" +
                    "//////////////////////////////////////////////////wgALCAABAAEBAREA/8QA" +
                    "FBABAAAAAAAAAAAAAAAAAAAAAP/aAAgBAQABPxA="
    );

    @Mock
    private FileSystem fileSystem;

    @Spy
    private AwtBicubicThumbnail thumbnail;

    // Mockito isn’t a complete dependency injection container,
    // objects not managed by Mockito aren’t created, and then the variables remain null.
    // Mockito not only tries to call the constructor but also calls possible setters or even set instance variables if they match the mock or spy types.
    @InjectMocks
    private PhotoService photoService;

    @BeforeEach
    void setupFileSystem() {
        given(fileSystem.getFreeDiskSpace()).willReturn(1L);
        given(fileSystem.load(anyString())).willReturn(MINIMAL_JPG);
    }

    @Test
    @DisplayName("successful photo upload")
    void successful_photo_upload() {
        var imageName = photoService.upload(MINIMAL_JPG);
        assertThat(imageName).isNotEmpty();
        verify(fileSystem, times(2)).store(anyString(), any(byte[].class));
        verify(thumbnail).thumbnail(any(byte[].class));
    }

}
