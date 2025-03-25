import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Eyes extends MouthNose {
    private BufferedImage eyesImage;
    private String eyeColor;

    public Eyes() {
        super();
        if (Math.random() < 0.5) {
            eyeColor = "blue";
            loadImage("images/blueEyes.png");
        } else {
            eyeColor = "brown";
            loadImage("images/brownEyes.png");
        }
        description += ", " + eyeColor + " eyes";
        System.out.println("Eyes image loaded: " + (eyesImage != null));
    }

    @Override
    protected void loadImage(String path) {
        try {
            eyesImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println("Error loading eyes image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (eyesImage != null) {
            g.drawImage(eyesImage, 30, 120, 240, 80, this);
        }
    }
}