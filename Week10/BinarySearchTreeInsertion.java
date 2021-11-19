package Week10;

import java.util.Scanner;

public class BinarySearchTreeInsertion {
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

    public static void print(Node root) {
        if(root == null)
            return;
        else {
            System.out.print(root.data + " ");

            if (root.left != null)
                print(root.left);

            if (root.right != null)
                print(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        for(int i = 0;i < n;i++) {
            root = insert(root, scanner.nextInt());
        }
        print(root);
    }
}
