"""
Leetcode 101 - Symmetric Tree

Determines whether a binary tree is symmetric around its center.

Methods
-------
isSymmetric(root: TreeNode) -> bool:
    Returns True if the tree is a mirror of itself.

helper(leftnode: TreeNode, rightnode: TreeNode) -> bool:
    Recursively checks if two subtrees are mirrors of each other.

Time Complexity: O(n)
    Every node is visited once.

Space Complexity: O(h)
    h = height of the tree, due to recursion stack.
"""

class TreeNode:
    def __init__(self, val=0, left=None, right = None):
        self.val = val
        self.left = left
        self.right = right

class solution:
    def isSymmetric(self, root):
        leftnode = root.left
        rightnode = root.right
        val = self.helper(leftnode, rightnode)
        return val
    def helper(self, leftnode, rightnode):
        if not leftnode and not rightnode:
            return True
        if not leftnode or not rightnode:
            return False
        
        val = (leftnode.val == rightnode.val and self.helper(leftnode.left, rightnode.right) and self.helper(leftnode.right, rightnode.left))
        return val

# ---------- MAIN FUNCTION ----------
from collections import deque

def buildTree(values):
    if not values:
        return None
    root = TreeNode(values[0])
    queue = deque([root])
    i = 1
    while queue and i < len(values):
        node = queue.popleft()
        if i < len(values) and values[i] is not None:
            node.left = TreeNode(values[i])
            queue.append(node.left)
        i += 1
        if i < len(values) and values[i] is not None:
            node.right = TreeNode(values[i])
            queue.append(node.right)
        i += 1
    return root

if __name__ == "__main__":
    # Example 1: Symmetric
    vals1 = [1, 2, 2, 3, 4, 4, 3]
    root1 = buildTree(vals1)
    sol1 = solution()
    print("Is the tree symmetric? (Example 1):", sol1.isSymmetric(root1))  # True

    # Example 2: Not symmetric
    vals2 = [1, 2, 2, None, 3, None, 3]
    root2 = buildTree(vals2)
    sol2 = solution()
    print("Is the tree symmetric? (Example 2):", sol2.isSymmetric(root2))  # False