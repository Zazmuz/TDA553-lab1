package main.assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;


public class AssetManager {

    private static final HashMap<String, BufferedImage> imageCache = new HashMap<String, BufferedImage>();

    public static BufferedImage getImage(String imagePath) {
        if (imageCache.containsKey(imagePath)) {
            return imageCache.get(imagePath);
        }
        else {
            return loadImage(imagePath);
        }
    }

    private static BufferedImage loadImage(String imagePath)  {
        try {
            BufferedImage image = ImageIO.read(Objects.requireNonNull(AssetManager.class.getResourceAsStream(imagePath)));
            imageCache.put(imagePath, image);
            return image;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null; // TODO: Fix this. please.
        }
    }

}
