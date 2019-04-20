import java.util.*;
public class MergeKSortedLists {
    static class Node implements Comparable<Node> {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public int compareTo(Node o) {
            return this.data > o.data ?1:-1;
        }

        @Override
        public int hashCode() {
            return this.data;
        }

        @Override
        public boolean equals(Object obj) {
            return this.hashCode() == obj.hashCode();
        }
    }

    private static Node mergeKLists(Node[] arr, int k) {
        boolean done = false;
        Node result = null;
        while(!done){

            Map<Node, Integer> tempMap =  new HashMap<>();
            List<Node> tempList;

            for (int i = 0; i < arr.length; i++){
                if(arr[i]  == null){
                    continue;
                }
                tempMap.put(arr[i], i);
            }

            if(tempMap.size() ==0){
                done = true;
                continue;
            }else {
                tempList  = new ArrayList<>(tempMap.keySet());
                Collections.sort(tempList);
            }

            Node item = new Node(tempList.get(0).data);
            arr[tempMap.get(item)] = arr[tempMap.get(item)].next;
            if(result == null){
              result = item;
            } else {
                boolean reachedLast = false;
                Node last = result;
                while(!reachedLast){
                    if(last.next == null){
                        reachedLast = true;
                    } else {
                        last = last.next;
                    }
                }
                last.next = item;
            }

        }

        return result;
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

        while(head != null){
            System.out.print(head.data+"        ");
            head = head.next;
        }
    }
}
