// Time Complexity : O(number of nodes)
// Space Complexity : (number of nodes + height of tree)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class ConstructTreeFromPostOrderAndInOrder {
    // PostOrder -> Left, Right, Root
    // InOrder -> Left, Root, Right

    //.   Value, Index
    Map<Integer, Integer> inMap = new HashMap<>(); // Inorder map
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // null check
        if(postorder.length == 0) {
            return null;
        }
        postIdx = postorder.length - 1;

        // fill inorer map
        for(int i = 0; i < inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return helper(0, inorder.length - 1, postorder);
    }

    private TreeNode helper(int startIdx, int endIdx, int[] postorder) {
        // check cross-over, return null if end is greater tha start
        if(startIdx > endIdx){
            return null;
        }
        int rootVal = postorder[postIdx];
        postIdx--;

        TreeNode root = new TreeNode(rootVal);

        // In PostOrder flow is Left -> Right -> Root.
        // Root is at the end so we havet to start iteration from end till start

        // get root idx form inorder map
        int rootIdx = inMap.get(rootVal);
        // Root is done, next is Right
        root.right = helper(rootIdx + 1, endIdx, postorder);
        root.left = helper(startIdx, rootIdx - 1, postorder);

        return root;
    }
}