# TSAV Sorting Algorithm Visualizer

This project is an in-place sorting algorithm visualizer implemented in Java using Java Swing. It allows users to visualize various sorting algorithms in action, providing options to select the number of elements to be sorted and the speed at which the sorting process occurs for visualization.

## How to Use

1. **Download the Project:**
   Clone or download the project folder to your local machine.

2. **Navigate to the Project Directory:**
   Open a terminal or command prompt, and change the directory to the root folder of the downloaded project.

3. **Compile the Java Files:**
   Navigate to the `src/com` directory within the project folder. Compile the following Java files into class files using the `javac` command:
   ```
   javac Algorithms.java GenerateListener.java InputPanel.java SizeFieldListener.java SizeListener.java SpeedListener.java StartListener.java VisualizerPanel.java Window.java
   ```

4. **Compile and Run the Main File:**
   Once all the necessary class files are generated, compile and run the `Main.java` file to launch the sorting algorithm visualizer:
   ```
   javac Main.java
   java Main
   ```

5. **Interact with the Visualizer:**
   Upon running the `Main.java` file, the sorting algorithm visualizer window will appear. You can select the desired sorting algorithm from the dropdown menu, adjust the number of elements to be sorted, and set the sorting speed using the provided inputs and sliders.

## Adding Your Own In-Place Sorting Algorithm

To incorporate your own in-place sorting algorithm into the visualizer, follow these steps:

1. **Implement Algorithm Code:**
   Add the implementation of your sorting algorithm in the `Algorithms.java` file, taking an array as the input parameter.

2. **Update Enum:**
   Include the name of your algorithm in the `sortingAlgorithms` enum located in the `Algorithms.java` class file.

3. **Modify InputPanel:**
   Update the `getAlgorithmSelected()` method in the `InputPanel.java` file to include the case for selecting your algorithm.

4. **Execute Algorithm Branch:**
   Add a branch in the `startAlgorithm()` method within the `VisualizerPanel.java` file to execute your sorting algorithm.

   ```java
   if (algorithmToUse.equals(Algorithms.sortingAlgorithms.BubbleSort)) { // Replace "BubbleSort" with the name of the algorithm you added in the enum here
      SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
        @Override
        protected Void doInBackground() throws Exception {
          algs.bubbleSort(visualizerArray); // Replace "BubbleSort" with the name of the algorithm you added here too
          return null;
        }
      };
      worker.execute();
    }
   ```

Remember to follow the established code structure and conventions while adding your algorithm. 
