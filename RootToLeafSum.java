/**
Time Complexity : O(N) , N = number of elements
Space Complexity : O(D), D = depth of the tree
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    List<List<Integer>> output;
    int targetSum;
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) 
    {
        output = new ArrayList<>();
        targetSum = sum;
        
        traverse(root, 0, new ArrayList<>());
        
        return output;
    }
    
    private void traverse(TreeNode root, int currentSum, List<Integer> currentList)
    {
       if(root == null)
           return;
        
        currentSum = currentSum + root.val;
        currentList.add(root.val);
        
        if(currentSum == targetSum)
        {
            if(root.left == null && root.right == null)
            {
                List<Integer> list = new ArrayList<>(currentList);
                output.add(list);
            }
        }
        
        if(root.left !=null)
            traverse(root.left, currentSum, currentList);
        
        if(root.right != null)
            traverse(root.right, currentSum, currentList);
        
        int currentListSize = currentList.size();
        currentList.remove(currentListSize-1);
    }
}