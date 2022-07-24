// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach


class Solution {
    int target;
    List<List<Integer>> result;
  
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         
       // count=0;
        result = new ArrayList<>();
        target=targetSum;
        helper(root,0,new ArrayList<>());
       
        return result;
        
    }
    
    private void helper(TreeNode root,int currentsum,List<Integer> path){
        if(root==null) return;
        
        path.add(root.val);
        currentsum=currentsum+root.val;
        
        
        if(root.left==null && root.right==null){
            if(currentsum==target){
                System.out.print(path);
                result.add(new ArrayList<>(path));
                }
          }
        
      
        helper(root.left,currentsum,path);
        helper(root.right,currentsum,path);
        
        path.remove(path.size()-1);
    }
}
