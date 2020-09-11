"""
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Time = O(n), n = number of nodes in a tree
Space = O(n), n = number of nodes in a tree
Successfully excecuted on leetcode

Approach ---
1. Iterative solution with stack
2. Create a stack to store root, preorder and inorder for each sub tree step left and right sub trees
3. If one of the left and right subtrees is empty, return false. If both are empty return True
4. Compare the value of left and right child of root. 
5. Iteratively append left and right subtree's children to follow the same steps.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Symmetric:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if not root:
            return True
        stack = []
        stack.append((root.left, root.right))
        #print(stack)
        while stack:
            l, r = stack.pop(0)
            if not l and not r:
                continue
            if not l or not r:
                return False
            if l.val != r.val:
                return False
            stack.append((l.left, r.right))
            stack.append((l.right, r.left))
        return True
