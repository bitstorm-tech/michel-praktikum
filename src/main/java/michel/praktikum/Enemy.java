package michel.praktikum;

import javax.swing.JLabel;

/**
 * @author: josef.bauer@pratho.de
 */
public class Enemy {
	private int sizeX = 100;
	private int sizeY = 70;
	private final JLabel shipLabel;
	private final JLabel explosionLabel;

	public Enemy() throws Exception {
		shipLabel = Utils.getLabel("/enemy.png", sizeX, sizeY);
		explosionLabel = Utils.getLabel("/explosion.jpg", sizeX, sizeY);
		setPosition(0,0);
	}

	public JLabel getShipLabel() {
		return shipLabel;
	}

	public JLabel getExplosionLabel() {
		return explosionLabel;
	}

	public void setPosition(int x, int y) {
		shipLabel.setBounds(x, y, sizeX, sizeY);
		explosionLabel.setBounds(x, y, sizeX, sizeY);
	}
}
