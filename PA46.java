
// Leetcode 113. Path Sum II
// Time complexity: O(n) // As we are traversing each node only once
//Space Complexity : O(n) // n is the no of nodes in tree. Space is used for stack.
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res= new ArrayList<List<Integer>>();
        
        if(root==null){
            return res;
        }
        
        dfs(root,sum,0, new ArrayList<Integer>());
        return res;
    }
    
   public void dfs(TreeNode root, int sum,int tsum, List<Integer> tres){
        if(root==null){
            return ;
        }
       
        if(root.left==null && root.right==null && tsum+root.val ==sum){
                tres.add(root.val);
                List<Integer> l= new ArrayList<>(tres);
                res.add(l);
                 tres.remove(tres.size()-1);
        }
        tres.add(root.val);
        tsum=tsum+root.val;
        dfs(root.left,sum,tsum,tres);   
        dfs(root.right,sum,tsum,tres);
        tres.remove(tres.size()-1);
       
    }
}