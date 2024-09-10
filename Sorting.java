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
 }      
