import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartListener implements ActionListener{

    private VisualizerPanel visualizerPanelRef;
    private InputPanel inputPanelRef;

    public StartListener(VisualizerPanel visualizerPanelRefToSet, InputPanel inputPanelRefToSet){
        this.visualizerPanelRef = visualizerPanelRefToSet;
        this.inputPanelRef = inputPanelRefToSet;
    }
    // TODO: Add input from the combobox selector.
    @Override
    public void actionPerformed(ActionEvent e) {
        this.visualizerPanelRef.startAlgorithm(inputPanelRef.getAlgorithmSelected());
        return;
    } 
}
