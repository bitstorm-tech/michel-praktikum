package michel.praktikum;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

/**
 * @author: josef.bauer@pratho.de
 */
public class Utils {
	public static Image getImage(String fileName, Integer scaleX, Integer scaleY) throws Exception {
		final InputStream inputStream = Game.class.getResourceAsStream(fileName);
		if (scaleX != null && scaleY != null) {
			return ImageIO.read(inputStream).getScaledInstance(scaleX, scaleY, Image.SCALE_SMOOTH);
		} else {
			return ImageIO.read(inputStream);
		}
	}

	public static JLabel getLabel(String fileName, Integer scaleX, Integer scaleY) throws Exception {
		final Image image = getImage(fileName, scaleX, scaleY);
		return new JLabel(new ImageIcon(image));
	}
}
