package com.example.CarRentalApp.bootstrap;

import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class BootstrapImageLoader {
    public byte[] loadImageAsByteArray(String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource("static/Images/" + filename);
        Path imagePath = resource.getFile().toPath();
        return Files.readAllBytes(imagePath);
    }
}
