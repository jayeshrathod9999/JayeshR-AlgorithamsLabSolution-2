package mergesort;

public class MergeSort {

    // public int[] sortedArray = new int[];
    public static void MergeSortArray(int[] arr, int first, int last) {

        // long start = System.nanoTime();
        if (first < last) {

            // int len = arr.length;
            int mid = (first + last) / 2;
            MergeSortArray(arr, first, mid);
            MergeSortArray(arr, mid + 1, last);
            Merge(arr, first, mid, last);

        }
        // long end = System.nanoTime();
        // long milliseconds = end - start;
        // PrintedSortedArray(arr);
        System.out.println();
        // System.out.println("Amount of time required to do Merge Sort : " +
        // milliseconds + " nano seconds.");

    }

    public static void PrintedSortedArray(int[] arr) {
        // System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void Merge(int[] arr, int first, int mid, int last) {

        int len1 = mid - first + 1;
        int len2 = last - mid;

        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];

        for (int i = 0; i < len1; i++) {
            leftArray[i] = arr[first + i];
        }
        for (int j = 0; j < len2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = first;
        while ((i < len1) && (j < len2)) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
                k++;
            } else {
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }
        while (j < len2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
        while (i < len1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

    }

}
