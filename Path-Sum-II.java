## Problem1 (https://leetcode.com/problems/path-sum-ii/)
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
Example 1:
Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22

//Approach 1:
//In this we are doing an preorder traversal 
//Problem with this below code is that we are updating the same list and as in java the list is passed by reference so we are adding it only to a list of list
// so the output is [[5,4,11,7,2,8,13,4,5,1],[5,4,11,7,2,8,13,4,5,1]]
// Expected [[5,4,11,2],[5,8,4,5]]
// This is because of the nature of the list 
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return new ArrayList<>();
        }
        list = new ArrayList<>();
        preorder(root, new ArrayList<>(),0,targetSum);
        return list;
    }   

    private void preorder(TreeNode root, ArrayList<Integer> path,int sum, int targetsum){ 
        if(root==null){
            return;
        }
        sum=sum+root.val;
        path.add(root.val);
        if(root.left == null && root.right==null){
            if(sum==targetsum){
                list.add(path);
            }
            return;
        }        
        preorder(root.left,path,sum,targetsum);
        preorder(root.right,path,sum,targetsum);
    }
}

//Solution to above problem is we can create a new list at every node but this will be very expensive operation
// Time Complexity : O(n*h)
// Space Complexity : O(h2)
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return new ArrayList<>();
        }
        list = new ArrayList<>();
        preorder(root, new ArrayList<>(),0,targetSum);
        return list;
    }   

    private void preorder(TreeNode root, ArrayList<Integer> path,int sum, int targetsum){ 
        if(root==null){
            return;
        }
        sum=sum+root.val;
        path.add(root.val);
        if(root.left == null && root.right==null){
            if(sum==targetsum){
                list.add(path);
            }
            return;
        }        
        preorder(root.left,new ArrayList<>(path),sum,targetsum);
        preorder(root.right,new ArrayList<>(path),sum,targetsum);
    }
}

//As the above operation is expensive what we can do is we can rempove the leaf node ones its left and right node 
// are visited and if the sum is equal to target then create a new list and copy the path list to it and add it in a list of list
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return new ArrayList<>();
        }
        list = new ArrayList<>();
        preorder(root, new ArrayList<>(),0,targetSum);
        return list;
    }   

    private void preorder(TreeNode root, ArrayList<Integer> path,int sum, int targetsum){ 
        if(root==null){
            return;
        }
        sum=sum+root.val;
        path.add(root.val);
        if(root.left == null && root.right==null){
            if(sum==targetsum){
                list.add(new ArrayList<>(path));
            }
             return;
        }        
        preorder(root.left,path,sum,targetsum);
        preorder(root.right,path,sum,targetsum);
        path.remove(path.size()-1);
    }
}

//In the above approach there is a problem when we are hitting a leaf node it return so we do not calls it's left and right 
// So it will not remove the leaf npde from the list
// if not removed the output will be [[5,4,11,7,2],[5,4,11,8,13,4,5]]
// Expected is [[5,4,11,2],[5,8,4,5]]
// If we remove the return statement then it will work fine now
//output [[5,4,11,2],[5,8,4,5]]
//Expected [[5,4,11,2],[5,8,4,5]]
//Backtracking solution
//Time Complexity : O(n) -> for visiting nodes but we are also copying a list when it's a leaf node and targetsum == curentsum
// this operation we are not doing always so we can consider this as constant so Time complexity will be O(n)
// Space Complexity will be O(h)  -> for stackframes and for list it's a part of the function that we have to return so we will not consider it
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return new ArrayList<>();
        }
        list = new ArrayList<>();
        preorder(root, new ArrayList<>(),0,targetSum);
        return list;
    }   

    private void preorder(TreeNode root, ArrayList<Integer> path,int sum, int targetsum){ 
        if(root==null){
            return;
        }
        sum=sum+root.val;
        path.add(root.val);
        if(root.left == null && root.right==null){
            if(sum==targetsum){
                list.add(new ArrayList<>(path));
            }
        }        
        preorder(root.left,path,sum,targetsum);
        preorder(root.right,path,sum,targetsum);
        path.remove(path.size()-1);
    }
}