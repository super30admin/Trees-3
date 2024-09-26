//Time Complexity : O(n) (We are ignoring the time complexity of copying the list to the global result)
//Space Complexity : O(h) (where h is height of the tree)
//Run Successfully on leetcode
//No problem

//Here we will be maintaining a list at every node, As list is a non primitive structure (reference type)
//at the end of the recursion to get the previous state, we'll have to backtrack
//When we found the result, we'll be copying the whole list to global result


import java.util.ArrayList;
import java.util.List;

public class Trees_3_Problem_1_pathSumII {
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root,new ArrayList<Integer>(),sum);
        return l;
    }
    public void helper(TreeNode root, List<Integer> list, int sum)
    {
        if(root == null) return;

        list.add(root.val);
        sum = sum - root.val;

        if(root.left == null && root.right == null)
        {
            if(sum == 0)
            {
                l.add(new ArrayList<>(list));
            }
        }


        helper(root.left,list,sum);
        helper(root.right,list,sum);

        list.remove(list.size()-1);
    }
}
