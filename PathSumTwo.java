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
    
        //List<List<Integer>> a =new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)
            return new ArrayList();
        List<List<Integer>> a =new ArrayList();  
        List<Integer> b =new ArrayList();  
        summation(root,sum,a,b,0);        
        return a;
    }
    
        public void summation(TreeNode root, int sum, List<List<Integer>> a, List<Integer> b, int s){
            
            s+=root.val;
            b.add(root.val);
            if( root.left==null &&  root.right == null){
                if(sum==s){
                    a.add(new ArrayList(b)); 
                }        
            }
            
            if(root.left!=null){
            summation(root.left,sum,a,b,s);
            }
            if(root.right!=null){
            summation(root.right,sum,a,b,s);
            }
            b.remove(b.size()-1);
        }
		}