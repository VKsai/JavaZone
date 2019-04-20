package bbb;

class LLNode {
    int data;
    LLNode next;

    public LLNode(int data) {
        this.data = data;
    }
}

public class NToLastLL {

    private static int getLength(LLNode head) {
        int length = 0;
        for (;head.next!=null;head=head.next) {
            length++;
        }
        return length;
    }

    private static void printLLIndex(LLNode head, int n) {
        int length = getLength(head);
        if (n <= length) {
            int i = 0;
            while (i < length && i != n) {
                head = head.next;
                i++;
            }
            System.out.println(head.data);
        }
    }

    public static void main(String[] args) {
        LLNode head = new LLNode(12);
        head.next = new LLNode(1);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(23);
        head.next.next.next.next = null;

        printLLIndex(head, 334);
    }
}
