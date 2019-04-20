public class Fibonacci {

    private static int[] arr = new int[4];

    private static int fib(int n) {
        if (n == 0) return 0;

        if (n == 1) return 1;

        if (arr[n] != -1) return arr[n];
        else arr[n] = n;

        return fib(n-1) + fib(n-2);
    }

    public static void main(String args[]) {
        for (int i=0; i<arr.length; i++) {
            arr[i] = -1;
        }
        System.out.println(fib(4));
    }
}
