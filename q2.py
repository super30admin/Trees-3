from typing import Optional
# Time Complexity : O(n), where n is number of nodes in the binary tree
# Space Complexity : O(h), where h is the height of the binary tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def giventreesaresymmetric(self,root1,root2)->bool:
        #base case
        if(root1==None and root2==None):
            return True
        if((root1==None and root2!=None) or (root1!=None and root2==None)):
            return False
        #Actual logic
        #This is the case when both root1 and root 2 are not None
        if(root1.val==root2.val):
            #check left subtree of root1 with right subtree of root2
            case1=self.giventreesaresymmetric(root1.left,root2.right)
            #check right subtree of root1 with left subtree of root2
            case2=self.giventreesaresymmetric(root1.right,root2.left)
            return case1 and case2
        else:
            return False
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.giventreesaresymmetric(root,root)
        
        
        