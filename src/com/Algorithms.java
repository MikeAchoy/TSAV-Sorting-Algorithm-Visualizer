import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Algorithms {
    // Enum containing algorithms sorted by type of algorithm.
    public enum sortingAlgorithms{
        BubbleSort
    };

    private int algorithmSpeedMS;
    private VisualizerPanel panelRef;

    public Algorithms(VisualizerPanel panelRefToSet){
        this.panelRef = panelRefToSet;
    }

    public void setAlgorithmSpeed(int algorithmSpeedToSet){
        this.algorithmSpeedMS = algorithmSpeedToSet;
    }
    
    public int getAlgorithmSpeed(){
        return this.algorithmSpeedMS;
    }

    public static Vector<sortingAlgorithms> getAvailableAlgorithms(){
        Vector<sortingAlgorithms> algorithmsVector = new Vector<>();
        algorithmsVector.add(sortingAlgorithms.BubbleSort);
        return algorithmsVector;
    }

    public void BubbleSort(int[] arrayToSort){
        // Get array size.
        int arraySize = arrayToSort.length;
        boolean swapPerformed;

        // Outer loop itr size(arr) - 1
        for(int i = arraySize - 1; i > 0 ; i--){
            swapPerformed = false;
            for(int j = 0; i > j; j++){
                // Get array pair (l, r)
                int leftInPair = arrayToSort[j];
                int rightIniPair = arrayToSort[j + 1];
                // Compare and swap elements.
                if(leftInPair > rightIniPair){
                    arrayToSort[j] = rightIniPair;
                    arrayToSort[j + 1] = leftInPair;

                    // TODO: Implement logic to change color of blocks that are getting swapped.
                    panelRef.revalidate();
                    panelRef.repaint();
                    // This is the repaint that isn't working.
                    
                    try {
                      TimeUnit.MILLISECONDS.sleep(this.algorithmSpeedMS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    swapPerformed = true;
                }
            }
            if(!swapPerformed){
                return;
            }
        }
        return;
    }

    public void printArray(int[] arrayToPrint){
        for(int i: arrayToPrint){
            System.out.print(i + " ");
        }
        System.out.println();
        return;
    }

    public int[] returnRandomArray(int arraySize, int lowerBound, int upperBound){
        // Instantiate new array
        int[] arr = new int[arraySize];
        // Populate inst array with random elems
        Random rand = new Random();
        for(int i = 0; i < arraySize; i++){
            int randNum = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            arr[i] = randNum;
        }
        return arr;
    }
    
    public int[] returnRandomArraySet(int arraySize) {

        if (arraySize <= 0) {
            throw new IllegalArgumentException("Array size must be greater than 0");
        }

        int[] randomArray = new int[arraySize];
        
        // Initialize the array with sequential numbers
        for (int i = 1; i < arraySize; i++) {
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
