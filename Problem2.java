package Trees3;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * We do the inorder traversal (left root right) on the leftsubtree such that we even store the null values. For eg-
 *   4
 *  / \     will be stored as null,2,null,4,null,3,null. Then we do a similar traversal on the right subtree (right root left, since symmentrical) 
 * 2   3
 * and check if the traversal matches our previous traversal.
 * 
 * Time Complexity :
 * O(n) - where n is the no of nodes in the given tree.
 * 
 * Space Complexity :
 * O(n), actually is the height of the tree in worst case(If given tree has only left children on left subtree and right children on right subtree)
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    List<Integer> path=new ArrayList<>();
    int counter=0;
    boolean flag=true;
    public boolean isSymmetric(TreeNode root) {
    if(root.left==null && root.right==null)
        return true;
    else if(root.left==null || root.right==null)
        return false;
    else if(root.left.val != root.right.val)
        return false;
     helperFirstTraversal(root.left); 
     helperSecondTraversal(root.right);   
    return flag;
    }
    // we store inorder traversal (left root right) of the left sub tree including the nulls.
    void helperFirstTraversal(TreeNode node){
        if(node==null)
            return;
    
    if(node.left==null && node.right!=null){
        path.add(null);
    }
    helperFirstTraversal(node.left);
    path.add(node.val);
    if(node.right==null && node.left!=null){
        path.add(null);
    }
    helperFirstTraversal(node.right);

    }

    // we store inorder traversal (right root left) of the right sub tree including the nulls and check if it matches the traversal of the left subtree
    void helperSecondTraversal(TreeNode node){
        if(node==null)
            return;
    if(node.right==null && node.left!=null){
        if(path.get(counter)==null){
            counter++;
        }
        else
            flag=false;
    }
        if (flag==true)
             helperSecondTraversal(node.right);
    if(path.get(counter)!=null && path.get(counter)==node.val){
        counter++;
    }
    else
        flag=false;
    if(node.left==null && node.right!=null){
        if(path.get(counter)==null){
            counter++;
        }
        else
            flag=false;
    }
    if (flag==true)
        helperSecondTraversal(node.left);

    }

}
