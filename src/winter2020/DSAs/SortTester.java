package winter2020.DSAs;

public class SortTester {
    CoreData cd;

    public SortTester(CoreData data){
        cd = data;
    }


    public void selectionSort(int[] testData){
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

    public void insertionSort(int[] testData){
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

    public void mergeSort(int[] testData, int n){
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

    public void merge(int[] testData, int[] l, int[] r, int left, int right){
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

    public void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
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


    public long sortTimer(int[] testData, String choice){
        long start = 0, end = 0;

        switch (choice) {
            case "s":
                start = System.nanoTime();
                selectionSort(testData);
                end = System.nanoTime();
                break;
            case "i":
                start = System.nanoTime();
                insertionSort(testData);
                end = System.nanoTime();
                break;
            case "m":
                start = System.nanoTime();
                mergeSort(testData, testData.length);
                end = System.nanoTime();
                break;
            case "q":
                start = System.nanoTime();
                quickSort(testData, 0, testData.length - 1);
                end = System.nanoTime();
                break;
        }

        return end - start;
    }

    public void testSorts(String title, int testSize){
        String[] labels = {"\tSelection sort: ", "\tInsertion sort: ", "\tMerge sort: ", "\tQuick sort: "};
        String[] selectors = {"s", "i", "m", "q"};

        System.out.println(title);

        if (testSize > 999999){
            for (int i = 0; i < 4; i++){
                System.out.print(labels[i]);
                System.out.printf("%,f", sortTimer(cd.getDataSlice(testSize), selectors[i]) / 1000000.0);
                System.out.println(" ms");
            }

        }
        else {
            for (int i = 0; i < 4; i++){
                System.out.print(labels[i]);
                System.out.printf("%,d", sortTimer(cd.getDataSlice(testSize), selectors[i]));
                System.out.println(" ns");
            }

        }
    }

}
