# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def isSymmetric(self, root: TreeNode) -> bool:
        
        def helper(node1 = root.left, node2 = root.right):
            
            # Both nodes are null
            if not (node1 or node2):
                return True
            
            # If exactly one node is null
            if not node1 or not node2:
                return False
                        
            # If values of two nodes are not equal
            if node1.val != node2.val: 
                return False
            
            # Recursively check if subtrees are symmetric as well
            return helper(node1.left, node2.right) and helper(node1.right, node2.left) 
        
        return helper()

### Complexity Analysis

# Time Complexity: O(N) --> Number of Nodes in the tree
# Space Complexity: O(H) --> Height of the tree (Recursive Stack)