public class Test
{
    public static void testBubble()
    {
        int[] arr = {95, 80, 99, 88, 47, 77, 5, 37,  37, 9, 92, 87, 58, 65, 91, 28, 73, 59, 72, 48, 76, 85, 23, 36, 75, 93, 43, 8, 22, 96, 78, 33, 70, 16, 21, 2,
             41, 6, 20, 7, 10, 98, 1, 42, 83, 71, 54, 67, 17, 50, 100, 49, 19};
        Methods.bubbleSort(arr);
        String aStr = " ";
        for (int i = 0; i < arr.length; i++)
        {
            aStr = aStr + arr[i] + " ";
        }
        System.out.println(aStr);
        
    }
}
