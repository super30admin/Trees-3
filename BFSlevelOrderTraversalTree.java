// Time complexity - O(n)
// Space complexity - O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
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
class Pair {
    
    TreeNode node;
    int level;
    
    Pair(){}
    Pair(TreeNode node, int level){
        
        this.node = node;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<Pair> q1 = new LinkedList<>();
        
        if(root == null){
            
            return result;
        }
         int prevLevel = 0;
        Pair p1 = new Pair(root,prevLevel);
        q1.add(p1);
       
         ArrayList<Integer> arr1 = new ArrayList<>();
        while(!q1.isEmpty()){
            
           //currentLevel = currentLevel + 1;
           Pair temp = q1.poll();
           int currentLevel = temp.level;
      //      System.out.println("tree level of node is"+currentLevel);
            TreeNode tempNode = temp.node;
        //     System.out.println("Tree value of node is"+temp.node.val);
            if(currentLevel != prevLevel){
                
                result.add(new ArrayList<>(arr1));
                arr1.clear();
                prevLevel = currentLevel;
            }
            
            arr1.add(tempNode.val);
        //    System.out.println(arr1);
            
            if(tempNode.left != null){
                
                Pair p2 = new Pair(tempNode.left,prevLevel+1);
                q1.add(p2);
            }
            
              if(tempNode.right != null){
              //   currentlevel = currentlevel + 1;
                 Pair p3 = new Pair(tempNode.right,prevLevel+1);
                q1.add(p3);
            }
            
            
        }
      //   System.out.println(arr1);
        result.add(new ArrayList<>(arr1));
        return result;
    }
}