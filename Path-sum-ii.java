//every node will have a new list, this is not optimal
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        if(root == null) return result;
        helper(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    //Method 1 - If currSum==targetSum at leaf Node We will record that path in our answer. Here every node is having a new list.
    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path){
        //base
        if(root == null) return;
        //logic - preorder
        currSum += root.val;
        path.add(root.val);
        //leaf node
        if(root.left == null && root.right == null){
            if(currSum==targetSum){
                result.add(path);
            }
        }

        //left - copying the path from root to node
        helper(root.left, currSum, targetSum, new ArrayList<>(path));

        //right
        helper(root.right, currSum, targetSum, new ArrayList<>(path));

    }
    //Method 2 - using backtrack
    private void helper(TreeNode root, int currSum, int targetSum, List<Integer> path){
        //base
        if(root == null) return;
        //logic - preorder
        currSum += root.val;
        //action
        path.add(root.val);
        //leaf node
        if(root.left == null && root.right == null){
            if(currSum==targetSum){

                result.add(new ArrayList<>(path));
            }
        }

        //left
        helper(root.left, currSum, targetSum, path);

        //right
        helper(root.right, currSum, targetSum, path);

        //backtrack(reversing of action)
        path.remove(path.size()-1);

    }
}