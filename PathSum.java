package com.Sep2020.Trees3;
// Time Complexity : O(n)
// Space Complexity : O(h) // height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//Need to check if this works using inorder traversal

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

import com.Sep2020.Trees3.SymmetricTree.TreeNode;

public class PathSum {
	 // Definition for a binary tree node.
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
	  
	 
	
	   List<List<Integer>> out;
	    public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        out = new ArrayList<>();
	        if(root == null) return out;
	        
	        List<Integer> list = new ArrayList<>();
	        helper(root,sum, list);
	        return out;
	        
	    }
	    
	    public void helper(TreeNode root,int sum, List<Integer> list){
	        if(root == null) return;
	        sum -= root.val;
	        list.add(root.val);
	        
	        if(root.left == null && root.right == null && sum ==0){
	            out.add(new ArrayList<>(list));
	        }
	        
	        helper(root.left,sum,list);
	        helper(root.right,sum,list);
	        
	        list.remove(list.size() -1);
	    }
	}

