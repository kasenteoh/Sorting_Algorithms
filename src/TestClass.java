import java.util.Random;

/**
 * Tests run time of quick sort by creating and copying arrays of different sizes with different recursion limits
 * @author Kasen Teoh
 *
 */
public class TestClass
{
    public static void main(String[] args)
    {
        int arraySize = 20000;
        long startTime, estimatedTime;

        while(arraySize <= 10000000)
        {
            Integer [] original = initialiseArray(arraySize);

            int recursionLimit = 2;
            while(recursionLimit <= 300)
            {
                Integer [] copy = original.clone();

                startTime = System.nanoTime();

                sortedArray(copy, recursionLimit);
                estimatedTime = System.nanoTime() - startTime;
                System.out.println("Array Size: " + copy.length
                        + "\n" + "Recursion Limit: " + recursionLimit
                        + "\n" + "Algorithm Elapsed Time: " + TimeConverter.convertTimeToString(estimatedTime)
                        + "\n");

                recursionLimit += 2;    //Increasing by 2
            }
            arraySize += 500000;    //After each iteration increase by 500,000 so we can get to around 10 million in 20 iterations
        }
    }

    /**
     * Initialises the array to a random number of elements
     * @param arraySize The size of the array i.e 20,000; 520,000; 102,000; etc
     * @return  Returns the array
     */
    public static Integer[] initialiseArray(int arraySize){
        Integer[] testArray;
        testArray = new Integer[arraySize];

        Random randomGenerator = new Random();

        int number = 1;

        for(int i = 0; i < testArray.length; i++)
        {
            testArray[i] = randomGenerator.nextInt(number);
            number = number + 1 ;
        }
        return testArray;
    }

    /**
     * Sorts the array
     * @param arrayToBeSorted The array that needs to be sorteed
     * @param recursionLimit    The recursion limit i.e 2, 4, 6, 8 etc
     * @return  Returns the sorted array
     */
    public static Integer[] sortedArray(Integer[] arrayToBeSorted, int recursionLimit)
    {
        FHsort.setRecursionLimit(recursionLimit);
        FHsort.quickSort(arrayToBeSorted);
        return arrayToBeSorted;
    }
}