package driver;

import java.util.*;

import mergesort.MergeSort;

public class Driver {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the size of currency denominations : ");
        int sizeOfCurrency = userInput.nextInt();
        int[] valueOfCurrency = new int[sizeOfCurrency];
        System.out.println("Enter the currency denominations value : ");
        for (int i = 0; i < sizeOfCurrency; i++) {
            valueOfCurrency[i] = userInput.nextInt();
        }
        MergeSort.MergeSortArray(valueOfCurrency, 0, sizeOfCurrency - 1);

        System.out.println("Enter the amount you want to pay : ");
        int payAmount = userInput.nextInt();
        int q = 0;
        // int r = 0;
        int[] noOfNotes = new int[sizeOfCurrency];
        for (int i = sizeOfCurrency - 1; i >= 0; i--) {
            if (valueOfCurrency[i] <= payAmount) {
                q = payAmount / valueOfCurrency[i];
                payAmount = payAmount % valueOfCurrency[i];
                noOfNotes[i] = q;
                // System.out.println("noOfNotes = " + noOfNotes[i]);
            }
        }
        if (payAmount == 0) {
            for (int i = 0; i < sizeOfCurrency; i++) {
                if (noOfNotes[i] != 0)
                    System.out.println(valueOfCurrency[i] + ":" + noOfNotes[i]);
            }
        } else
            System.out.println("Amount is not payable");

        userInput.close();

    }

    public static void MergeSortArray(int[] arr, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            MergeSortArray(arr, first, mid);
            MergeSortArray(arr, mid + 1, last);
            Merge(arr, first, mid, last);
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
            if (leftArray[i] >= rightArray[j]) {
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
