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

}
