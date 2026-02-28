// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class Sample {
    // Time Complexity : O(n)
    // Space Complexity : O(h)
    // Did this code successfully run on Leetcode : yes
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int currSum = 0;

        helper(root, currSum, new ArrayList<>(), targetSum);
        return ans;
    }

    public void helper(TreeNode root, int currSum, List<Integer> list, int tar) {
        if (root == null) return;
        currSum = currSum + root.val;
        System.out.println(root.val + " " + currSum + " " + tar);

        list.add(root.val);
        if (root.left == null && root.right == null && tar == currSum) {
            ans.add(new ArrayList(list));
        } else {
            helper(root.left, currSum, list, tar);
            helper(root.right, currSum, list, tar);
        }
        list.remove(list.size()-1);
    }

}