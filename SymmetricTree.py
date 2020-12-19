# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach: Recursive

# Here every time for left and right subtree we are asking two questions: 1) Is their value equal 2) Is left tree's left value and right tree's right value and left tree's right value and right tree's left value are equal. So in our recursion whenever these condition turn out to be false we will just return false else true

# Time complexity: O(n) ; n = no of nodes
# Space complexity: O(n); n = no of nodes
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None or (root.left == None and root.right == None) :
            return True
        
        return self.helper(root.left, root.right)
        
    def helper(self, leftTree, rightTree):
        if leftTree == None and rightTree == None:
            return True
        
        if leftTree == None or rightTree == None or leftTree.val != rightTree.val:
            return False
        
        return self.helper(leftTree.left, rightTree.right) and self.helper(leftTree.right, rightTree.left)
        
        