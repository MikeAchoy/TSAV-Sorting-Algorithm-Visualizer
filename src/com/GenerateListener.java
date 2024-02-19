import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenerateListener implements ActionListener{

    private VisualizerPanel visualizerPanelRef;
    private InputPanel inputPanelRef;

    public GenerateListener(VisualizerPanel visualizerPanelRefToSet, InputPanel inputPanelRefToSet){
        this.visualizerPanelRef = visualizerPanelRefToSet;
        this.inputPanelRef = inputPanelRefToSet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int arraySizeToSet = this.inputPanelRef.getArraySizeSet();
        this.visualizerPanelRef.setVisualizerArray(this.visualizerPanelRef.returnRandomArraySet(arraySizeToSet)); 
    }
}
