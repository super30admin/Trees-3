/**
 * Recursive solution - The time complexity is O(N) and the space complexity is O(Height) where Height will be the utmost stack size.
 *
 * The solution will check for the symmetry where if node1 and node2 are two symmetric nodes then node1.left should be node2.right and
 * node1.right should be node2.left
 *
 * Yes, the program passed all the test cases in leet code.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        return checkSymmetry(root,root);
    }

    public boolean checkSymmetry(TreeNode node1,TreeNode node2){

        if(node1==null && node2==null){return true;}
        else if((node1!=null && node2==null) || (node1==null && node2!=null) || (node1.val!=node2.val)){return false;}
        else{
            return checkSymmetry(node1.left,node2.right) && checkSymmetry(node1.right,node2.left);
        }
    }
}

/**
 *
 * Iterative solution - The time complexity will be O(N) and the space complexity will be O(Height)
 *
 * The solution uses two stacks to store the nodes and compare the top node of each stack.
 *
 * Yes, the program passed all the test cases.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        s1.push(root); s2.push(root);

        while(!s1.empty() && !s2.empty()){

            TreeNode node1 = s1.pop();
            TreeNode node2 = s2.pop();

            if(node1==null && node2==null){continue;}
            else if((node1==null && node2!=null) || (node1!=null && node2==null) || (node1.val!=node2.val)){
                return false;
            }
            else{
                s1.push(node1.left); s2.push(node2.right);
                s1.push(node1.right); s2.push(node2.left);
            }
        }

        return true;
    }
}