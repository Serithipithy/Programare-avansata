package compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
	final MainFrame frame;
	final static int W = 1000, H = 600;
	BufferedImage image;
	Graphics2D graphics;
	List<Shape> shapes = new ArrayList<Shape>();

	public DrawingPanel(MainFrame frame) {
		this.frame = frame;
		createOffscreenImage();
		init();
	}

	private void createOffscreenImage() {
		image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
		graphics = image.createGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, W, H);
	}

	private void init() {
		setPreferredSize(new Dimension(W, H));
		setBorder(BorderFactory.createEtchedBorder());
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				drawShape(e.getX(), e.getY());
				frame.repaint();
			}
		});
	}

	private void drawShape(int x, int y) {
		int radius = new Random().nextInt(30 - 5) + 5; //(MAX - MIN) + MIN
		int sides = frame.configPanel.getSidesNo();
		int toErase = frame.configPanel.getShapeToDeleteNo() - 1;
		frame.configPanel.setShapeToDeleteNo(0);
		Color color = frame.configPanel.getCurrentColor();
		String shape = frame.configPanel.getCurrentShape();

		graphics.setColor(color);

		if (shape.equals("Circle")) {
			Circle newCircle = new Circle(x, y, radius);
			graphics.fill(newCircle);
			shapes.add(newCircle);
		}
			else {
				RegularPolygon newPolygon = new RegularPolygon(x, y, radius, sides);
				graphics.fill(newPolygon);
				shapes.add(newPolygon);
		}

		if (toErase > 0){ // repaints the shape with white and then removes it from the list
			graphics.setColor(Color.WHITE);
			graphics.fill(shapes.get(toErase));
			shapes.remove(toErase);
			frame.configPanel.getDeleteField().setValue(0); // resets the jspinner to 0
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
}
