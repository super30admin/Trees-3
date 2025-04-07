'''
The function isSymmetric checks whether a binary tree is symmetric around its center. 
We define a helper function isMirror(left, right) that compares two subtrees, 
ensuring that both the values of the nodes match and that the left subtree is a mirror image of the right subtree, and vice versa. 
If at any point the nodes are not equal or the structure of the subtrees doesn't match, the tree is not symmetric.

Time Complexity: O(n) -> n is the number of nodes in the binary tree
Space Complexity: O(h) -> h is the height of the tree
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def isMirror(left, right):
            if not left and not right:
                return True
            if not left or not right:
                return False
            return ((left.val == right.val) and isMirror(left.left,right.right) and isMirror(left.right, right.left))
        
        
        if not root: return True
        
        return isMirror(root.left, root.right)