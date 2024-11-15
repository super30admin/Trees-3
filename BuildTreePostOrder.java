//Time complexity: O(n) as each node is processed once
//Space complexity : O(n) for recursion stack and inOrder map
import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePostOrder {
    private Map<Integer, Integer> inOrderMap;
    private int postOrderIndex;

    private TreeNode buildTreeNew(int[] inOrder, int [] postOrder){
        inOrderMap = new HashMap<>();
        for(int i =0; i<inOrder.length;i++){
            inOrderMap.put(inOrder[i], i);
        }

        postOrderIndex = postOrder.length -1; // start from end
        return dfs( postOrder, 0, inOrder.length -1);
    }

    private TreeNode dfs(int [] postOrder, int left, int right){
        // base case
        if(left > right) return null;

        // root value from post order traversal

        int rootValue = postOrder[postOrderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // get index of root in inOrder array
        int inorderIndex = inOrderMap.get(rootValue);

        // recursively build left and right subtrree. build the right subtree first because we are moving backwards
        root.right= dfs(postOrder, inorderIndex + 1, right);
        root.left = dfs(postOrder, left, inorderIndex - 1);



        return root;

    }
    // Helper function to print inorder traversal of the tree
    public void printInorder(TreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }
    }
    public static void main(String[] args) {
        BuildTreePostOrder solution = new BuildTreePostOrder();

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = solution.buildTreeNew(inorder, postorder);

        System.out.println("Inorder traversal of the constructed tree:");
        solution.printInorder(root);  // Should output the inorder array if the tree is built correctly
    }


    }

