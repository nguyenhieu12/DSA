package Week10;

import java.util.Scanner;

public class BinarySearchTreeLowestCommonAncestor {
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

    static Node search(Node root,int v1,int v2)
    {
        if(root.data < v1 && root.data < v2){
            return search(root.right,v1,v2);
        }

        if(root.data > v1 && root.data > v2){
            return search(root.left,v1,v2);
        }

        return root;
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
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();
        System.out.println(search(root,v1, v2).data);
    }
}
