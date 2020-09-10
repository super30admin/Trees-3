//Time Complexity: O(n) 
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    static List<Integer> l = new ArrayList<>();  
    public static boolean isSymmetric(TreeNode root) {
//         inorder(root);
//         System.out.println(l.size());
//         for(Integer x:l)
//             System.out.println(x);
//         for(int i=0; i<=l.size()/2; i++){
            
//             if(l.get(i) != l.get(l.size()-1-i))
//                 return false;
//         }
        return inorder(root, root);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
      
    static boolean inorder(TreeNode node1, TreeNode node2) 
    { 
        // if root of both is null return true
        if (node1 == null && node2 == null) {
            return true; 
        }

        //if either of the node is null return false
        if(node1 == null || node2 == null)
            return false;
        //check current root values and recurse by comparing left-> right and vice versa
        return node1.val == node2.val &&
        inorder(node1.right, node2.left) &&        
        inorder(node1.left, node2.right); 
    } 

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1,new TreeNode(1),new TreeNode(1));
        System.out.println(isSymmetric(r));
    }
}