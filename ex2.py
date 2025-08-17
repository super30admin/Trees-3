# Time Complexity: O(n)
# Space Complexity: O(h)

class Solution:
    def helper(self, tree1node, tree2node):
        # If both nodes are None, it's symmetric at this branch
        if tree1node is None and tree2node is None:
            return True
        # If only one is None, not symmetric
        if tree1node is None or tree2node is None:
            return False
 
        # left of one should match right of the other and vice versa
        return (tree1node.val == tree2node.val and 
                self.helper(tree1node.left, tree2node.right) and 
                self.helper(tree1node.right, tree2node.left))

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root, root)
