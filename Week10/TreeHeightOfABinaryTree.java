package Week10;

import Week9.TreeInorderTraversal;

import java.util.Scanner;

public class TreeHeightOfABinaryTree {
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
        return root;
    }

    public static int getHeight(Node root) {
        int leftHeghit = root.left == null ? -1 : getHeight(root.left);
        int rightHeghit = root.right == null ? -1 : getHeight(root.right);
        return 1 + Math.max(leftHeghit, rightHeghit);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        for(int i = 0;i < n;i++) {
            root = insert(root, scanner.nextInt());
        }
        System.out.println(getHeight(root));
    }

}
