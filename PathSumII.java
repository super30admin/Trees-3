/*
TC: O(N^2), for a tree of N nodes, leaf nodes are (N + 1)/2. For each leaf node, we perform a potential O(N) operation of copying over the pathNodes nodes to a new list to be added to the final pathsList. 
Hence, the complexity in the worst case could be O(N^2).

SC: O(N) recursion stack 

1. We keep updating curSum and path as we traverse through root to leaf.
2. When we reach a leaf node, check for target. If curSum = target, its a valid path. 
3. Else we remove the leaf node and traverse and another path 


*/

import java.util.*;
public class PathSumII {
    
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> pathsumII(TreeNode root, int sum){
        helper(root, 0, sum, new ArrayList<>());
        return res;
    }

    private static void helper(TreeNode node, int cursum, int sum, List<Integer> path){
        //base
        if(node == null) return;

        //logic
        cursum += node.val;
        path.add(node.val);

        if(node.left == null && node.right == null){
            if(cursum == sum){
                res.add(new ArrayList<>(path));
            }
        }

        //recursion
        helper(node.left, cursum, sum, path);
        helper(node.right, cursum, sum, path);

        //backtrack
        path.remove(path.size() - 1);
    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(10);
        root.left.left = new TreeNode(17);
        root.right.left = new TreeNode(5);
        
        
        //PathSumII ps = new PathSumII();
        System.out.println(pathsumII(root, 40));
    }
}
