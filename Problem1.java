package Trees3;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * We maintain a list as a global variable to store path upto the current node being processed. We recursively travel the tree in an inorder manner and when ever a new node is encounter we add it 
 * to the path. Once the left and right subtree for a node is processed we backtrack our action and remove that node from path. At each leaf node we check if the sum at that point is equal to target
 * and add create a deep copy of path array and add it to the ans.
 * 
 * Time Complexity :
 * O(n) - where n is the no of nodes.
 * 
 * Space Complexity :
 * O(n), actually is the height of the tree in worst case(skewed tree)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
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
public class Problem1 {
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
    List<Integer> path=new ArrayList<Integer>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root,targetSum, 0);
        return ans;
    }

    void helper(TreeNode node, int targetSum, int sum){
        //base
        if(node==null)
            return;
        else if(node.left==null && node.right==null){
            sum+=node.val;
            if(sum==targetSum){
            List<Integer> li=new ArrayList<>(path);
            li.add(node.val);
            ans.add(li);  
            }
             return;      
        }
        //logic
        path.add(node.val);
        sum+=node.val;
        helper(node.left, targetSum,sum);
        helper(node.right, targetSum,sum);
        path.remove(path.size()-1);
    }
}
