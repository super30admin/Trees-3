# Time Complexity : O(N)  //Where n is the size of the array
#  Space Complexity : O(H)  //Recursive stack for the tree
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : N/A

#  Your code here along with comments explaining your approach

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def symmetric(left, right):
            if left and right:
                if left.val == right.val:
                    # pass left of left subtree and right of right subtree and
                    # right of left subtree and left of right subtree
                    return symmetric(left.left, right.right) and symmetric(left.right, right.left)
            
            # if we reach at leaves, then return true
            return left == None and right == None
        
        # start with both children of root
        return symmetric(root.left, root.right)