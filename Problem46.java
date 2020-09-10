//Time Complexity: O(n^2)
//Space Complexity: O(n*n)with recursive stack
//Did it run on leetcode: yes
//Problems faced any: No

import java.util.ArrayList;
import java.util.List;

public class Problem46 {
    private List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        findSumII(root, 0, sum, list);
        return output;

    }

    void findSumII(TreeNode node, int prev, int sum, List<Integer> list){
        if(node==null)
            return;

        //on each recursive we keep adding sum of the path
        int currSum = prev + node.val;

        //we create a new list and add all the node values of the path
        List<Integer> newList = new ArrayList<>();
        newList.addAll(list);
        newList.add(node.val);

        if(node.left == null & node.right==null){
            //if the path sum is equal to given sum we will add it to the output list
            if(currSum == sum){
                output.add(newList);
                return;
            }else
                return;
        }

        findSumII(node.left, currSum, sum, newList);
        findSumII(node.right, currSum, sum, newList);
    }
}
