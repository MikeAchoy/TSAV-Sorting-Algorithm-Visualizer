// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class InputPanel extends JPanel {
   private JLabel speedLabel;
   private JSlider speedSlider;
   private JLabel arraySizeLabel;
   private JTextField arraySizeField;
   private JSlider arraySizeSlider;
   private JButton generateArrayButton;
   private JButton startVisualizationButton;
   private JComboBox algorithmSelectionBox;
   
   VisualizerPanel visualizerPanelRef;
   Window windowRef;

   public InputPanel(VisualizerPanel visualizerPanelRefToSet, Window windowRefToSet) {
      this.setPreferredSize(new Dimension(600, 80));
      this.setBackground(Color.WHITE);

      this.visualizerPanelRef = visualizerPanelRefToSet;
      this.windowRef = windowRefToSet;

      this.generateArrayButton = new JButton();
      this.speedLabel = new JLabel();
      this.speedSlider = new JSlider(1, 200, 50);
      this.arraySizeLabel = new JLabel();
      this.arraySizeSlider = new JSlider(1, 400, 50);
      this.arraySizeField = new JTextField();
      this.startVisualizationButton = new JButton();
      this.algorithmSelectionBox = new JComboBox(Algorithms.getAvailableAlgorithms());

      this.generateArrayButton.setText("Generate");
      this.speedLabel.setText("Speed: ");
      this.speedSlider.setInverted(true);
      this.arraySizeLabel.setText("Size: ");
      this.arraySizeField.setText("50");
      this.startVisualizationButton.setText("Start");

      this.speedSlider.addChangeListener(new SpeedListener(this, this.visualizerPanelRef));
      this.generateArrayButton.addActionListener(new GenerateListener(this.visualizerPanelRef, this));
      this.startVisualizationButton.addActionListener(new StartListener(this.visualizerPanelRef, this));
      this.arraySizeSlider.addChangeListener(new SizeListener(this));
      this.arraySizeField.addActionListener(new SizeFieldListener(this));

      this.add(this.generateArrayButton);
      this.add(this.arraySizeLabel);
      this.add(this.arraySizeSlider);
      this.add(this.arraySizeField);
      this.add(this.speedLabel);
      this.add(this.speedSlider);
      this.add(this.algorithmSelectionBox);
      this.add(this.startVisualizationButton);
   }

   public int getSpeedSet() {
      return this.speedSlider.getValue();
   }

   public int getArraySizeSet() {
      return this.arraySizeSlider.getValue();
   }

   public void updateArraySizeField(int var1) {
      this.arraySizeField.setText(Integer.toString(var1));
   }

   public int getArraySizeFieldValue() {
      return Integer.valueOf(this.arraySizeField.getText());
   }

   public void updateArraySizeSlider(int var1) {
      this.arraySizeSlider.setValue(var1);
   }

   public Algorithms.sortingAlgorithms getAlgorithmSelected(){
      String algorithmSelected = this.algorithmSelectionBox.getSelectedItem().toString();
      Algorithms.sortingAlgorithms sortingAlgorithm = null;
      switch (algorithmSelected) {
         case "BubbleSort":
            sortingAlgorithm = Algorithms.sortingAlgorithms.BubbleSort;
            break;

         case "QuickSort":
            sortingAlgorithm = Algorithms.sortingAlgorithms.QuickSort;
            break;
         default:
            break;
      }
      return sortingAlgorithm;
   }
}
