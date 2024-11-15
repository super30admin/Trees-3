// Time Complexity : O(n) as we process each node once
// Space Complexity : O(n) due to map recurrsion and stack
// Ran on leetcode: Yes
// Any problems: No
import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    private Map<Integer, Integer> inOrderMap;
    private int preOrderIndex = 0;
    public TreeNode buildTree(int [] inOrder, int [] preOrder){
        inOrderMap = new HashMap<>();
       // store the index and value of inOrder array in hashmap for searching in O(n)
        for(int i =0; i< inOrder.length; i++){
            inOrderMap.put(inOrder[i], i);
        }

        return dfs(preOrder, 0, inOrder.length - 1);
    }

    private TreeNode dfs( int [] preOrder, int left,int right){

        // base case
        if(left > right) return null;

        // find root value from preOrder traversal
        int rootValue = preOrder[preOrderIndex ++];
        TreeNode root = new TreeNode(rootValue);

        // get the index of the root from inOrder map

        int inOrderIndex = inOrderMap.get(rootValue);

        // recursively build left and right subtree
        root.left = dfs(preOrder, left,inOrderIndex - 1);
        root.right = dfs(preOrder, inOrderIndex + 1, right);

        return root;

    }

    private void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }

    public static void main (String[] args){
        BuildTree solution = new BuildTree();

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = solution.buildTree(preorder, inorder);

        System.out.println("Inorder traversal of the constructed tree:");
        solution.printInorder(root);

    }
}
