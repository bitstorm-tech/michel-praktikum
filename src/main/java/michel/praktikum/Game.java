package michel.praktikum;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class Game extends JFrame {
	private JLayeredPane mainPane = new JLayeredPane();
	private boolean running = true;
	private boolean mouseDown = false;
	private int pressedKey;

	public Game() throws Exception {
		super("Gravity Simulator");
		setSize(1000, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		final Image crosshairImage = Utils.getImage("/crosshair.png", 32, 32);
		final Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(crosshairImage, new Point(16, 16), "crosshair");
		setCursor(cursor);

		final JLabel backgroundLabel = Utils.getLabel("/background.jpg", getWidth(), getHeight());
		backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
		mainPane.add(backgroundLabel);
		add(mainPane);

		addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {

			}

			@Override
			public void windowClosed(WindowEvent e) {
				running = false;
			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}
		});

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				pressedKey = e.getExtendedKeyCode();
			}

			@Override
			public void keyPressed(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				mouseDown = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				mouseDown = false;
			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		setVisible(true);
	}

	public Enemy createEnemy() throws Exception {
		final Enemy enemy = new Enemy();
		final JLabel label = enemy.getShipLabel();
		mainPane.add(label);
		mainPane.moveToFront(label);

		return enemy;
	}

	public void enemyDestroyed(Enemy enemy) {
		mainPane.add(enemy.getExplosionLabel());
		mainPane.moveToFront(enemy.getExplosionLabel());
		mainPane.remove(enemy.getShipLabel());
	}

	public void removeEnemy(Enemy enemy) {
		mainPane.remove(enemy.getShipLabel());
		mainPane.remove(enemy.getExplosionLabel());
		mainPane.repaint();
	}

	public boolean isRunning() {
		return running;
	}

	public boolean mouseClicked() {
		return mouseDown;
	}

	public int getPressedKey() {
		return pressedKey;
	}

	public static void main(String[] args) throws Exception {
		final Game game = new Game();
		final Enemy enemy = game.createEnemy();
		enemy.setPosition(0, 300);

		while (game.isRunning()) {
			final int x = Math.abs(new Random(System.currentTimeMillis()).nextInt() % 10);
			final int y = new Random(System.currentTimeMillis()).nextInt() % 10;

			enemy.setPosition(enemy.getX() + x, enemy.getY() + y);
			Thread.sleep(100);
		}
	}
}
