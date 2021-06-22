# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.helper(root, root)

    def helper(self, tree1, tree2):
        if tree1 == None and tree2 == None:
            return True
        if tree1 == None or tree2 == None:
            return False

        return (tree1.val == tree2.val) and self.helper(tree1.right, tree2.left) and self.helper(tree1.left,
                                                                                                 tree2.right)
