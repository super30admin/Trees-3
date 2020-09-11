// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
       
        
        List<Integer> currpath = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        
        recurr(root, sum, 0, currpath, output);
       
        return output;
    }
    
     public void recurr(TreeNode root, int target, int currsum, List<Integer> currpath, List<List<Integer>> output){
            
         if(root==null){
             return;
         }
         
         if(root.left==null && root.right==null){
             if(target==root.val+currsum){
                 List<Integer> temp = new ArrayList<>(currpath);
                 temp.add(root.val);
                 output.add(temp);
             }
             return;
         } 
         
         currpath.add(root.val);
         currsum+=root.val;
         recurr(root.left, target, currsum, currpath, output);
         recurr(root.right, target, currsum, currpath,output);
         
         currpath.remove(currpath.size()-1);
        }
}