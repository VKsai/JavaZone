public class MergeKSortedListsRecursion {

    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    /* Function to print nodes in a given linked list */
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    private static Node SortedMerge(Node a, Node b) {
        Node result;
        if (a == null) return b;
        else if (b == null) return a;

        if(a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        } else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }

        return result;
    }

    private static Node mergeKLists(Node[] arr, int k) {
        while (k != 0) {
            int i = 0, j = k;

            while (i < j) {
                arr[i] = SortedMerge(arr[i], arr[j]);
                i++;
                j--;

                if (i >= j) {
                    k = j;
                }
            }
        }
        return arr[0];
    }

    public static void main(String args[]) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        Node arr[] = new Node[k];

        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge all lists
        Node head = mergeKLists(arr, k - 1);
        printList(head);
    }

}
