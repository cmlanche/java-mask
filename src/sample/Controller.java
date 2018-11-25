package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    ImageView imageview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            BufferedImage image = ImageIO.read(getClass().getResource("../shape02.png"));
            BufferedImage mask = ImageIO.read(getClass().getResource("../source.jpg"));

            File file = new File("test.png");

            int offsetX = mask.getWidth() / 2;
            int offsetY = mask.getHeight() / 2;
            BufferedImage mixedImage = maskImage(image, mask, offsetX, offsetY);

            imageview.setImage(SwingFXUtils.toFXImage(mixedImage, null));

            ImageIO.write(mixedImage, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 在蒙版mask图上扣除image形状的图
     *
     * @param image
     * @param mask
     * @return
     */
    public BufferedImage maskImage(BufferedImage image, BufferedImage mask, int offsetX, int offsetY) {
        int width = image.getWidth();
        int height = image.getHeight();

        // 关键在于这里新建的图片类型一定是TYPE_INT_ARGB的
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = image.getRGB(i, j);
                int alpha = (pixel >> 24) & 0xff;
                int maskPixel = mask.getRGB(offsetX + i, offsetY + j);
                int newPixel = alpha == 0 ? pixel : maskPixel;
                newImage.setRGB(i, j, newPixel);
            }
        }

        return newImage;
    }

}
