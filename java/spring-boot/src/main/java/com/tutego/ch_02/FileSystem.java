package com.tutego.ch_02;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/*
    @Target(ElementType.TYPE)           <- may only be attached to type declarations
    @Retention(RetentionPolicy.RUNTIME) <- annotation is accessible at runtime via reflection
    @Documented                         <- expresses that a placed @Component annotation itself appears in the Java documentation of that class
    @Indexed                            <- Spring internals
*/
@Service // <- meta-annotation
public class FileSystem {
    private final Path root = Paths.get(System.getProperty("user.home")).resolve("fs");

    public FileSystem() {
        try {
            if (!Files.isDirectory(root)) Files.createDirectory(root);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public long getFreeDiskSpace() {
        return root.toFile().getFreeSpace();
    }

    public byte[] load(String filename) {
        try {
            return Files.readAllBytes(root.resolve(filename));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public void store(String filename, byte[] bytes) {
        try {
            Files.write(root.resolve(filename), bytes);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
