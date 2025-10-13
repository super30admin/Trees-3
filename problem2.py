# Time Complexity : O(N)
# (Each node is visited once to check its mirror counterpart)
#
# Space Complexity : O(H)
# (H = height of the tree due to recursion stack)
#
# Did this code successfully run on Leetcode : Yes
#
# Any problem you faced while coding this :
# Initially might confuse checking 'root' instead of comparing
# pairs of nodes (left and right subtrees).

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:

        # Helper function to compare two subtrees and check if they are mirror images
        def isMirror(a, b):
            # If both nodes are None, it’s symmetric up to this point
            if not a and not b:
                return True

            # If one is None or values don’t match → not symmetric
            if not a or not b or a.val != b.val:
                return False

            # Recursively check:
            #  - left subtree of 'a' with right subtree of 'b'
            #  - right subtree of 'a' with left subtree of 'b'
            return isMirror(a.left, b.right) and isMirror(a.right, b.left)

        # Edge case: if the root is None, it’s symmetric by definition
        if not root:
            return True

        # Start by comparing the left and right subtrees of the root
        return isMirror(root.left, root.right)
