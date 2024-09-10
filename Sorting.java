public class Sorting
{
    // instance variables - replace the example below with your own

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
        } }
 }      