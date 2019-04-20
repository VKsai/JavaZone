package bbb;

public class MedianEqualArrays {
    public static void main(String args[]) {
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};
        int n1 = ar1.length;
        int n2 = ar2.length;
        if (n1 == n2)
            System.out.println("Median is " + getMedian(ar1, ar2));
        else
            System.out.println("Doesn't work for arrays " + "of unequal size");
    }

    private static double getMedian(int[] arr1, int[] arr2) {
        int i = 0, n1 = arr1.length;
        int j = 0, n2 = arr2.length;
        int k = 0;
        int res[] = new int[n1+1];

        while (i<n1 && j<n2) {
            if (arr1[i] < arr2[j]) {
                res[k] = arr1[i];
                k++; i++;
            } else if (arr1[i] > arr2[j]) {
                res[k] = arr2[j];
                k++; j++;
            }

            if (k == n1+1) break;
        }

        return (res[n1-1]+res[n1]) / 2.0;
    }
}
