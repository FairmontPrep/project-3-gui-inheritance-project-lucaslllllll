import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FaceCompositionPanel {
    public static void main(String[] args) {
        String eyeColor = Math.random() < 0.5 ? "blue" : "brown";
        String hairColor = Math.random() < 0.5 ? "black" : "brown";
        
        System.out.printf("Generated face: A face with mouth, nose, %s eyes and %s hair.%n", eyeColor, hairColor);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Face Composite");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            
            JPanel compositePanel = new JPanel() {
                
                BufferedImage face = loadImage("images/face.png");
                BufferedImage mouthNose = loadImage("images/mouthAndNose.png");
                BufferedImage eyes = loadImage("images/" + eyeColor + "Eyes.png");
                BufferedImage hair = loadImage("images/" + hairColor + "Hair.png");

                private BufferedImage loadImage(String path) {
                    try {
                        return ImageIO.read(new File(path));
                    } catch (IOException e) {
                        System.err.println("Error loading: " + path);
                        return null;
                    }
                }

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    
                    if (face != null) {
                        g.drawImage(face, 0, 0, 300, 300, this);       
                    }
                    if (mouthNose != null) {
                        g.drawImage(mouthNose, 80, 180, 140, 60, this); 
                    }
                    if (eyes != null) {
                        g.drawImage(eyes, 90, 100, 120, 80, this);    
                    }
                    if (hair != null) {
                        g.drawImage(hair, 0, 0, 300, 300, this);        
                    }
                }
            };

            frame.add(compositePanel);
            frame.setVisible(true);
        });
    }
}