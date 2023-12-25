import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Class that loads images from files; This one only contains loading through scaling
public class loadImages {

    // Uses resource path and given dimensions to load and scale image to fit requirements returning an image icon
    public ImageIcon loadScaledImage(String resourcePath, int imgWidth, int imgHeight){
        try{
            // Reads and scales image
            BufferedImage image = ImageIO.read(new File(resourcePath));
            Image scaledImage = image.getScaledInstance(imgWidth, imgHeight, image.SCALE_SMOOTH);
            BufferedImage bufferedImage = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedImage.createGraphics();
            g2d.drawImage(scaledImage, 0, 0, null);
            g2d.dispose();
            return new ImageIcon(bufferedImage);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Doesn't exist in given resource path given");
        return null;
    }
}
