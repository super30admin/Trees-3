#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(n) i.e. stack will put values of left subtree and right tree
#Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    symmetric = True
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        #checking null condition
        if root==None:
            return True
        #checking if the tree is mirror to itself 
        return self.helper(root, root)

        
    def helper(self, root1 :TreeNode, root2 : TreeNode):
        #base codition for the recursion
        if root1 == None and root2 == None:
            return True
        #logic
        """there are three condition first 
        1)if the leftsubtree left is equal to the right subtree of right side
        2) if the leftsubtree right is equal to the left of the right subtree
        3) roots should be same for the right subtree and the left subtre"""
        #checking if any of the root is null if anyone one is null we can conclude that it is not a symmetric tree and it will return false
        if root1 != None and root2!= None:
            #checking the values if the current root1 and root2 are equal and it futher call for the checking of the left subtree and right subtree
            if root1.val == root2.val:
                return self.helper(root1.left, root2.right) and self.helper(root1.right, root2.left)
        return False
