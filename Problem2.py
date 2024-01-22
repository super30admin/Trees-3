'''
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

Perform DFS recursively on both sides of the tree to checking if the elements on either side form mirror images


'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def helper(node1,node2):
            if node1 and node2:
                if node1.val == node2.val:
                    return helper(node1.left, node2.right) and helper(node1.right, node2.left)
                else:
                    return False

            else:
                if not node1 and not node2:
                    return True
                else:
                    return False

        return helper(root.left, root.right)

