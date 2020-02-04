package winter2020.DSAs;

public class Main {

    public static void printArray(int[] array){
        int size = array.length;
        for (int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        CoreData cd = new CoreData(1000000);
        int[] fifty = cd.getDataSlice(50);
        int[] oneK = cd.getDataSlice(1000);
        int[] tenK = cd.getDataSlice(10000);
        int[] hundredK = cd.getDataSlice(100000);
        int[] oneM = cd.getDataSlice(1000000);

        double x = cd.insertionSort(fifty) / 1000000.0;

        System.out.println(x);
    }
}
