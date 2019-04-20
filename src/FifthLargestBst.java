class FifthTreeNode {
    int data;
    FifthTreeNode left, right;

    public FifthTreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class FifthLargestBst {

    static FifthTreeNode root;

    public FifthLargestBst() {
        this.root = null;
    }

    private FifthTreeNode insert(int value) {
        FifthTreeNode x = root;
        FifthTreeNode y = null;

        while (x != null) {
            y = x;
            if (x.data > value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            y = new FifthTreeNode(value);
        } else if (y.data < value) {
            y.right = new FifthTreeNode(value);
        } else {
            y.left = new FifthTreeNode(value);
        }
        return y;
    }

    private void kthLargest(FifthTreeNode root, int k) {
        if (root.right == null) return;

    }

    private static void printInorder(FifthTreeNode root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.println(root.data);
        printInorder(root.right);
    }

    // Driver function
    public static void main(String[] args) {
        FifthLargestBst tree = new FifthLargestBst();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        root = tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

//        printInorder(root);

        tree.kthLargest(root, 1);
    }
}
