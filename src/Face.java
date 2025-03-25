import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Face extends JPanel {
    protected BufferedImage faceImage;
    protected String description = "Face";

    public Face() {
        setPreferredSize(new Dimension(300, 300));
        loadImage("images/face.png");
        System.out.println("Face image loaded: " + (faceImage != null));
    }

    protected void loadImage(String path) {
        try {
            faceImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println("Error loading face image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (faceImage != null) {
            g.drawImage(faceImage, 0, 0, 300, 300, this);
        }
    }
}