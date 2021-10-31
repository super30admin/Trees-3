# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(n)
# Space Complexity: O(n)
# Logic: in any symmetry node1.left == node2.right & node1.right == node2.left where node 1 & node2 are left & right of
# of a tree.

class Node:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self, root):
        self.root = Node(root)

    def isSymmetric(self, root) -> bool:
        if not root.left and not root.right:
            return True
        if not root.left or not root.right:
            return False

        def helper(left, right):
            if not left and not right:
                return True
            if not left or not right:
                return False
            if not (left.val == right.val):
                return False
            status1 = helper(left.left, right.right)
            status2 = helper(left.right, right.left)
            return status1 and status2
        return helper(root.left, root.right)


tree = Solution(1)
tree.root.left = Node(2)
tree.root.right = Node(2)
tree.root.left.left = Node(3)
tree.root.left.right = Node(4)
tree.root.right.left = Node(4)
tree.root.right.right = Node(3)
print(tree.isSymmetric(tree.root))
