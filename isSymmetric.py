# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        #. Idea: To check symmetry, for nodes at same level, left of each node should be equal to right of each node. Secondly, right of each node should be equal to left of each node.
        # Algorithm: Have two pointers (left and right) to compare the nodes
        # Data Structure: No additionaly data structure required, Tree can be traversed directly
        
        # Time Complexity: O(N) traversing each node
        # Space Complexity: O(1)
        if root is None or (root.left is None and root.right is None):
            return True
        return self.helper(root.left,root.right)
        
    def helper(self,lnode,rnode):
        if lnode is None and rnode is None:
            return True
        if (lnode is None or rnode is None) or lnode.val != rnode.val:
            return False   
        return self.helper(lnode.left,rnode.right) and self.helper(lnode.right,rnode.left)
        
