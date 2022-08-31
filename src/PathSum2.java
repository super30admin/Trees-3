// Time Complexity:           O(n)
// Space Complexity:          O(h)
// where n is number of nodes in tree, h is height of the tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import com.sun.source.tree.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resultList = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), resultList);
        return resultList;
    }
    
    private void pathSum(TreeNode node, int target, List<Integer> tempList, List<List<Integer>> resultList) {
        
        if(node == null)
            return;
        
        tempList.add(node.val);                                                                  // adding current node to temp list
        
        if(node.val == target && node.left == null && node.right == null) {                      // got the sum and it's leaf node
            resultList.add(tempList);
            return;
        }
        
        pathSum(node.left, target-node.val, new ArrayList<>(tempList),resultList);               // left subtree
        pathSum(node.right, target-node.val, new ArrayList<>(tempList), resultList);             // right subtree    
    }
}
