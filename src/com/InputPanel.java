
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InputPanel extends JPanel{
    // ControlPanel objects.
    private JLabel speedLabel;
    private JSlider speedSlider;
    private JLabel arraySizeLabel;
    private JTextField arraySizeField;
    private JSlider arraySizeSlider;
    private JButton generateArrayButton;
    private JButton startVisualizationButton;
    private JComboBox algorithmSelectionBox;

    // Window GUI object references needed for GUI listeners.
    VisualizerPanel visualizerPanelRef;
    Window windowRef;

    // ControlPanel object constructor.
    // TODO: Fix input panel not showing all elements on window.
    public InputPanel(VisualizerPanel visualizerPanelRefToSet, Window windowRefToSet){
        // Set panel size preference.
        this.setPreferredSize(new Dimension(600, 80));
        this.setBackground(Color.WHITE);

        this.visualizerPanelRef = visualizerPanelRefToSet;
        this.windowRef = windowRefToSet;
 
        // Create instance of control objects.
        this.generateArrayButton = new JButton();
        this.speedLabel = new JLabel();
        this.speedSlider = new JSlider(1, 200, 50);
        this.arraySizeLabel = new JLabel();
        this.arraySizeSlider = new JSlider(1, 400, 50);
        this.arraySizeField = new JTextField();
        this.startVisualizationButton = new JButton();
        this.algorithmSelectionBox = new JComboBox<>(Algorithms.getAvailableAlgorithms());

        // Set properties for control objects.
        this.generateArrayButton.setText("Generate");
        this.speedLabel.setText("Speed: ");
        this.speedSlider.setInverted(true);
        this.arraySizeLabel.setText("Size: ");
        this.arraySizeField.setText("50");
        this.startVisualizationButton.setText("Start");

        // Add listener objects to GUI objects
        this.speedSlider.addChangeListener(new SpeedListener(this , visualizerPanelRef));
        this.generateArrayButton.addActionListener(new GenerateListener(visualizerPanelRef, this));;
        this.startVisualizationButton.addActionListener(new StartListener(visualizerPanelRef));

        // Add objects to panel
        this.add(generateArrayButton);
        this.add(arraySizeLabel);
        this.add(arraySizeSlider);
        this.add(arraySizeField);
        this.add(speedLabel);
        this.add(speedSlider);
        this.add(algorithmSelectionBox);
        this.add(startVisualizationButton);
    }

    // Panel GUI object getters.
    public int getSpeedSet(){
        return this.speedSlider.getValue();
    }

    public int getArraySizeSet(){
        return this.arraySizeSlider.getValue();
    }
}
