import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SizeListener implements ChangeListener{

    private InputPanel inputPanelRef;

    public SizeListener(InputPanel inputPanelRefToSet){
        this.inputPanelRef = inputPanelRefToSet;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int arraySize = this.inputPanelRef.getArraySizeSet();
        this.inputPanelRef.updateArraySizeField(arraySize);
        return;
    }
}
