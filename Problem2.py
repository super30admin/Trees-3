# Problem 2: Symmetric tree

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Iterative approach
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # null check
        if not root:
            return False
        
        queue = [root.left, root.right]
        while queue:
            # each time two nodes are extracted & their values compared
            t1 = queue.pop(0)
            t2 = queue.pop(0)
            if not t1 and not t2:
                continue
            if not t1 or not t2:
                return False
            if t1.val != t2.val:
                return False
            
            # the mirror elements are added to the queue.
            queue.append(t1.left)
            queue.append(t2.right)
            queue.append(t1.right)
            queue.append(t2.left)
        
        return True

"""
    Complexity Analysis:
    Time: O(n)
    Space: O(n)
"""

# Recursive approach:
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # Recursive approach
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return False
        
        return self.check_symmetric(root.left, root.right)
    
    def check_symmetric(self, t1: Optional[TreeNode], t2: Optional[TreeNode]) -> bool:
        # base
        if not t1 and not t2:
            return True
        if (not t1 and t2) or (t1 and not t2):
            return False
        # logic
        # roots have the same value and right subtree of each tree
        # is a mirror reflection of left subtree other tree.
        return (t1.val == t2.val and self. check_symmetric(t1.left, t2.right) \
                and self.check_symmetric(t1.right, t2.left))


'''
    Complexity Analysis:
    Time: O(n)
    Space: O(n)
'''
"""