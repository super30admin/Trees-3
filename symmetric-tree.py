"""

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Time Complexity: O(N), where N is the number of nodes in the tree, as we visit each node once.
Space Complexity: O(H), where H is the height of the tree, due to recursive call stack usage (O(log N) for balanced trees, O(N) for skewed trees).

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""

# Approach: 
# Used a recursive depth-first search (DFS) to compare the left and right subtrees, ensuring they are mirror images. 
# The base cases handle when both nodes are None (symmetric) or when only one is None (not symmetric). 
# then recursively check the outer and inner pairs of corresponding nodes for symmetry.


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        def dfs(left, right):

            if not left and not right:
                return True
            if not left or not right:
                return False
            
            return (left.val == right.val and 
                    dfs(left.left, right.right) and
                    dfs(left.right, right.left))

        return dfs(root.left, root.right)

