public class Sorting
{
    private static long comparison = 0;
    private static long assignment = 0;
    // instance variables - replace the example below with your own
    //fg  -  public static void bubbleSort(int[] arr)-  public static void selectionSort(int[] arr)

    public static void bubbleSort(int[] arr) {
        comparison = 0;
        assignment = 0;
        
        for(int i = 0; i <arr.length; i++) {
            for (int k = 0; k < arr.length - 1 - i; k++) {
                comparison++;
                if (arr[k] > arr[k+1]) {
                    int swap = arr[k+1];
                    arr[k+1] = arr[k];
                    arr[k] = swap;
                    
                    assignment += 3; 
                }
            }
        } 
        System.out.print(", " + comparison + ", " + assignment);
    }
    
    public static void selectionSort(int[] arr) {
        //find minamum 
        //put it at the front. (swap) 
        //adjust for loop
        comparison = 0;
        assignment = 0;
        
        for (int i = 0; i < arr.length; i++) {
            //find minamum algo
            int min = arr[i];
            int minIndex = i; 
            
            assignment += 2;
            for (int k = i+1; k < arr.length; k++) {
                comparison++;
                if (arr[k] < min) {
                    min = arr[k];
                    minIndex = k;
                    
                    assignment += 2;
                }
            }
            int swap = arr[i];
            arr[i] = min;
            arr[minIndex] = swap;
            
            assignment += 3;
        }
        System.out.print(", " + comparison + ", " + assignment);
    }
    
    public static void insertionSort(int[] arr) {
        comparison = 0;
        assignment = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int k = i - 1; 
            int insrtValue = arr[i];
            //could do assignment + 1 
            comparison++;
            while (k >= 0 && insrtValue < arr[k]) {
                arr[k+1] = arr[k];
                k--;
                
                assignment++;
                comparison++;
            }
            arr[k+1] = insrtValue;
            
            assignment++;
        }
        System.out.print(", " + comparison + ", " + assignment);
    }
    
    public static void mergeSort(int[] arr) {
        comparison = 0;
        assignment = 0;
        
        mergeSort(arr, 0, arr.length-1);
        System.out.print(", " + comparison + ", " + assignment);        
    }
    
    public static void mergeSort(int[] arr, int beg, int end) {
        comparison++;
        if (beg == end) {
            return;
        } else {
            int mid = (beg + end)/2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
            
            assignment += 4;
        }
    }
    
    public static void merge(int[] arr, int beg, int mid, int end)
    {
        int[] temp = new int[end - beg + 1 ]; //arr.length - 1? 
        int tempCur = 0;
        int rightCur = mid + 1;
        int leftCur = beg;
        
        comparison++;
        while (leftCur <= mid && rightCur <= end) {
            comparison++;
            if (arr[leftCur] < arr[rightCur]) {
                temp[tempCur] = arr[leftCur];
                tempCur++;
                leftCur++;
                
                assignment ++;
            } else {
                temp[tempCur] = arr[rightCur];
                tempCur++;
                rightCur++;
                
                assignment++;
            }
            comparison++;
        }
        comparison++;
        while (leftCur <= mid) {
            temp[tempCur] = arr[leftCur];
            tempCur++;
            leftCur++;
            
            assignment ++;
            comparison++;
        }
        comparison++;
        while (rightCur <= end) {
            temp[tempCur] = arr[rightCur];
            tempCur++;
            rightCur++;
            
            assignment ++;
            comparison++;
        }   
        //copy temp over to array
        for (int k = 0; k < temp.length; k++) {
            arr[k+beg] = temp[k];
            
            assignment++;
        }
    }
    
    public static void quickSort(int[] arr) {
        comparison = 0;
        assignment = 0;
        
        quickSort(arr, 0, arr.length-1);
        System.out.print(", " + comparison + ", " + assignment);
    }
    
    public static void quickSort(int[] arr, int beg, int end) {
        comparison++;
        if (end <= beg) {
            return;
        } else {
            //middle value of array
            int pivotIndex = partition(arr, beg, end);
            quickSort(arr, beg, pivotIndex -1);
            quickSort(arr, pivotIndex+1, end);
            
            assignment += 3;
        }
    }
    
    public static int partition(int[] arr, int beg, int end)
    {
        int pivotIndex = (int)(Math.random() * (end-beg)) + beg;
        int swap = arr[end];
        arr[end] = arr[pivotIndex];
        arr[pivotIndex] = swap;
        
        int pivotVal = arr[end];
        int leftCur = beg;
        int rightCur = end - 1;
        
        assignment += 4; 
        
        do {
            comparison++; 
            while(arr[leftCur] < pivotVal) {
                leftCur++;
                comparison++;
            }
            comparison++;
            while (arr[rightCur] > pivotVal && rightCur > beg) {
                rightCur--;
                
                comparison++;
            }
            comparison++;
            if (leftCur < rightCur) {
                int swap3 = arr[leftCur];
                arr[leftCur] = arr[rightCur];
                arr[rightCur] = swap3;
                leftCur++;
                
                assignment += 3;
            }
            comparison++;
        } while(leftCur < rightCur);
        //pivotIndex is a random number. End is where the pivot Value is Stored. 
        pivotIndex = leftCur;
        int swap2 = arr[end];
        arr[end] = arr[pivotIndex];
        arr[pivotIndex] = swap2;
        
        assignment += 3; 
    
        return pivotIndex; 
    }
 }      
