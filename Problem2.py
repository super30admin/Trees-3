# Time Complexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def recurse(self, root1, root2):
        
        if not root1 and not root2:
            return True
        if (root1 and root2) and root1.val == root2.val:
            
            return self.recurse(root1.left, root2.right) and self.recurse(root1.right, root2.left)
            
        else:
            return False
    
    def isSymmetric(self, root: TreeNode) -> bool:
        
        return self.recurse(root, root) 


# Iterative Approach
# Time Complexity: O(N)
# Space Complexity: O(N)
# Passed Leetcode

from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:

    def isSymmetric(self, root: TreeNode) -> bool:
        
        queue = deque()
        queue.append((root, root))
        
        while len(queue) > 0:
            
            n1, n2 = queue.popleft()
            
            if (not n1 and not n2) or ((n1 and n2) and n1.val == n2.val):
                
                if n1:
                    queue.append((n1.left, n2.right))
                    queue.append((n1.right, n2.left))   
            else:
                return False
        return True

