//Time complexity: O(N)
//Space Complexity O(h) h = height of the tree
//ran on leetcode and accepted 
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) 
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root,sum, result,path);
       
        return result;
     }
    
    public void dfs(TreeNode root,int sum,List<List<Integer>> result, List<Integer> path)
    {
        if(root==null) return;
        
        path.add(root.val);
        
        if(root.left==null && root.right==null && sum == root.val)
        {
            result.add(new ArrayList<>(path));
            return;
        }
         
        if(root.left!= null)
        {
            dfs(root.left,sum-root.val,result,path);
            path.remove(path.size()-1);
        }
        
        if(root.right!=null)
        {
            dfs(root.right, sum-root.val,result, path);
            path.remove(path.size()-1);
        }
    }   
}