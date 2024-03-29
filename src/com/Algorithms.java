import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Algorithms {
    // Enum containing algorithms sorted by type of algorithm.
    public enum sortingAlgorithms{
        BubbleSort,
        QuickSort
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
        algorithmsVector.add(sortingAlgorithms.QuickSort);
        return algorithmsVector;
    }

    public void bubbleSort(int[] arrayToSort){
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
                    
                    try {
                      TimeUnit.MILLISECONDS.sleep(this.getAlgorithmSpeed());
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

    static void swap(int[] arr, int i, int j, VisualizerPanel panelRef, Algorithms algorithmsRef){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        panelRef.revalidate();
        panelRef.repaint();
                
        try {
          TimeUnit.MILLISECONDS.sleep(algorithmsRef.getAlgorithmSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(int[] arr, int low, int high, VisualizerPanel panelRef, Algorithms algorithmsRef){
        // Choosing the pivot
        int pivot = arr[high];
 
        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
 
                // Increment index of smaller element
                i++;
                swap(arr, i, j, panelRef, algorithmsRef);
            }
        }
        swap(arr, i + 1, high, panelRef, algorithmsRef);
        return (i + 1);
    }
 
    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    public void quickSort(int[] arr, int low, int high){
        if (low < high) {
 
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high, panelRef, this);
 
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
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
