package Week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeLevelOrderTraversal {
    private static Queue<Node> queue = new LinkedList<>();

    public static class Node {
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

    public static void print(Node root) {
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if(tempNode.left != null)
                queue.add(tempNode.left);
            if(tempNode.right != null)
                queue.add(tempNode.right);
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node root = null;
        for(int i = 0;i < n;i++) {
            root = insert(root, scanner.nextInt());
        }
        if(root != null) {
            print(root);
        }
    }
}
