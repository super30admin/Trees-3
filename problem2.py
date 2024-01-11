#Time Complexity: O(n)
#Space Complexity: O(h)
#submit on leetcode: yes

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSymmetric(self, root: [TreeNode]) -> bool:
        if root is None:
            return True
        return self.isMirroritself(root, root)

    def isMirroritself(self, root1, root2):
        if root1 is None and root2 is None:
            return True
        
        if root1 is not None and root2 is not None:
            if root1.val == root2.val:
                return (
                    self.isMirroritself(root1.left, root2.right)
                    and self.isMirroritself(root1.right, root2.left)
                )
    
        return False


sol = Solution()

# symmetric binary tree
#         1
#       /   \
#      2     2
#     / \   / \
#    3   4 4   3
symmetric_tree = TreeNode(1)
symmetric_tree.left = TreeNode(2)
symmetric_tree.right = TreeNode(2)
symmetric_tree.left.left = TreeNode(3)
symmetric_tree.left.right = TreeNode(4)
symmetric_tree.right.left = TreeNode(4)
symmetric_tree.right.right = TreeNode(3)

#if the tree is symmetric
result_symmetric = sol.isSymmetric(symmetric_tree)
print("Is the tree symmetric?", result_symmetric)

# non-symmetric binary tree
#         1
#       /   \
#      2     2
#       \     \
#        3     3
non_symmetric_tree = TreeNode(1)
non_symmetric_tree.left = TreeNode(2)
non_symmetric_tree.right = TreeNode(2)
non_symmetric_tree.left.right = TreeNode(3)
non_symmetric_tree.right.right = TreeNode(3)

#if the tree is symmetric
result_non_symmetric = sol.isSymmetric(non_symmetric_tree)
print("Is the tree symmetric?", result_non_symmetric)