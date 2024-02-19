import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpeedListener implements ChangeListener{

    InputPanel inputPanelRef;
    VisualizerPanel visualizerPanelRef;

    public SpeedListener(InputPanel inputPanelRefToSet, VisualizerPanel visualizerPanelRefToSet){
        this.inputPanelRef = inputPanelRefToSet;
        this.visualizerPanelRef = visualizerPanelRefToSet;
        this.visualizerPanelRef.setAlgorithmSpeed(this.inputPanelRef.getSpeedSet());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        int newSpeedSet = this.inputPanelRef.getSpeedSet();
        this.visualizerPanelRef.setAlgorithmSpeed(newSpeedSet);
    }
    
}
