public class HeapSort {

    private void heapify(int[] arr, int n, int current) {
        int largest = current;
        int left = current * 2 + 1;
        int right = current * 2 + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        } else if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest!=current){
            swap(arr, largest, current);
            heapify(arr, n, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void sort(int[] arr) {
        int len = arr.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, len, i);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 7, 6};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
