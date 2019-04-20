public class ReverseKNodes {

    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    private static Node head;

    private void push(int data) {
        Node n = new Node(data);

        if (head == null) {
            head = n;
            head.next = null;
        } else {
            Node first = head;
            while (head.next != null) {
                head = head.next;
            }
            head.next = n;
            n.next = null;
            head = first;
        }
    }

    private void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    private Node reverse(Node head, int k) {
        int n = 0;
        while (head.next != null) {
            n++;
        }
        if (k == 0 || k > n) return head;

        Node kList = null;
        while (k != 0) {
            if (kList == null) {
                kList = new Node(head.data);
                head = head.next;
                k--;
            } else {
                Node temp = kList;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = new Node(head.data);
                head = head.next;
                k--;
            }
        }
        Node headTemp = head;
        while (headTemp.next != null) {
            headTemp = headTemp.next;
        }
        headTemp.next = kList;

        return head;
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {
        ReverseKNodes llist = new ReverseKNodes();

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);
        llist.push(6);
        llist.push(7);
        llist.push(8);
        llist.push(9);

        llist.head = llist.reverse(llist.head, 3);

        System.out.println("Reversed list");
        llist.printList();
    }
}
