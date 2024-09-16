public class Sorting
{
    // instance variables - replace the example below with your own
    //fg

    public static void bubbleSort(int[] unsorted)
    {
        for(int i = 0; i <unsorted.length; i++)
        {
            for (int k = 0; k < unsorted.length - 1 - i; k++)
            {
                if (unsorted[k] > unsorted[k+1])
                {
                    int swap = unsorted[k+1];
                    unsorted[k+1] = unsorted[k];
                    unsorted[k] = swap;
                }
            }
        } 
    }
    
    public static void selectionSort(int[] arr)
    {
        //find minamum 
        //put it at the front. (swap) 
        //adjust for loop
        
        for (int i = 0; i < arr.length; i++)
        {
            //find minamum algo
            int min = arr[i];
            int minIndex = i; 
            
            for (int k = i+1; k < arr.length; k++)
            {
                if (arr[k] < min)
                {
                    min = arr[k];
                    minIndex = k; 
                }
            }
            int swap = arr[i];
            arr[i] = min;
            arr[minIndex] = swap;
        }
        
    }
    public static void insertionSort(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
        {
            int k = i - 1; 
            int iValue = arr[i];
            while (k >= 0 && iValue < arr[k])
            {
                int swap = arr[k+1];
                arr[k+1] = arr[k];
                arr[k] = swap;
                k--;
            }
        }  
    }
    
    public static void mergeSort(int[] arr)
    {
        mergeSort(arr, 0, arr.length-1);
    }
    public static void mergeSort(int[] arr, int beg, int end)
    {
        if (beg == end)
        {
            return;
        }
        else
        {
            int mid = (beg + end)/2;
            mergeSort(arr, beg, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }
    public static void merge(int[] arr, int beg, int mid, int end)
    {
        int[] temp = new int[end - beg + 1 ]; //arr.length - 1? 
        int tempCur = 0;
        int rightCur = mid + 1;
        int leftCur = beg; 
        while (leftCur <= mid && rightCur <= end)
        {
            if (arr[leftCur] < arr[rightCur])
            {
                temp[tempCur] = arr[leftCur];
                tempCur++;
                leftCur++;
            }
            else
            {
                temp[tempCur] = arr[rightCur];
                tempCur++;
                rightCur++;
            }
        }
        
        while (leftCur <= mid)
        {
            temp[tempCur] = arr[leftCur];
            tempCur++;
            leftCur++;
        }
        while (rightCur <= end)
        {
            temp[tempCur] = arr[rightCur];
            tempCur++;
            rightCur++;
        }   
        //copy temp over to array
        for (int k = 0; k < temp.length; k++)
        {
            arr[k+beg] = temp[k];
        }
    }
    public static void quickSort(int[] arr)
    {
        quickSort(arr, 0, arr.length-1);
    }
    public static void quickSort(int[] arr, int beg, int end)
    {
        if (end <= beg)
        {
            return;
        }
        else
        {
            //middle value of array
            int pivotIndex = partition(arr, beg, end);
            quickSort(arr, beg, pivotIndex -1);
            quickSort(arr, pivotIndex+1, end);
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
        
        do
        {
            while(arr[leftCur] < pivotVal)
            {
                leftCur++;
            }
            while (arr[rightCur] > pivotVal && rightCur > beg)
            {
                rightCur--;
            }
            if (leftCur < rightCur)
            {
                int swap3 = arr[leftCur];
                arr[leftCur] = arr[rightCur];
                arr[rightCur] = swap3; 
            }
        }
        while(leftCur < rightCur);
        
        //pivotIndex is a random number. End is where the pivot Value is Stored. 
        pivotIndex = leftCur;
        
         int swap2 = arr[end];
         arr[end] = arr[pivotIndex];
         arr[pivotIndex] = swap2; 
         
         return pivotIndex; 
    }
 }      
