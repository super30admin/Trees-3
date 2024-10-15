# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Approach:
- This solution checks whether the binary tree is symmetric by comparing the left and right subtrees.
- The function uses Depth-First Search (DFS) to recursively compare corresponding nodes in the left and right subtrees.
- The tree is symmetric if:
  1. Both left and right subtrees are empty.
  2. Both left and right subtrees have the same root value and their children are mirror images of each other.
- We recursively check this by comparing the left child of the left subtree with the right child of the right subtree, and the right child of the left subtree with the left child of the right subtree.

Time Complexity (TC):
- O(N): We visit every node exactly once, where N is the number of nodes in the tree.

Space Complexity (SC):
- O(H): The recursion depth is limited by the height of the tree (H), which is O(N) in the worst case (for a skewed tree), and O(log N) in the best case (for a balanced tree).
"""

class Solution(object):
    def isSymmetric(self, root):
        def dfs(left, right):
            if not left and not right:
                return True
            if not left or not right:
                return False

            return (left.val == right.val and 
                    dfs(left.left, right.right) and
                    dfs(left.right, right.left))

        return dfs(root.left, root.right)
