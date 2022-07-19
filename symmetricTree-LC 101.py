# Time Complexity = O(n)
# Space Complexity = O(h), where h is the height of the tree



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.isSymm = True
        
        if root == None:
            return True
        
        self.helper(root.left, root.right)
        
        return self.isSymm
    
    
    def helper(self, left: TreeNode, right: TreeNode):
        # Base Case
        if left == None and right == None:
            return
        
        
        # If both left and right are null, then it should be true, but if the 1st condition is true, it won't go to the 2nd one, which might result in a wrong answer, hence the above base case if added before
        if (left == None or right == None or left.val != right.val):
            self.isSymm = False
            return                      # Returning when once a mismatch occurs so that it doesn't keep recursing over null nodes that will result in runtime error
            
        self.helper(left.left, right.right)
        self.helper(left.right, right.left)