//Time Complexity: O(n)
//Space Complexity: O(n)
//didn't face any problems
//runs successfully

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree101LeetCode {


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

        public boolean isSymmetric(TreeNode root) {

            if(root == null){                                       //check if root is null
                return true;                                        //if so then return true
            }
            Queue<TreeNode> queue = new LinkedList<>();             //creating queue of treenode
            queue.add(root.left);                                   //add the left and right child of root to the queue
            queue.add(root.right);

            while(!queue.isEmpty()){                                //iterating till queue is empty

                TreeNode actual = queue.remove();                   //getting the 2 elements at a time
                TreeNode mirror = queue.remove();

                if(actual== null && mirror== null){                 //if both the elements are null then we need to simply continue the loop
                    continue;
                }

                if(actual == null || mirror == null || actual.val != mirror.val){   //if only one is null or if both node's value are not same then return false as it is not mirror
                    return false;
                }


                queue.add(actual.left);                             //adding one node's left element and other node's right element
                queue.add(mirror.right);

                queue.add(actual.right);                            //adding one node's right element and other node's left element
                queue.add(mirror.left);

            }
            return true;                                            //if we made it till this, then it means tree is symmetric
        }



//     public boolean isSymmetric(TreeNode root) {

//         if(root == null){
//             return true;
//         }

//         return valid(root.left, root.right);

//     }

//     public boolean valid(TreeNode node1, TreeNode node2){

//         if(node1 == null || node2 == null){

//             return node1 == node2;

//         }

//         if(node1.val != node2.val){
//             return false;
//         }

//         return valid(node1.left, node2.right) && valid(node1.right, node2.left);

//     }

}
