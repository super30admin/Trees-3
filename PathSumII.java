// Time Complexity : At leaf node when we create a new arrayList, we have to consider copying the current list for it
            //So the time complexity would be Max(N, L * maxDepth) where N is all the nodes and L is the number of leaf nodes.
// Space Complexity : O(N) for recursive stack, otherwise O(1). The arraylists we create are returned as output so 
            //those don't count as auxillary space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nope.

import java.util.*;

public class PathSumII {

    List<List<Integer>> output;
    int total;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) {
            return new ArrayList<>();
        }
        output = new ArrayList<>();
        total = sum;
        recurr(root, 0, new ArrayList<>());
        return output;
    }

    void recurr(TreeNode root, int sumSoFar, List<Integer> prevList) {

        if(root.left == null && root.right == null) {
            if(sumSoFar + root.val == total) {
                List<Integer> curr = new ArrayList<>(prevList);
                curr.add(root.val);
                output.add(curr);
            }
            return;
        }

        prevList.add(root.val);

        if(root.left != null) {
            recurr(root.left, sumSoFar + root.val, prevList);   
        }

        if(root.right != null) {
            recurr(root.right, sumSoFar + root.val, prevList);
        }

        prevList.remove(prevList.size()-1);
    }

    /* Definition for a binary tree node.*/
    public class TreeNode {
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
}
