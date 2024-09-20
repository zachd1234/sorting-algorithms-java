import java.util.Arrays;
import java.util.Random;

/**
 * Class to analyze the performance of sort algorithms.
 *
 * @author Mr. Murphy
 * @version 2024/09/13
 */
public class SortingBenchmarkV1
{
    // Run all five sort methods
    // Using four different sizes of arrays
    // Using three different initial conditions
    public static void runBenchmark() {
        // verify sorts handle base conditions
        int[] testArray = {1};
        Sorting.bubbleSort(testArray);
        Sorting.selectionSort(testArray);
        Sorting.insertionSort(testArray);
        Sorting.mergeSort(testArray);
        Sorting.quickSort(testArray);
        System.out.println("\nFirst test passed\n");
        
        testArray = new int[] {1, 1, 1};
        Sorting.bubbleSort(testArray);
        Sorting.selectionSort(testArray);
        Sorting.insertionSort(testArray);
        Sorting.mergeSort(testArray);
        Sorting.quickSort(testArray);
        System.out.println("\nSecond test passed\n");
        
        // verify sorts are accurate
        testArray = new int[100];
        int[] sortedTestArray = new int[100];
        populateRandomArray(testArray);
        populateRandomArray(sortedTestArray);
        Arrays.sort(sortedTestArray);
        
        Sorting.bubbleSort(testArray);
        System.out.println("\nBubble Sort is accurate: " 
                + Arrays.equals(testArray, sortedTestArray));
        populateRandomArray(testArray);
        Sorting.selectionSort(testArray);
        System.out.println("\nSelection Sort is accurate: " 
                + Arrays.equals(testArray, sortedTestArray));
        populateRandomArray(testArray);
        Sorting.insertionSort(testArray);
        System.out.println("\nInsertion Sort is accurate: " 
                + Arrays.equals(testArray, sortedTestArray));
        populateRandomArray(testArray);
        Sorting.mergeSort(testArray);
        System.out.println("\nMerge Sort is accurate: "
                + Arrays.equals(testArray, sortedTestArray));
        populateRandomArray(testArray);
        Sorting.quickSort(testArray);
        System.out.println("\nQuick Sort is accurate: "
                + Arrays.equals(testArray, sortedTestArray));
        String aStr = " ";
        for (int i = 0; i < testArray.length; i++)
        {
            aStr = aStr + testArray[i] + " ";
        }
        System.out.println(aStr);
        // run benchmarks
        System.out.println("\nSize, Initial, Sort, Compares, Assigns, Time");
        int[] sizes = {25000, 50000, 75000, 100000};
        for (int size : sizes) {
            int[] arrayToSort = new int[size];
            long curTime;

            // randomly-sorted array
            populateRandomArray(arrayToSort);
            System.out.print(size + ", random, bubble");
            curTime = System.currentTimeMillis();
            Sorting.bubbleSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            populateRandomArray(arrayToSort);
            System.out.print(size + ", random, selection");
            curTime = System.currentTimeMillis();
            Sorting.selectionSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);
            
            populateRandomArray(arrayToSort);
            System.out.print(size + ", random, insertion");
            curTime = System.currentTimeMillis();
            Sorting.insertionSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            populateRandomArray(arrayToSort);
            System.out.print(size + ", random, merge");
            curTime = System.currentTimeMillis();
            Sorting.mergeSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            populateRandomArray(arrayToSort);
            System.out.print(size + ", random, quick");
            curTime = System.currentTimeMillis();
            Sorting.quickSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            // almost-sorted array -- 0.1% not sorted
            populateAlmostSortedArray(arrayToSort);
            System.out.print(size + ", almost, bubble");
            curTime = System.currentTimeMillis();
            Sorting.bubbleSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            populateAlmostSortedArray(arrayToSort);
            System.out.print(size + ", almost, selection");
            curTime = System.currentTimeMillis();
            Sorting.selectionSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            populateAlmostSortedArray(arrayToSort);
            System.out.print(size + ", almost, insertion");
            curTime = System.currentTimeMillis();
            Sorting.insertionSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            populateAlmostSortedArray(arrayToSort);
            System.out.print(size + ", almost, merge");
            curTime = System.currentTimeMillis();
            Sorting.mergeSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            populateAlmostSortedArray(arrayToSort);
            System.out.print(size + ", almost, quick");
            curTime = System.currentTimeMillis();
            Sorting.quickSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            // reverse-sorted array -- worst case
            populateReversedArray(arrayToSort);
            System.out.print(size + ", reverse, bubble");
            curTime = System.currentTimeMillis();
            Sorting.bubbleSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);
            
            populateReversedArray(arrayToSort);
            System.out.print(size + ", reverse, selection");
            curTime = System.currentTimeMillis();
            Sorting.selectionSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);
            
            populateReversedArray(arrayToSort);
            System.out.print(size + ", reverse, insertion");
            curTime = System.currentTimeMillis();
            Sorting.insertionSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);
            
            populateReversedArray(arrayToSort);
            System.out.print(size + ", reverse, merge");
            curTime = System.currentTimeMillis();
            Sorting.mergeSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            populateReversedArray(arrayToSort);
            System.out.print(size + ", reverse, quick");
            curTime = System.currentTimeMillis();
            Sorting.quickSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);
        }

        int[] sizes2 = {10000000, 20000000, 30000000, 40000000,
                        50000000, 60000000, 70000000, 80000000};
        for (int size : sizes2) {
            int[] arrayToSort = new int[size];
            long curTime;
            
            populateRandomArray(arrayToSort);
            System.out.print(size + ", random, merge");
            curTime = System.currentTimeMillis();
            Sorting.mergeSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);

            populateRandomArray(arrayToSort);
            System.out.print(size + ", random, quick");
            curTime = System.currentTimeMillis();
            Sorting.quickSort(arrayToSort);
            System.out.println(", " + (System.currentTimeMillis() - curTime) / 1000.0);
        }

    }
    
    private static void populateRandomArray(int[] arr) {
        Random rng = new Random(5000); // seed it to produced repeatable results
        int boundary = arr.length * 10; // spread values to reduce duplicates
        
        for (int i=0; i<arr.length; i++) {
            arr[i] = rng.nextInt(boundary);
        }
    }
    
    private static void populateAlmostSortedArray(int[] arr) {
        Random rng = new Random(5000); // seed it to produced repeatable results
        int boundary = arr.length * 10; // spread values to reduce duplicates
        
        for (int i=0; i<arr.length; i++) {
            arr[i] = rng.nextInt(boundary);
        }
        
        Arrays.sort(arr);
        
        // now change 0.1% of numbers
        for (int i = arr.length/1000; i < arr.length; i += arr.length/1000) {
            arr[i] = rng.nextInt(boundary);
        }
    }
    
    private static void populateReversedArray(int[] arr) {
        Random rng = new Random(5000); // seed it to produced repeatable results
        int boundary = arr.length * 10; // spread values to reduce duplicates
        
        for (int i=0; i<arr.length; i++) {
            arr[i] = rng.nextInt(boundary);
        }
        
        Arrays.sort(arr);
        
        // now swap values to other side of array
        for (int i=0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
    
    private static boolean isSorted(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {// not in order
                return false; // only need one exception
            }
        }
        return true; // no comparison was out of order
    }
}
