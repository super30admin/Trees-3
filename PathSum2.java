class Solution {
    int target=0;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        ArrayList<Integer> firstRootPath = new ArrayList<>();
        inorder(root, 0, firstRootPath); //sending 1st roots val as 'currentSum' will fail if the list is just []
        return result;
    }

    private void inorder(TreeNode root, int currentSum, ArrayList<Integer> path)
    {
        /* Base: 1. Maintain the path taken
                 2. Keep updating the sum
        * */
        if(root==null)
            return;
        path.add(root.val);
        currentSum+=root.val;

        /* Logic
        * */
        if(root.left==null && root.right==null) //leaf node
        {
            /* We have added backtracking. So it will keep on removing elements everytime the call returns, call is removed from the stack
            * So we will have to store the path at that moment using a new ArrayList to the result. Otherwise by the end, it will be empty.
            * */
            if(currentSum == target)
                result.add(new ArrayList<>(path));
        }
        inorder(root.left, currentSum, path);
            /* This is backtracking. When the call is returned, we update the path to remove the last element
            * to restore it to the state it was in before this call was made
            * */
        inorder(root.right, currentSum, path);
        path.remove(path.size() - 1);
    }
}