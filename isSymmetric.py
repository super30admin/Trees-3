# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
############## Method 1: Using BFS ###########
from queue import Queue

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # If the tree is empty, it's symmetric.
        if root is None:
            return True
        
        # Initialize a queue to perform BFS. Add the left and right children of the root.
        q = Queue()
        q.put(root.left)
        q.put(root.right)
        
        # Continue BFS until the queue is empty.
        while not q.empty():
            # Extract two nodes at a time to compare them.
            left = q.get()
            right = q.get()
            
            # If both nodes are None, continue to the next pair of nodes.
            if left is None and right is None:
                continue
            
            # If one node is None and the other is not, the tree is not symmetric.
            if left is None or right is None:
                return False
            
            # If the values of the two nodes are not equal, the tree is not symmetric.
            if left.val != right.val:
                return False
            
            # Add the children of the nodes to the queue in a specific order.
            # This order ensures that left and right subtrees are compared correctly.
            q.put(left.left)
            q.put(right.right)
            q.put(left.right)
            q.put(right.left)
        
        # If all comparisons are valid, the tree is symmetric.
        return True
"""
The time complexity of this algorithm is O(n).
The space complexity is = O(n), where n is the number of nodes in the tree.
"""


############### Method 2: DFS #################
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # If the tree is empty, it is symmetric by definition.
        if root is None:
            return True
        
        # Initialize a variable to store the result. By default, assume the tree is symmetric.
        self.isSymmetric = True
        
        # Start the DFS traversal to check symmetry from the left and right children of the root.
        self.dfs(root.left, root.right)
        
        # Return the result.
        return self.isSymmetric
    
    def dfs(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> None:
        # If both nodes are None, they are symmetric (base case).
        if left is None and right is None:
            return
        
        # If one node is None and the other is not, the tree is not symmetric.
        if left is None or right is None:
            self.isSymmetric = False
            return
        
        # If the values of the two nodes are not equal, the tree is not symmetric.
        if left.val != right.val:
            self.isSymmetric = False
            return
        
        # Recursively check the left and right subtrees in a mirrored manner.
        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)
""" 
The time complexity of this algorithm is O(n)
where n is the number of nodes in the tree.
The space complexity is O(h)
"""


