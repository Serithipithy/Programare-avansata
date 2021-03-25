package compulsory;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    public int sidesField=6;
    JLabel label;
    JComboBox colorCombo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        JLabel sidesLabel;
        JSpinner sidesField;
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        //create the colorCombo, containing the values: Random and Black
        JComboBox colorCombo;
        Color[] colors= new Color[]{Color.BLUE, Color.BLACK};
        colorCombo=new JComboBox(colors);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
    }

}
