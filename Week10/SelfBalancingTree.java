package Week10;

public class SelfBalancingTree {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node() {}

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null)
            return new Node(data);
        else {
            if(data <= root.data) {
                root.left = insert(root.left, data);
            }
            else {
                root.right = insert(root.right, data);
            }
        }
        int balanceFactor = height(root.left) - height(root.right);
        return root;
    }

    public static int height(Node root) {
        if(root == null)
            return -1;
        return height(root.left);
    }

    public static int treeHeight(Node root) {
        int leftHeghit = root.left == null ? -1 : treeHeight(root.left);
        int rightHeghit = root.right == null ? -1 : treeHeight(root.right);
        return 1 + Math.max(leftHeghit, rightHeghit);
    }
}
