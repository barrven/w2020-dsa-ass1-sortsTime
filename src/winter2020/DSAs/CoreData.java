package winter2020.DSAs;

import java.util.Random;

public class CoreData {
    private int size;
    private int maxSize;
    private int[] data;

    public CoreData(int maxSize){
        this.maxSize = maxSize;
        size = 0;
        data = new int[maxSize];

        //fill array with random numbers
        Random rand = new Random();
        for (int i = 0; i < maxSize; i++){
            data[i] = rand.nextInt(3000000) +1 ;
            size++;
        }
    }

    public int[] getDataSlice(int sliceSize){
        int[] out = new int[sliceSize];
        System.arraycopy(data, 0, out, 0, sliceSize);
        return out;
    }

    public long selectionSort(int[] testData){
        int len = testData.length;
        long start = System.nanoTime();
        System.out.println("Beginning sort...");
        for (int i = 0; i < len-1; i++){
            int sm = i;
            for (int j = i+1; j < len; j++){
                if (testData[j] < testData[sm])
                    sm = j;
            }
            int temp = testData[i];
            testData[i] = testData[sm];
            testData[sm] = temp;
        }

        System.out.println("Sort ended");
        long end = System.nanoTime();
        return end - start;
    }

    public long insertionSort(int[] testData){
        int len = testData.length;
        long start = System.nanoTime();

        for (int i = 1; i < len; i++){
            int temp = testData[i];
            int j = i-1;
            while (j > -1 && testData[j] > temp){
                testData[j+1] = testData[j];
                j--;
            }
            testData[j+1] = temp;
        }

        long end = System.nanoTime();
        return end - start;
    }

}
