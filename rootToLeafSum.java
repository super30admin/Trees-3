//time complexity: O(n) 
//space complexity: O(h)
//where n is the number of nodes in tree and h is the height

import java.util.*;

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)  return result;
        dfs(root, sum, new ArrayList<>(), result);
        return result;
 
    }
    public void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result)
    {
        if(root==null)  
            return;
        list.add(root.val);
        if(root.left==null&&root.right==null && root.val==sum)
        {
                result.add(new ArrayList<>(list));
        }
        else
        {
            dfs(root.left, sum-root.val, list, result);
            dfs(root.right, sum-root.val, list, result);
        }
        list.remove(list.size()-1);
      
    }

}