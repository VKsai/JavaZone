public class ReversrString {
    public static void reverseString(char[] s) {
        //s = abc
        reverseRecusively(s, 0, s.length-1);

        for (char c: s) System.out.print(c);
    }

    private static void reverseRecusively(char[] s, int start, int end) {
        if (start >= end) return;

        reverseRecusively(s, start+1, end-1);
        swap(s, start, end);
    }

    private static void swap(char[] s, int start, int end) {
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
    }

    public static void main(String[] args) {
        reverseString("abc".toCharArray());
    }
}
