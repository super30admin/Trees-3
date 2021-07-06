# Time Complexity: O(n), where n is the number of nodes in the tree
# Space Complexity: O(h), where h is the height of the tree
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True

        return self.helper(root.left, root.right)

    # Helper function to recursively compare the mirror nodes of left and right subtree
    def helper(self, left: TreeNode, right: TreeNode) -> bool:
        if not left and not right:
            return True

        if not left or not right or left.val != right.val:
            return False

        return self.helper(left.left, right.right) and self.helper(left.right, right.left)

