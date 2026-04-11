import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

group = "com.tutego"
version = "0.0.1-SNAPSHOT"
description = "date4u"

plugins {
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    java
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
    maven {
        name = "Spring Milestones"
        url = uri("https://repo.spring.io/milestone")
        mavenContent { releasesOnly() }
    }
    maven {
        name = "Spring Snapshots"
        url = uri("https://repo.spring.io/snapshot")
        mavenContent { snapshotsOnly() }
    }
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.shell:spring-shell-dependencies:3.0.2")
    }
}


dependencies {
    // TODO: annotate what dependency is used where
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // implementation("org.springframework.boot:spring-boot-starter-jdbc") already included in spring-boot-starter-data-jpa
    implementation("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.9.0")
    runtimeOnly("com.h2database:h2")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("org.springframework.retry:spring-retry")
    implementation("org.springframework:spring-aspects")

    implementation("org.springframework.data:spring-data-commons")

    implementation("org.springframework.boot:spring-boot-starter-json")

    implementation("org.springframework.shell:spring-shell-starter")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // implementation("org.springframework.boot:spring-boot-starter") already included in spring-boot-starter-web
    implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    /*

    TODO FIX DEPENDENCIES NOT LOADING + TESTCONTAINER EXAMPLE
    testImplementation("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")

    */

    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("com.nimbusds:nimbus-jose-jwt:9.37.3")
    implementation("org.springframework.security:spring-security-oauth2-jose")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")


    implementation("org.springframework.boot:spring-boot-starter-actuator")
}


tasks {
    test {
        useJUnitPlatform()
    }

    bootRun {
        mainClass.set("com.tutego.ch_02.classpathScanning.Date4uApplication")
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    withType<JavaCompile> {
        options.annotationProcessorPath = configurations.annotationProcessor.get()
    }

    named<BootBuildImage>("bootBuildImage") {
        imageName.set("tutego.date4u")
    }


}
