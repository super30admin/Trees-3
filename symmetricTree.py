class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    # Time Complexity : O(n), where n is the number of nodes in the tree.
    # Space Complexity : O(h), where h is the max height of the tree.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach
    def isSymmetricRecursive(self, root):
        if not root:
            return True
        return self.helper(root.left, root.right)

    def helper(self, left, right):
        if left == None and right == None:
            return True
        if left == None or right == None or left.val != right.val:
            return False

        return self.helper(left.left, right.right) and self.helper(left.right, right.left)

#------------------------------------------------------x---------------------------------------------------------------#

    # Time Complexity : O(n), where n is the number of nodes in the tree.
    # Space Complexity : O(n), where n is the number of nodes in the tree.
    # Did this code successfully run on Leetcode : yes
    # Any problem you faced while coding this : no

    # Your code here along with comments explaining your approach

    def isSymmetricIterative(self, root):
        if not root:
            return True

        stack = [root.left, root.right]

        while len(stack) != 0:
            right = stack.pop()
            left = stack.pop()

            if left == None and right == None:
                continue
            if left == None or right == None or left.val != right.val:
                return False

            stack.append(left.left), stack.append(right.right)
            stack.append(left.right), stack.append(right.left)

        return True

root = TreeNode(1, TreeNode(2, TreeNode(3), TreeNode(4)), TreeNode(2, TreeNode(4), TreeNode(3)))  # True
print Solution().isSymmetricIterative(root), Solution().isSymmetricRecursive(root)
