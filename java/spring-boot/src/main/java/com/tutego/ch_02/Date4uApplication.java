package com.tutego.ch_02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.util.unit.DataSize;

import java.util.Arrays;
/*
    @SpringBootConfiguration -> @Configuration -> @Component
    @EnableAutoConfiguration
    @ComponentScan + @Configuration = classpath scanning
 */
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
        basePackageClasses = com.tutego.ch_02.CoreModule.class, // or basePackages for raw strings
        useDefaultFilters = false, // by default @ComponentScan includes all @Component types
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        // in case useDefaultFilters = false, Spring would also register the FileSystems that are NOT marked as @Component
                        classes = FileSystem.class
                ),
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = ".*(New|Old)"
                ),
                @ComponentScan.Filter(
                        type = FilterType.CUSTOM,
                        classes = com.tutego.ch_02.CustomTypeFilter.class // customTypeFilter.InnerFinalClass
                )
        },
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = com.tutego.ch_02.CoreModule.class
        )
)
public class Date4uApplication {

    private static final Logger logger = LoggerFactory.getLogger(Date4uApplication.class);

    // ConfigurableApplicationContext -> ApplicationContext -> ListableBeanFactory -> BeanFactory (amongst other things)
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = applicationContextBuilder(args);
        ListableBeanFactory listableBeanFactory = ctx;
        BeanFactory beanFactory = listableBeanFactory;

        // returns a bean or an exception if the bean can’t be provided
        Date4uApplication date4uApplicationBean = beanFactory.getBean(Date4uApplication.class);

        FileSystem fileSystem = beanFactory.getBean(FileSystem.class);
        logger.info("Available GB: {}", DataSize.ofBytes(fileSystem.getFreeDiskSpace()).toGigabytes());

        // returns the names of the components that the container has registered
        Arrays.stream(listableBeanFactory.getBeanDefinitionNames())
                .sorted()
                .forEach(logger::info);
    }

    private static ConfigurableApplicationContext simpleApplicationContext(String... args) {
        return SpringApplication.run(Date4uApplication.class, args);
    }

    // by default, java.awt.headless = true, which means Spring Boot applications don't have graphical user interfaces.
    private static ConfigurableApplicationContext configuredApplicationContext(String... args) {
        var app = new SpringApplication(Date4uApplication.class);
        app.setHeadless(false);
        app.setBannerMode(Banner.Mode.OFF);
        app.setLogStartupInfo(false);
        return app.run(args);
    }

    private static ConfigurableApplicationContext applicationContextBuilder(String... args) {
        return new SpringApplicationBuilder(Date4uApplication.class)
                .headless(false)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .run(args);
    }

}
