//Time Complexity: O(n)
//Space Complexity: O(n)
//runs successfully
//didn't face any problems


import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
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

public class PathSum2LeetCode113 {

    List<List<Integer>> result;                                                 //maintaining the result list
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            result = new ArrayList<>();

            getSum(root, new ArrayList<>(), 0, targetSum);

            return result;
        }

        public void getSum(TreeNode root, List<Integer> list, int sum, int targetSum){


            if(root == null){                                                   //if node is null then simply return
                return;
            }

            sum = sum+root.val;                                      //calculating the currentsum
            if(root.left == null && root.right == null){                        //check if currentnode is leaf node or not

                if(sum == targetSum){                                //if leaf node and then check if currentSum is target sum or not
                    list.add(root.val);                                     //if so, then add currentelement into list
                    result.add(list);                                       //and add list to final global list
                    return;                                                 //and return from the function
                }
            }

            ArrayList<Integer> leftList = new ArrayList<>(list);            //creating arraylist for left child
            leftList.add(root.val);                                         //and add cuurent element to it

            ArrayList<Integer> rightList = new ArrayList<>(list);           //creating the arraylist for right child
            rightList.add(root.val);                                    // and add current element to it



            getSum(root.left,leftList, sum, targetSum );                //calling recursive function for left child

            getSum(root.right, rightList, sum, targetSum );             //calling the recursive function for right child


        }

}
