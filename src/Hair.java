import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Hair extends Eyes {
    private BufferedImage hairImage;
    private String hairColor;

    public Hair() {
        super();
        if (Math.random() < 0.5) {
            hairColor = "black";
            loadImage("images/blackHair.png");
        } else {
            hairColor = "brown";
            loadImage("images/brownHair.png");
        }
        description += ", and " + hairColor + " hair";
        System.out.println("Hair image loaded: " + (hairImage != null));
    }

    @Override
    protected void loadImage(String path) {
        try {
            hairImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println("Error loading hair image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (hairImage != null) {
            g.drawImage(hairImage, 0, 0, 300, 120, this);
        }
    }
}