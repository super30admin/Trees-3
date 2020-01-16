// Time Complexity :O(n)
// Space Complexity :o(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//Recursive
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.helper(root.left,root.right)
        
        
    def helper(self,left,right):
        #base
        if(left==None and right==None):
            return True
        if((left==None) or (right==None) or(left.val!=right.val)):
            return False
        #Logic
        return self.helper(left.left,right.right) and self.helper(left.right,right.left)
     
     //Iterative
     # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        stack=[]
        stack.append(root.left)
        stack.append(root.right)
        while stack:
            nodeR=stack.pop()
            nodeL=stack.pop()
            if(nodeL==None and nodeR==None):
                continue
            if(nodeL==None or nodeR==None or nodeL.val!=nodeR.val):
                return False
            stack.append(nodeR.left)
            stack.append(nodeL.right)
            stack.append(nodeR.right)
            stack.append(nodeL.left)
        return True
        
