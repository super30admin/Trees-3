// Time Complexity - O(N)
// Space complexity - O(N)


class Solution {
    List<List<Integer>> listtoReturn;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        listtoReturn = new ArrayList<>();
        target = targetSum;
        helper(root,0,new ArrayList<>());
        return listtoReturn;

    }

    public void helper(TreeNode root, int currSum, List<Integer> path) {

        // base case
        if(root == null) return;

        //action
        currSum += root.val;

        path.add(root.val);

        //recursion
        helper(root.left,currSum,path);

        if(root.left == null && root.right == null) {

            if(currSum == target) {

                listtoReturn.add(new ArrayList<>(path));
            }

        }

        helper(root.right,currSum,path);


        //backtracking
        path.remove(path.size() - 1);


    }

}