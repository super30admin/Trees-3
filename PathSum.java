// Time Complexity : O(n^2) n is number of nodes 
// Space Complexity :O(n) n is number of nodes 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PathSum {
    int target;
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target=sum;
        result = new ArrayList<>();
        if(root==null) return result;
        List<Integer> list = new ArrayList<>();
        return helper(0,root,list);
    }
    
    private List<List<Integer>> helper(int sum,TreeNode root, List<Integer> list)
    {
        if(root==null) return result;
        
        sum = sum+root.val;
        list.add(root.val);
        if(root.left==null && root.right==null)
        {
            if(sum==target)
            result.add(new ArrayList<>(list));
        }
        
        if(root.left!=null) helper(sum,root.left,list);
        if(root.right!=null) helper(sum,root.right,list);
        list.remove(list.size()-1);
        return result;
    }
}