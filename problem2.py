  
// Time Complexity : O(n) n=num of nodes
// Space Complexity : O(max depth of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:                              //check if root is null =>return True
            return True
        
        return self.recurr(root.left,root.right)      
    
    def recurr(self,a,b):       //recursive function 
        if not a and not b:   //if both nodes are null then return True
            return True
        if not a or not b or a.val!=b.val:    //if one of the node is null or if value of both the nodes are not same then return false
            return False
        
        return self.recurr(a.left,b.right) and self.recurr(a.right,b.left)   //again call recursive function twice to check all childs of both the nodes
