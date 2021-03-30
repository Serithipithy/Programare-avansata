package compulsory;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel implements ChangeListener {
	final protected MainFrame frame;
	protected JSpinner sidesField;
	protected JSpinner deleteField;
	protected int sidesNo;
	protected int shapeToDeleteNo;
	protected Color currentColor;
	protected String currentShape;

	public ConfigPanel(MainFrame frame) {
		this.frame = frame;
		init();
	}

	private void init() {
		JLabel sidesLabel = new JLabel("Number of sides:");
		JLabel shapeLabel = new JLabel("Choose shape:");
		JLabel deleteLabel = new JLabel("No of shape to delete:");

		String[] shapeString={"Regular Polygon","Circle"};
		//setup selector for number of sides
		sidesField = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
		deleteField = new JSpinner(new SpinnerNumberModel(0,0,100,1));

		setSidesNo(6); //program will draw 6-sided polygon by default

		//set available colors for filling the shapes
		Color[] colors = new Color[]{Color.BLUE, Color.BLACK, Color.GREEN};
		JComboBox<Color> colorCombo = new JComboBox<>(colors);
		JComboBox<String> shapeCombo = new JComboBox<>(shapeString);
		currentColor = Color.red;
		currentShape = "Regular Polygon";
		

		add(sidesLabel);
		add(sidesField);
		add(colorCombo);
		add(shapeLabel);
		add(shapeCombo);
		add(deleteLabel);
		add(deleteField);

		//listeners for color changes and number of sides
		sidesField.addChangeListener(this);
		colorCombo.addActionListener(this::setColor);
		shapeCombo.addActionListener(this::setShape);
		deleteField.addChangeListener(this::deleteShape);


	}

	private void deleteShape(ChangeEvent e) { //
		JSpinner mySpinner = (JSpinner) (e.getSource());
		setShapeToDeleteNo((int) mySpinner.getValue());

	}

	private void setShape(ActionEvent e) { // sets the current shape
		JComboBox myComboBox = (JComboBox) (e.getSource());
		currentShape = (String) myComboBox.getSelectedItem();
	}

	public JSpinner getDeleteField() {
		return deleteField;
	}

	public int getShapeToDeleteNo() {
		return shapeToDeleteNo;
	}

	public void setShapeToDeleteNo(int shapeToDeleteNo) {
		this.shapeToDeleteNo = shapeToDeleteNo;
	}



	public String getCurrentShape() {
		return currentShape;
	}

	public int getSidesNo() {
		return sidesNo;
	}

	public void setSidesNo(int sidesNo) {
		this.sidesNo = sidesNo;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner mySpinner = (JSpinner) (e.getSource());
		setSidesNo((int) mySpinner.getValue());
	}

	public void setColor(ActionEvent e) {
		JComboBox myComboBox = (JComboBox) (e.getSource());
		currentColor = (Color) myComboBox.getSelectedItem();
	}

	public Color getCurrentColor() {
		return currentColor;
	}
}
