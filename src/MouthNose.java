import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MouthNose extends Face {
    private BufferedImage mouthNoseImage;

    public MouthNose() {
        super();
        description += " with mouth and nose";
        loadImage("images/mouthAndNose.png");
        System.out.println("MouthNose image loaded: " + (mouthNoseImage != null));
    }

    @Override
    protected void loadImage(String path) {
        try {
            mouthNoseImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.err.println("Error loading mouth/nose image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (mouthNoseImage != null) {
            g.drawImage(mouthNoseImage, 80, 220, 140, 60, this);
        }
    }
}