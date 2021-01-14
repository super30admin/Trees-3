/**
 * TC - O(n)
 * Sc - O(h) for recursive stack
 */
class Solution {
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        target = sum;

        helper(root,0,new ArrayList<>());

        return result;
    }
    public void helper(TreeNode root, int currsum, List<Integer> path)
    {
        if(root==null)
            return;

        path.add(root.val);

        currsum+=root.val;

        if(root.left==null&&root.right==null)
        {
            if(currsum==target)
                result.add(new ArrayList<>(path));
        }

        helper(root.left, currsum, path);
        helper(root.right, currsum, path);

        //Backtracking
        path.remove(path.size()-1);

    }
}