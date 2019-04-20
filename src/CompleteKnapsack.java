import java.util.Arrays;

public class CompleteKnapsack {
    static void printknapSack(int W, int wt[],
                              int val[], int n) {
        int arr[][] = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) arr[i][j] = 0;
                else if (j < wt[i - 1]) arr[i][j] = arr[i - 1][j];
                else {
                    arr[i][j] = Math.max(val[i - 1] + arr[i - 1][j - wt[i - 1]], arr[i - 1][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        printItemsSelected(arr, n, W, val, wt);
    }

    private static void printItemsSelected(int[][] arr, int n, int W, int val[], int wt[]) {
        int res = arr[n][W];
        System.out.println(res);

        int w = W;
        for (int i = n; i > 0 && res > 0; i--) {
            if (res == arr[i-1][w]) continue;
            else {
                System.out.println(wt[i-1]+" ");
                res = res - val[i-1];
                w = w - wt[i-1];
            }
        }
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String args[]) {
        int val[] = new int[]{1, 4, 5, 7};
        int wt[] = new int[]{1, 3, 4, 5};
        int W = 7;
        int n = val.length;
        printknapSack(W, wt, val, n);
    }
}
