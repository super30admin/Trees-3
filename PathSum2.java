// Time Complexity : O(n^2). n is the number of nodes in a tree
// Space Complexity : O(H). H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
import java.io.*; 
import java.util.ArrayList;
class Solution {
    class Pair{
        TreeNode node;
        int sum;
        List<Integer> list;
        public Pair(TreeNode node,int sum,List<Integer>list){
            this.node=node;
            this.sum=sum;
            this.list=list;
        }
        
        public TreeNode getNode(){
            return node;
        }
        public int getSum(){
            return sum;
        }
        
        public List<Integer> getList(){
            return list;
        }
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int requiredSum) {
        if(root==null) return new ArrayList();
        int sum=0,count=0;
        
        List<List<Integer>>list = new ArrayList();
        List<Integer>elementsList = new ArrayList();
        
        Stack<Pair>stack= new Stack();
        
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                sum+=root.val;
                elementsList.add(root.val);
                
                //ArrayList<Integer>al=(ArrayList<Integer>)elementsList.clone();
                stack.push(new Pair(root,sum,new ArrayList<Integer>(elementsList)));
                root=root.left;
            }
            Pair pair=stack.pop();
            root=pair.getNode();
            sum=pair.getSum();
            elementsList = pair.getList();
            if(root.left==null && root.right==null && sum==requiredSum){
                list.add(pair.getList());
                count++;  
            } 
            root=root.right;
        }
        System.out.println(count);
        return list;
    }
}
