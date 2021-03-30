package compulsory;

import javax.swing.*;
import java.awt.BorderLayout;

public class MainFrame extends JFrame {
	ConfigPanel configPanel;
	ControlPanel controlPanel;
	DrawingPanel canvas;

	public MainFrame() {
		super("My Drawing Application");
		init();
	}

	private void init() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		configPanel = new ConfigPanel(this);
		controlPanel = new ControlPanel(this);
		canvas = new DrawingPanel(this);
		setLayout(new BorderLayout());
		add(controlPanel, BorderLayout.SOUTH);
		add(configPanel, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);

		pack(); //sizes the frame so that all its contents are at or above their preferred sizes
	}
}
