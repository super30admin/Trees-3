public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode getSampleOne() {
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(11, node7, node2);
        TreeNode node4 = new TreeNode(4, node11, null);
        TreeNode node13 = new TreeNode(13);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4two = new TreeNode(4, node5, node1);
        TreeNode node8 = new TreeNode(8, node13, node4two);
        TreeNode root = new TreeNode(5, node4, node8);
        return root;
    }

    TreeNode getNode(int data) {
        return new TreeNode(data);
    }

    public TreeNode getSampleTwo() {
        //[7,0,null,-1,-6,null,1,null,null,-7]

        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4two = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5Two = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        root.left = node4;
        root.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node4two;
        node4two.left = node5Two;
        node4two.right = node1;

        return root;

    }

}
