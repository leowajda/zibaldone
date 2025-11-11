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

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


tasks {
    test {
        useJUnitPlatform()
    }
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    withType<Javadoc> {
        options.encoding = "UTF-8"
    }
    named<BootBuildImage>("bootBuildImage") {
        imageName.set("tutego.date4u")
    }
}

springBoot {
    buildInfo()
}
