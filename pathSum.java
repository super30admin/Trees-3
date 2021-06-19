//time complexity:O(n)
//space complxity:O(n)
class Solution {
    int target;
    List<List<Integer>> result; 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>();
        target=targetSum;
        helper(root, 0, new ArrayList<>());//initially sum is 0 and 
        //we store the path elements in a list 
        return result;
    }
    private void helper(TreeNode root,int currSum, List<Integer> path)
    {
        if(root==null) return;
        currSum+=root.val;//store the sum of the elements
        path.add(root.val);//add each value as we traverse into list
        helper(root.left, currSum, path);
        if(root.left==null && root.right==null)
        {
            if(currSum==target)
            {
                result.add(new ArrayList(path));//id the sum is equal to target
                //add the path to the result
            }
        }
        helper(root.right, currSum, path);
        path.remove(path.size()-1);//back tracking
        //we remove the last element from the path as the root 
        //changes 
    }
}
