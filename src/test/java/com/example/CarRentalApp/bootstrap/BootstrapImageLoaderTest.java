package com.example.CarRentalApp.bootstrap;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BootstrapImageLoaderTest {

    BootstrapImageLoader bootstrapImageLoader = new BootstrapImageLoader();

    private boolean isByteArrayAnImage(byte[] bytes) {
        try {
            // Attempt to decode the byte array into an image
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
            return image != null;
        } catch (IOException e) {
            return false;
        }
    }

    @Test
    void loadImageAsByteArray() throws IOException {
        byte[] expectedImageBytes = bootstrapImageLoader.loadImageAsByteArray("citroenc3.jpg");

        boolean isImage = isByteArrayAnImage(expectedImageBytes);

        // Assert that the loaded bytes are indeed an image
        assertTrue(isImage, "The loaded byte array should represent an image.");
    }
}