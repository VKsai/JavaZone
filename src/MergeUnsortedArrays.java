public class MergeUnsortedArrays {

    private static int partition(int[] arr, int low, int high) {
        int i = low - 1;
        int j = low;
        int pivot = arr[high];
        while (j < high) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        swap(arr, i + 1, high);

        return i + 1;
    }

    private static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void applyQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);

            applyQuickSort(arr, low, partition - 1);
            applyQuickSort(arr, partition + 1, high);
        }
    }

    public static void main(String args[]) {
        int[] arr1 = {1, 100, 2, 1, 10};
        int[] arr2 = {3, 5, 1, 2};
        int[] result = new int[arr1.length + arr2.length];

        applyQuickSort(arr1, 0, arr1.length - 1);
        applyQuickSort(arr2, 0, arr2.length - 1);

        mergeArrays(arr1, arr2, result);

        printArr(result);
    }

    private static void mergeArrays(int[] arr1, int[] arr2, int result[]) {
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                result[k] = arr1[i];
                k = k + 1;
                result[k] = arr2[j];
                k++;
                i++;
                j++;
                continue;
            } else if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                k++;
                i++;
                continue;
            } else if (arr1[i] > arr2[j]) {
                result[k] = arr2[j];
                k++;
                j++;
                continue;
            }
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            k++;
            i++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            k++;
            j++;
        }
    }

    private static void printArr(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}
