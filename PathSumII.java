package com.ds.rani.tree;

import java.util.ArrayList;
import java.util.List;

//Approach:solving it using backtracking
//Time Complexity:o(n) where n is number of nodes in a tree
//space complexity:o(h) where h is max height of the tree
public class PathSumII {
    /**
     * @param root
     * @param sum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper( root, 0, new ArrayList(), sum, result );
        return result;

    }

    void helper(TreeNode root, int currSum, List<Integer> currList, int sum, List<List<Integer>> result) {
        //base
        if (root == null)
            return;

        //logic: add the curr root vale in currSum a
        currSum += root.val;

        //action: add current node value in list
        // check if the current node is leaf and the currSum==targetsum,if yes add it to the result
        currList.add( root.val );
        if (root.left == null && root.right == null && currSum == sum)
            result.add( new ArrayList<>( currList ) );

        //recurse: recursivley call on left subtree and right subtree
        helper( root.left, currSum, currList, sum, result );
        helper( root.right, currSum, currList, sum, result );

        //backtrack:whtever I have added in action,reverse it
        currList.remove( currList.size() - 1 );

    }
    /************Recursive Solution****************************************/
    //Time complexity:o(n*h): n is number of nodes, h is height of the tree
    //space complexity:o(n^2) as I am creating list at every recursive call(for n calls n lists)
    public List<List<Integer>> pathSumRecursive(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helperRecursive( root, 0, new ArrayList(), sum, result );
        return result;

    }

    void helperRecursive(TreeNode root, int currSum, List<Integer> currList, int sum, List<List<Integer>> result) {
        //base
        if (root == null)
            return;

        //logic: add the curr root vale in currSum and current node value in list
        currSum += root.val;
        currList.add( root.val );

        //action: ccheck if the current node is leaf and the currSum==targetsum,if yes add it to the result
        if (root.left == null && root.right == null && currSum == sum)
            result.add(  currList );

        //recurse: recursivley call on left subtree and right subtree
        helperRecursive( root.left, currSum, new ArrayList<>(currList), sum, result );
        helperRecursive( root.right, currSum, new ArrayList<>(currList), sum, result );


    }
}
