# Check if a binary tree is symmetric using recursion and queue-based approach.
# Time: O(N), Space: O(H) for recursion stack

from typing import Optional
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# RECURSIVE SOLUTION
class SolutionRecursive:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        return self.check(root.left, root.right)

    def check(self, root1, root2):
        if not root1 and not root2:
            return True
        if not root1 or not root2:
            return False
        if root1.val != root2.val:
            return False
        return self.check(root1.left, root2.right) and self.check(
            root1.right, root2.left
        )


# ITERATIVE (QUEUE) SOLUTION
# Time: O(N), Space: O(N) for queue
class SolutionIterative:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        queue = deque([(root.left, root.right)])

        while queue:
            left, right = queue.popleft()

            if not left and not right:
                continue
            if not left or not right:
                return False
            if left.val != right.val:
                return False

            queue.append((left.left, right.right))
            queue.append((left.right, right.left))

        return True


def build_symmetric_tree():
    #         1
    #       /   \
    #      2     2
    #     / \   / \
    #    3  4  4   3
    root = TreeNode(1)
    root.left = TreeNode(2, TreeNode(3), TreeNode(4))
    root.right = TreeNode(2, TreeNode(4), TreeNode(3))
    return root


def build_asymmetric_tree():
    #         1
    #       /   \
    #      2     2
    #       \     \
    #        3     3
    root = TreeNode(1)
    root.left = TreeNode(2, None, TreeNode(3))
    root.right = TreeNode(2, None, TreeNode(3))
    return root


print("Symmetric Tree Test:")
sym_tree = build_symmetric_tree()
print("Recursive:", SolutionRecursive().isSymmetric(sym_tree))
print("Iterative:", SolutionIterative().isSymmetric(sym_tree))

print("\nAsymmetric Tree Test:")
asym_tree = build_asymmetric_tree()
print("Recursive:", SolutionRecursive().isSymmetric(asym_tree))
print("Iterative:", SolutionIterative().isSymmetric(asym_tree))
