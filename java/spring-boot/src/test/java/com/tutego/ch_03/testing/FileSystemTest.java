package com.tutego.ch_03.testing;

import com.tutego.ch_02.classpathScanning.FileSystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FileSystemTest {

    @Test
    @DisplayName("free disk space has to be positive")
    public void free_disk_space_has_to_be_positive() {
        var fileSystem = new FileSystem();
        var freeDiskSpace = fileSystem.getFreeDiskSpace();
        assertThat(freeDiskSpace).isGreaterThan(0);
    }

    @Test
    @DisplayName("store and load successful")
    void store_and_load_successful() {
        var fileSystem = new FileSystem();
        fileSystem.store("test.txt", "Hello World".getBytes());
        assertThat(fileSystem.load("test.txt")).containsExactly("Hello World".getBytes());
    }

    @Test
    @DisplayName("load unknown file throws exception")
    void load_unknown_file_throws_exception() {
        var fileSystem = new FileSystem();
        assertThatThrownBy(() -> fileSystem.load(UUID.randomUUID().toString())).isInstanceOf(UncheckedIOException.class);
    }

    @Test
    @DisplayName("load arbitrary file")
    void load_arbitrary_file() throws IOException {
        var fileSystem = new FileSystem();
        assertThatThrownBy(() -> fileSystem.load("../../../../../../../../../../test.txt"))
                .isInstanceOf(UncheckedIOException.class);
    }

}
