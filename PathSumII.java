// Time Complexity: O(n)
// Space Complexity: O(h)
class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        hasTargetSum(root, targetSum, 0, list);
        return answer;
    }

    public void hasTargetSum(TreeNode root, int targetSum, int currentSum, List<Integer> list){
        if(root == null ) return ;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(currentSum + root.val == targetSum) {
                List<Integer> l = new ArrayList<>(list);
                answer.add(l);
            }
        }
        hasTargetSum(root.left, targetSum, currentSum + root.val, list);
        hasTargetSum(root.right, targetSum, currentSum + root.val, list);
        list.remove(list.size()-1);
        return;
    }
}