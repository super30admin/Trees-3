// Time Complexity : O(N)
// Space Complexity : (N+1)/2 log N
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> stack=new LinkedList<Integer>();
        List<List<Integer>> result =new ArrayList<List<Integer>>();
        sumnodes(root,sum,stack,0,result);
        return result;
    }
    public void sumnodes(TreeNode node, int sum,LinkedList<Integer> stack,int runningSum, List<List<Integer>> result){
     if(node ==null){
         return;
     }
        if(node.left ==null && node.right ==null){
            runningSum=runningSum+node.val;
            if(runningSum ==sum){
                stack.add(node.val);
                List<Integer> newstack= new LinkedList<>();
                for(int i:stack){
                    newstack.add(i);
                }
                result.add(newstack);
                 stack.removeLast();
            }
        }
        runningSum=runningSum+node.val;
        if(node.left!=null){
            stack.add(node.val);
            sumnodes(node.left,sum,stack,runningSum,result); 
            stack.removeLast();
        }
        if(node.right !=null){
            stack.add(node.val);
            sumnodes(node.right,sum,stack,runningSum,result); 
                 stack.removeLast();
        }
        
      }
}