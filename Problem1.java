// Time Complexity :
//      n is the number of elements
//      pathSum() - O(n)
//      
// Space Complexity :
//      pathSum() - O(h)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> lili = new ArrayList<>();
    Map<TreeNode, Integer> mp = new LinkedHashMap();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return lili;
    }
    
    private void helper(TreeNode root, int sum)
    {
        //Base Case
        if(root == null)
        {
            return;
        }
        
        if(root.left == null && root.right == null && sum == root.val)
        {
            List<Integer> li = new ArrayList<>(mp.values());
            li.add(root.val);
            lili.add(li);
            return;
        }
        
        //Logic
        mp.put(root, root.val);
        
        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
        
        mp.remove(root);
        
        return;
    }
}