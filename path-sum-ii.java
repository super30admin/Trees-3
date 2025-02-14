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
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :no becuase i intentionally did this wrong to ensure call by reference error
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: i have done this by using recursive call and
//  have used same arraylist to add node values because its getting error,
//  while adding node values to the list it containes previous path values also becuase it has same reference. 
// to resolve this issue i have used deep copy concept in below solution
class Solution {
    List<List<Integer>> result=new ArrayList<>();
     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         helper( root, targetSum,new ArrayList<>(),0);
        return result;
    }
    public void helper( TreeNode root,int targetSum,List<Integer> path,int curr){
        if(root == null) return;

        curr += root.val;

        
        path.add(root.val);

         if(root.left == null && root.right == null){
            if(curr == targetSum){
             result.add(path);
            }
        }
        
        helper(root.left,targetSum,path,curr);
         
        helper(root.right,targetSum,path,curr);
    }
}




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
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: same approach as mentioned above however to resolve call by reference issue used deep copy of array list for new recursion ,
// have copied all the path values to a new arraylist then when it reaches to leaf node if its equal to target sum then added path list to result .
class Solution {
    List<List<Integer>> result=new ArrayList<>();
     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         helper( root, targetSum,new ArrayList<>(),0);
        return result;
    }
    public void helper( TreeNode root,int targetSum,List<Integer> path,int curr){
        if(root == null) return;

        curr += root.val;

        List<Integer> li=new ArrayList<>(path);
        li.add(root.val);
        
          System.out.println("=="+path+"===li=="+li) ;
         if(root.left == null && root.right == null){
            if(curr == targetSum){
             result.add(li);
            }
        }
        
        helper(root.left,targetSum,li,curr);
         
        helper(root.right,targetSum,li,curr);
    }
}