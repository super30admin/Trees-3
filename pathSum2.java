Time Complexity-O(n)
Space Complexity-O(n)

class Solution {
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result=new ArrayList<>();
    helper(result,new ArrayList<Integer>(), root, sum);
    return result;
}

private void helper(List<List<Integer>> result,List<Integer> temp, TreeNode root, int sum) {
    if (root == null) return;
    temp.add(root.val);
    sum -= root.val;
    if (root.left == null && root.right == null) {
        if (sum == 0) result.add(temp);
        return;
    }
    helper(result,new ArrayList<Integer>(temp), root.left, sum);
    helper(result,new ArrayList<Integer>(temp), root.right, sum);
}
    
}
