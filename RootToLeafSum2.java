/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RootToLeafSum2{
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int pathSum = 0;
        List<Integer> path = new ArrayList <Integer> ();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(root,targetSum,path,pathSum,result);
        return result;
        
    }
    
    private void helper(TreeNode root,int targetSum,List<Integer> path, int pathSum, List<List<Integer>> result) {  
        //base
        if (root==null) return;
         
        //logic
         pathSum+=root.val;
        
        //if(pathSum<=targetSum)
        path.add(root.val); 
       
        helper(root.left,targetSum,path,pathSum,result);  
        
        if (root.left == null && root.right==null) {
             if (pathSum==targetSum) {
                result.add(new ArrayList<Integer>(path));
                 System.out.println("result"+result);
               
            }
        }   
        
        helper(root.right,targetSum,path,pathSum,result);
        path.remove(path.size()-1);
       
        
    }
}