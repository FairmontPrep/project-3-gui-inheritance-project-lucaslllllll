import javax.swing.*;

public class FaceGUI {
    public static void main(String[] args) {
        Hair finalFace = new Hair();
        
        System.out.println("\n======================");
        System.out.println("Final Description: " + finalFace.description);
        System.out.println("======================\n");

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Face Generator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            frame.add(finalFace);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}