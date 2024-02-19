import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartListener implements ActionListener{

    private VisualizerPanel visualizerPanelRef;

    public StartListener(VisualizerPanel visualizerPanelRefToSet){
        this.visualizerPanelRef = visualizerPanelRefToSet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Start clicked");
        this.visualizerPanelRef.startAlgorithm(Algorithms.sortingAlgorithms.BubbleSort);
    } 
}
