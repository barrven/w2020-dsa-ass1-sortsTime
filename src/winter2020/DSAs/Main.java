package winter2020.DSAs;

public class Main {

    public static void printArray(int[] array){
        int size = array.length;
        for (int i = 0; i < size; i++){
            System.out.println(array[i]);
        }
    }

    public static void selectionSort(int[] testData){
        int len = testData.length;
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
    }

    public static void insertionSort(int[] testData){
        int len = testData.length;
        for (int i = 1; i < len; i++){
            int temp = testData[i];
            int j = i-1;
            while (j > -1 && testData[j] > temp){
                testData[j+1] = testData[j];
                j--;
            }
            testData[j+1] = temp;
        }
    }

    public static void mergeSort(int[] testData, int n){
        if (n == 1) return;
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n-mid];

        for (int i = 0; i < mid; i++){
            l[i] = testData[i];
        }
        for (int i = mid; i < n; i++){
            r[i - mid] = testData[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n-mid);
        merge(testData, l, r, mid, n-mid);
    }

    public static void merge(int[] testData, int[] l, int[] r, int left, int right){
        int i = 0, j = 0, k = 0;
        while (i < left && j < right){
            if (l[i] <= r[j])
                testData[k++] = l[i++];
            else
                testData[k++] = r[j++];
        }
        while (i < left){
            testData[k++] = l[i++];
        }
        while (j < right){
            testData[k++] = r[j++];
        }
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    public static void main(String[] args) {

        CoreData cd = new CoreData(1000000);
        SortTester st = new SortTester(cd);

        st.testSelectionSort("FIFTY INTEGERS", 50);


//        System.out.println("FIFTY INTEGERS");
//        System.out.print("\tSelection sort: ");
//        System.out.printf("%,d", timeSelectionSort(cd.getDataSlice(50)));
//        System.out.println(" ns");
//
//        System.out.print("\tInsertion sort: ");
//        System.out.printf("%,d", timeInsertionSort(cd.getDataSlice(50)));
//        System.out.println(" ns");
//
//        System.out.print("\tMerge sort: ");
//        System.out.printf("%,d", timeMergeSort(cd.getDataSlice(50)));
//        System.out.println(" ns");
//
//        System.out.println("ONE THOUSAND INTEGERS");
//        System.out.print("\tSelection sort: ");
//        System.out.printf("%,d", timeSelectionSort(cd.getDataSlice(1000)));
//        System.out.println(" ns");
//
//        System.out.print("\tInsertion sort: ");
//        System.out.printf("%,d", timeInsertionSort(cd.getDataSlice(1000)));
//        System.out.println(" ns");
//
//        System.out.print("\tMerge sort: ");
//        System.out.printf("%,d", timeMergeSort(cd.getDataSlice(1000)));
//        System.out.println(" ns");
//
//        System.out.println("TEN THOUSAND INTEGERS");
//        System.out.print("\tSelection sort: ");
//        System.out.printf("%,d", timeSelectionSort(cd.getDataSlice(10000)));
//        System.out.println(" ns");
//
//        System.out.print("\tInsertion sort: ");
//        System.out.printf("%,d", timeInsertionSort(cd.getDataSlice(10000)));
//        System.out.println(" ns");
//
//        System.out.print("\tMerge sort: ");
//        System.out.printf("%,d", timeMergeSort(cd.getDataSlice(10000)));
//        System.out.println(" ns");
//
//        System.out.println("ONE HUNDRED THOUSAND INTEGERS");
//        System.out.print("\tSelection sort: ");
//        System.out.printf("%,d", timeSelectionSort(cd.getDataSlice(100000)));
//        System.out.println(" ns");
//
//        System.out.print("\tInsertion sort: ");
//        System.out.printf("%,d", timeInsertionSort(cd.getDataSlice(100000)));
//        System.out.println(" ns");
//
//        System.out.print("\tMerge sort: ");
//        System.out.printf("%,d", timeMergeSort(cd.getDataSlice(100000)));
//        System.out.println(" ns");
//
//        System.out.println("ONE MILLION INTEGERS");
//        System.out.print("\tSelection sort: ");
//        System.out.printf("%,f", timeSelectionSort(cd.getDataSlice(1000000)) / 1000000.0);
//        System.out.println(" ms");
//
//        System.out.print("\tInsertion sort: ");
//        System.out.printf("%,f", timeInsertionSort(cd.getDataSlice(1000000)) / 1000000.0);
//        System.out.println(" ms");
//
//        System.out.print("\tMerge sort: ");
//        System.out.printf("%,f", timeMergeSort(cd.getDataSlice(1000000)) / 1000000.0);
//        System.out.println(" ms");

    }



    public static long timeSelectionSort(int[] testData){
        long start = System.nanoTime();
        selectionSort(testData);
        long end = System.nanoTime();
        return end - start;
    }

    public static long timeInsertionSort(int[] testData){
        long start = System.nanoTime();
        insertionSort(testData);
        long end = System.nanoTime();
        return end - start;
    }

    public static long timeMergeSort(int[] testData){
        long start = System.nanoTime();
        mergeSort(testData, testData.length);
        long end = System.nanoTime();
        return end - start;
    }

    public static long timeQuickSort(int[] testData){
        int begin = 0;
        int end = testData.length;
        long start = System.nanoTime();
        quickSort(testData, begin, end);
        long finish = System.nanoTime();
        return finish - start;
    }

}
