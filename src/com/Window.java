import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class Window extends JFrame{
    // Window class GUI elements.
    // TODO: Add algorithm control GUI objects (make GUI complete)
    
    private InputPanel inputPanel;
    private VisualizerPanel visualizerPanel;

    public Window(){
        final int WINDOW_WIDTH = 600;
        final int WINDOW_HEIGHT = 500;
        final String WINDOW_TITLE = "TSAV";

        // Set window init properties.
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setTitle(WINDOW_TITLE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setBackground(Color.WHITE);

        // Create visualizer GUi objects.
        this.visualizerPanel = new VisualizerPanel();
        this.inputPanel = new InputPanel(this.visualizerPanel, this);

        // Add GUI objects to window.
        this.getContentPane().add(inputPanel, BorderLayout.NORTH);
        this.getContentPane().add(visualizerPanel, BorderLayout.CENTER);
    }
    
    // Repaint function for visualizerPanel.
    public void repaintDisplay(){
        try {
            TimeUnit.MILLISECONDS.sleep(10);
            // Do something here
            visualizerPanel.repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setWindowVisible(boolean setWindowVisible){
        this.setVisible(setWindowVisible);
    }
}
