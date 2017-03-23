package michel.praktikum;

import javax.swing.JLabel;

/**
 * @author: josef.bauer@pratho.de
 */
public class Enemy {
	private final JLabel shipLabel;
	private final JLabel explosionLabel;
	private int sizeX = 100;
	private int sizeY = 70;
	private int positionX = 0;
	private int positionY = 0;

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

	public int getX() {
		return positionX;
	}

	public int getY() {
		return positionY;
	}

	public void setPosition(int x, int y) {
		positionX = x;
		positionY = y;
		shipLabel.setBounds(positionX, positionY, sizeX, sizeY);
		explosionLabel.setBounds(positionX, positionY, sizeX, sizeY);
	}
}
