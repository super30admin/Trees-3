class Solution {
    ArrayList<List<Integer>> result = new ArrayList<>();
    void sum(TreeNode node,int currSum, int targetSum, ArrayList<Integer> list) {
        if(node == null) return;
        currSum += node.val;
        list.add(node.val);

        if(node.left == null && node.right == null) {
            if(currSum == targetSum)    
                result.add(new ArrayList<>(list));
        }
        sum(node.left,currSum, targetSum, list);
        sum(node.right,currSum, targetSum, list);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> list = new ArrayList<>();
        sum(root,0, targetSum, list);
        return result;
    }
}