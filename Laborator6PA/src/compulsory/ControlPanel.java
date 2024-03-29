package compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ControlPanel extends JPanel {
	final MainFrame frame;
	JButton saveBtn = new JButton("Save");
	JButton loadBtn = new JButton("Load");
	JButton resetBtn = new JButton("Reset");
	JButton exitBtn = new JButton("Exit");

	public ControlPanel(MainFrame frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		setLayout(new GridLayout(2, 2));
		saveBtn.setBounds(10, 10, 20, 20);
		loadBtn.setBounds(30, 10, 20, 20);
		resetBtn.setBounds(50, 10, 20, 20);
		exitBtn.setBounds(70, 10, 20, 20);

		saveBtn.addActionListener(this::save);
		loadBtn.addActionListener(this::load);
		resetBtn.addActionListener(this::reset);
		exitBtn.addActionListener(this::exit);

		add(saveBtn);
		add(loadBtn);
		add(resetBtn);
		add(exitBtn);
	}

	private void save(ActionEvent e) {
		try {
			ImageIO.write(frame.canvas.image, "PNG", new File("C:\\Users\\Alexandra\\Desktop\\test.png"));
		} catch (IOException ex) { System.err.println(ex); }
	}

		private void load (ActionEvent e){
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.addChoosableFileFilter(new ImageFilter());
			fileChooser.setAcceptAllFileFilterUsed(false);

			int option = fileChooser.showOpenDialog(frame);
			if (option == JFileChooser.APPROVE_OPTION) {
				try {
					File file = fileChooser.getSelectedFile();
					BufferedImage image = ImageIO.read(file);
					frame.canvas.add(new JLabel(new ImageIcon(image)));
					SwingUtilities.updateComponentTreeUI(frame);
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
			}
		}
		private void reset (ActionEvent e){
			frame.dispose();
			new MainFrame().setVisible(true);
		}

		private void exit (ActionEvent e){
			frame.dispose();
		}
	}
