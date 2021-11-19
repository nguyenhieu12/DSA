private static ArrayList<Integer> arr = new ArrayList<>();
    public static void insert(Node root) {
        if(root == null)
            return;
        else {
            if (root.left != null)
                insert(root.left);

            arr.add(root.data);

            if (root.right != null)
                insert(root.right);
        }
    }

    public static boolean checkBST(Node root) {
        insert(root);
        if(arr.isEmpty())
            return true;
        for(int i = 1;i < arr.size();i++)
            if(arr.get(i) <= arr.get(i-1))
                return false;
        
       return true;
    }