# Time Complexity: O(N)
# Space Complexity: O(H) where H is the height of the tree
# Were you able to solve this on your own? Yes
# Any problem you faced while coding this: No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        # Case if root is None or only one node is present
        # In both cases, the tree is symmetric
        if not root or (root.left is None and root.right is None):
            return True
        

        def dfs(left: TreeNode, right: TreeNode):
            
            # If both left and right nodes are None, it is symmetric
            # base case
            if left is None and right is None:
                return True
            
            # If one of the nodes is None, it is not symmetric
            if left is None or right is None:
                return False
            
            # Check if the values of left and right nodes are equal
            # If not, it is not symmetric
            if left.val != right.val:
                return False

            # Recursively check the left and right subtrees
            # left.left should be equal to right.right and left.right should be equal to right.left
            return dfs(left.left, right.right) and dfs(left.right, right.left)

        return dfs(root.left, root.right)

