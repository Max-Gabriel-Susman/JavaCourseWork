import java.util.Arrays;
/**
 * Assignment 4 for CS 1410
 * This program evaluates the linear and binary searching, along
 * with comparing performance difference between the selection sort
 * and the built-in java.util.Arrays.sort.
 *
 */
public class EvaluationDriver {
    static final int MAX_VALUE = 1_000_000;
    static final int MAX_ARRAY_SIZE = 100_000;
    static final int ARRAY_INCREMENT = 20_000;
    static final int NUMBER_SEARCHES = 50_000;

    public static void main(String[] args) {
        System.out.println("--- Linear Search Timing (unsorted) ---");
        for(int i = 20000; i <= 100000; i += 20000)
        {
            System.out.println("Number of items       : " + String.valueOf(i));
            long before = System.currentTimeMillis();

            long after = System.currentTimeMillis();
            long time = after - before;
            System.out.println("Times value was found : " + String.valueOf(i));
            System.out.println("Total search time     : " + String.valueOf(time));
            System.out.println("");
        }
        System.out.println("--- Linear Search Timing (Selection Sort) ---");
        for(int i = 20000; i <= 100000; i += 20000)
        {
            System.out.println("Number of items       : " + String.valueOf(i));
            long before = System.currentTimeMillis();

            long after = System.currentTimeMillis();
            long time = after - before;
            System.out.println("Times value was found : " + String.valueOf(i));
            System.out.println("Total search time     : " + String.valueOf(time));
            System.out.println("");
        }
        System.out.println("--- Binary Search Timing (Selection Sort) ---");
        for(int i = 20000; i <= 100000; i += 20000)
        {
            System.out.println("Number of items       : " + String.valueOf(i));
            long before = System.currentTimeMillis();

            long after = System.currentTimeMillis();
            long time = after - before;
            System.out.println("Times value was found : " + String.valueOf(i));
            System.out.println("Total search time     : " + String.valueOf(i));
            System.out.println("");
        }
        System.out.println("--- Binary Search Timing (Arrays.sort) ---");
        for(int i = 20000; i <= 100000; i += 20000)
        {
            System.out.println("Number of items       : " + String.valueOf(i));
            long before = System.currentTimeMillis();

            long after = System.currentTimeMillis();
            long time = after - before;
            System.out.println("Times value was found : " + String.valueOf(i));
            System.out.println("Total search time     : " + String.valueOf(i));
            System.out.println("");
        }
    }

    public static int[] generateNumbers(int howMany, int maxValue)
    {
        if(howMany <= 0)
        {
            return null;
        }

        int[] generatedArray = new int[howMany];

        for(int i = 0; i < howMany; i ++)
        {
            generatedArray[i] = (int)(Math.random() * maxValue);
        }

        return generatedArray;
    }

    public static boolean linearSearch(int[] data, int search)
    {
        boolean found = false;
        for(int i = 0; i < data.length; i++)
        {
            if(data[i] == search)
            {
                found = true;
                break;
            }

        }
        return found;
    }

    public static boolean binarySearch(int[] data, int search)
    {
        int lower = 0;
        int upper = data.length - 1;

        boolean found = false;
        while(!found && lower <= upper)
        {
            int middle = (lower + upper) / 2;
            if(data[middle] == search)
            {
                found = true;
                break;
            }
            if(data[middle] < search)
            {
                lower = middle + 1;
            }
            else
            {
                upper = middle - 1;
            }
        }

        return found;
    }

    public static void selectionSort(int[] data)
    {
        for(int start = 0; start <= data.length - 1; start ++)
        {
            int minPos = start;

            for(int scan = start + 1; scan < data.length; scan ++)
            {
                if(data[scan] < data[minPos])
                {
                    minPos = scan;
                }
            }

            int temp = data[start];

            data[start] = data[minPos];

            data[minPos] = temp;
        }
    }

    public static void demoLinearSearchUnsorted(int NUMBER_SEARCHES, int MAX_VALUE)
    {


        for(int i = ARRAY_INCREMENT ; ARRAY_INCREMENT < MAX_ARRAY_SIZE; i += ARRAY_INCREMENT)
        {
            int[] generatedNumbers = generateNumbers(i, MAX_VALUE);

            for(int j = 0; j < NUMBER_SEARCHES; j ++)
            {
                linearSearch(generatedNumbers, (int)(Math.random() * MAX_VALUE));
            }
        }
    }

    public static void demoLinearSearchSorted(int NUMBER_SEARCHES, int MAX_VALUE)
    {
        for(int i = ARRAY_INCREMENT ; ARRAY_INCREMENT < MAX_ARRAY_SIZE; i += ARRAY_INCREMENT)
        {
            int[] generatedNumbers = generateNumbers(i, MAX_VALUE);

            selectionSort(generatedNumbers);

            for(int j = 0; j < NUMBER_SEARCHES; j ++)
            {
                linearSearch(generatedNumbers, (int)(Math.random() * MAX_VALUE));
            }
        }
    }

    public static void demoBinarySearchSelectionSort(int NUMBER_SEARCHES, int MAX_VALUE)
    {
        for(int i = ARRAY_INCREMENT ; ARRAY_INCREMENT < MAX_ARRAY_SIZE; i += ARRAY_INCREMENT)
        {
            int[] generatedNumbers = generateNumbers(i, MAX_VALUE);

            selectionSort(generatedNumbers);

            for(int j = 0; j < NUMBER_SEARCHES; j ++)
            {
                binarySearch(generatedNumbers, (int)(Math.random() * MAX_VALUE));
            }
        }
    }

    public static void demoBinarySearchFastSort(int NUMBER_SEARCHES, int MAX_VALUE)
    {
        for(int i = ARRAY_INCREMENT ; ARRAY_INCREMENT < MAX_ARRAY_SIZE; i += ARRAY_INCREMENT)
        {
            int[] generatedNumbers = generateNumbers(i, MAX_VALUE);

            java.util.Arrays.sort(generatedNumbers);

            for(int j = 0; j < NUMBER_SEARCHES; j ++)
            {
                binarySearch(generatedNumbers, (int)(Math.random() * MAX_VALUE));
            }
        }
    }
}
