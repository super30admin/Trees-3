// Time Complexity : O(n) amortized or else o(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YEs
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> outer = new ArrayList<>();
    private void helper(TreeNode root, int targetSum, int currentSum, ArrayList<Integer> parseValue){
        if(root == null) return;
        parseValue.add(root.val);
        currentSum += root.val;
        if(root.left == null && root.right == null && currentSum == targetSum){
            ArrayList<Integer> inner = new ArrayList<>();
            for(int i=0;i<parseValue.size();i++){
                inner.add(parseValue.get(i));
            }
            outer.add(inner);
            //System.out.println(parseValue);
        }
        helper(root.left, targetSum, currentSum, parseValue);
        helper(root.right, targetSum, currentSum, parseValue);
        parseValue.remove(parseValue.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0, new ArrayList<Integer>());
        return outer;
    }
}
