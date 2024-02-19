
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

public class VisualizerPanel extends JPanel {
    
  private Algorithms algs;
  private int[] visualizerArray;
  private int[] displayedVisualizerArray;
  private boolean canScale;
  private boolean canVisualize;

  public VisualizerPanel() {
    this.setPreferredSize(new Dimension(600, 400));
    this.setBackground(Color.WHITE);
    this.canScale = false;

    algs = new Algorithms(this);

    // Set array to sort.
    // TODO: Set oroingal array copy to visualizer, but set the scaled array.
    this.revalidate();
    this.repaint();
  }

  public void setAlgorithmSpeed(int speedToSet) {
    this.algs.setAlgorithmSpeed(speedToSet);
    this.revalidate();
    this.repaint();
  }

  public void setVisualizerArray(int[] arrayInput) {
    this.visualizerArray = arrayInput;
    this.displayedVisualizerArray = getScaledArray(arrayInput);
    this.setVisualizerStatus(true);
    this.revalidate();
    this.repaint();
  }

  public void setScaleStatus(boolean scaleStatusToSet) {
    this.canScale = scaleStatusToSet;
  }

  public void setVisualizerStatus(boolean canVisualizeToSet) {
    this.canVisualize = canVisualizeToSet;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.revalidate();

    // Set visualizer Color.
    g.setColor(Color.BLACK);

    // Scale array every repaint of graphics.
    if (this.canScale) {
      this.displayedVisualizerArray = getScaledArray(visualizerArray);
      // Idea make copy here and run a different visualize with scaled array if we can
      // scale.
    }

    // Repaint (update) visualizer
    // GUI input issue appears when not visualizerArray in this param.
    // TODO: Try to draw init scaled array first instead of unscaled array.
    if (this.canVisualize) {
      visualizeArray(g, displayedVisualizerArray);
    }
  }

  public void drawVisualizerRect(Graphics g, int xPos, int yWeight, int blockDelta) {
    // Draw helper variables
    int visualizerAdjustedDepth = this.getHeight();
    int yPosOffset = visualizerAdjustedDepth - yWeight;
    // Draw based on bottom left corner of rect
    g.setColor(Color.black);
    // fillRect(x, y, width, height) -> draws from the top left corner of the rect
    // Here we keep x of screen as xPos.
    // Here we have y as an offset in order to simulate drawing rect from bottom
    // left corner.
    g.fillRect(xPos, yPosOffset, blockDelta, yWeight);
  }

  public void visualizeArray(Graphics g, int[] arrayToDisplay) {
    int[] visArrayInst = arrayToDisplay;
    // visArrayInst = getScaledArray(this.unscaledOrgArray);

    double blockWidthDisplacement;
    double displayWidth = this.getWidth();
    double arraySize = arrayToDisplay.length;

    blockWidthDisplacement = displayWidth / arraySize;
    int roundedBlockDisplacement = (int) Math.round(blockWidthDisplacement);
    int xDisplayDelta = 0;

    for (int i : visArrayInst) {
      drawVisualizerRect(g, xDisplayDelta, i, roundedBlockDisplacement);
      xDisplayDelta += roundedBlockDisplacement;
    }
  }

  public void scaleArray(int[] arrayToDisplay) {
    if (arrayToDisplay.length < this.getHeight()) {
      int visualizerHeight = this.getHeight();
      double arrayMultiplier;
      double scaledIndex;

      arrayMultiplier = visualizerHeight / arrayToDisplay.length;

      for (int i = 0; i < arrayToDisplay.length; i++) {
        scaledIndex = arrayToDisplay[i] * arrayMultiplier;
        arrayToDisplay[i] = (int) Math.round(scaledIndex);
      }
    }
    return;
  }

  public int[] getScaledArray(int[] arrayToDisplay) {
    int[] arrayCopy = new int[arrayToDisplay.length];
    System.arraycopy(arrayToDisplay, 0, arrayCopy, 0, arrayToDisplay.length); // Create a copy of the array

    int visualizerHeight = this.getHeight();
    double arrayMultiplier = (double) visualizerHeight / arrayCopy.length;

    for (int i = 0; i < arrayCopy.length; i++) {
      double scaledIndex = arrayCopy[i] * arrayMultiplier;
      arrayCopy[i] = (int) Math.round(scaledIndex);
    }
    return arrayCopy;
  }

  public void startAlgorithm(Algorithms.sortingAlgorithms algorithmToUse) {
    this.setScaleStatus(true);
    if (algorithmToUse == Algorithms.sortingAlgorithms.BubbleSort) {
      SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
        @Override
        protected Void doInBackground() throws Exception {
          algs.BubbleSort(visualizerArray);
          return null;
        }
      };
      worker.execute();
    }
  }

  public int[] returnRandomArraySet(int arraySize) {

    if (arraySize <= 0) {
      throw new IllegalArgumentException("Array size must be greater than 0");
    }

    int[] randomArray = new int[arraySize];

    // Initialize the array with sequential numbers
    for (int i = 0; i < arraySize; i++) {
      randomArray[i] = i;
    }

    // Shuffle the array using Fisher-Yates algorithm
    Random rand = new Random();
    for (int i = arraySize - 1; i > 0; i--) {
      int j = rand.nextInt(i + 1);

      // Swap randomArray[i] and randomArray[j]
      int temp = randomArray[i];
      randomArray[i] = randomArray[j];
      randomArray[j] = temp;
    }
    return randomArray;
  }
}
