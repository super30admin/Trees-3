// Time Complexity :O(n^2) n-number of nodes
// Space Complexity :O(h) h- maximum height of the tree 
// Did this code successfully run on Leetcode :yes 
class Solution {
    List<List<Integer>> result=new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target=sum;
        helper(root,0,new ArrayList<>());
        return result;
    }
    
    private void helper(TreeNode root, int sum,List<Integer> list)
    {
        //base
        if(root==null) return;
        
        //logic
        sum+=root.val;
        list.add(root.val);
        
        if(root.right==null && root.left==null && target==sum)
        {
            result.add(new ArrayList<>(list));
        }
        
        helper(root.left,sum,list);
        helper(root.right,sum,list);
        
        list.remove(list.size()-1);
    }
}