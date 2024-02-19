import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

public class SizeFieldListener implements ActionListener{

    private InputPanel inputPanelRef;

    public SizeFieldListener(InputPanel inputPanelRefToSet){
        this.inputPanelRef = inputPanelRefToSet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Bounds are 1-200
        int arraySize = this.inputPanelRef.getArraySizeFieldValue();
        if(arraySize > 400 || arraySize < 1){
            this.inputPanelRef.updateArraySizeField(arraySize);
            return;
        }
        else{
            this.inputPanelRef.updateArraySizeSlider(arraySize);
            return;
        }
    }
}
