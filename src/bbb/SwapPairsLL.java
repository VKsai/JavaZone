package bbb;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class SwapPairsLL {

    static ListNode head;

    private ListNode insert(int val) {
        if (head == null) { head = new ListNode(val); return head;}
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);

        return head;
    }

    private ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode prev = head;
        ListNode pred = head.next;

        if (pred == null) {
            return prev;
        }

        swapPairsRecursively(prev, pred);

        return head;
    }

    private void swapPairsRecursively(ListNode prev, ListNode pred) {
        if ((pred.next == null && prev.next.next == null) || prev.next.next.next == null) {
            swapValues(prev, pred);
            return;
        }

        swapPairsRecursively(prev.next.next, pred.next.next);
        swapValues(prev, pred);
    }

    private void swapValues(ListNode prev, ListNode pred) {
        int temp = prev.val;
        prev.val = pred.val;
        pred.val = temp;
    }

    private static void printList(ListNode head) {
        if (head == null) return;

        System.out.print(head.val+" ");
        printList(head.next);
    }

    public static void main(String[] args) {
        SwapPairsLL swapPairsLL = new SwapPairsLL();

        head = swapPairsLL.insert(1);

        swapPairsLL.swapPairs(head);

        printList(head);
    }
}
