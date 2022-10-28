package s30.trees.trees3;

import s30.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity O(n) n being the nodes of tree, traversing through each node.
// space complexity O(h) height of the resultant tree, logn <= h <= n;
public class PathSum2 {

    List<List<Integer>> res;
    List<Integer> sumArray;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList();
        sumArray = new ArrayList();

        pathSum(root, targetSum, 0);

        return res;

    }

    private void pathSum(TreeNode node, int targetSum, int currSum){
        // base
        if(node== null) return;


        //process
        sumArray.add(node.val);
        currSum += node.val;

        if(node.left == null && node.right == null){
            if(currSum == targetSum)  res.add(new ArrayList(sumArray));
        }

        //recurse
        pathSum(node.left, targetSum, currSum);
        pathSum(node.right, targetSum, currSum);

        currSum -= node.val;
        sumArray.remove(sumArray.size()-1);
    }
    public static void main(String[] args) {

    }
}
