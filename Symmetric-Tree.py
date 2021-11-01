# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes
# Writing out all the conditions for it to fail


# Traverse the binary tree and 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # Base Condition
        if root.left is None and root.right is None:
            return True
        elif root.left is None or root.right is None:
            return False
        
        # Check left and right subtree
        # traverse left subtree
        l_root = root.left
        r_root = root.right
        l_stack = []
        r_stack = []
        while l_root is not None or l_stack:            
            # iterate all the left nodes for left subtree
            # all right nodes for right subtree
            while l_root is not None:
                if r_root is None or l_root.val != r_root.val:
                    return False                
                l_stack.append(l_root)                
                r_stack.append(r_root)
                l_root = l_root.left
                r_root = r_root.right
            if r_root is not None:
                return False
            # all left exhausted pop prev 
            l_root = l_stack.pop(len(l_stack)-1)     
            r_root = r_stack.pop(len(r_stack)-1)
            # get right value of prev and repeat process
            l_root = l_root.right
            r_root = r_root.left
        if r_root is not None:
            return False
        return True
        
# Time Complexity : O(n)
# Space Complexity : O(n) - recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Recursive Solution
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # Create new function to pass the pos of left and right
        return self.isMirror(root.left, root.right)
    
    def isMirror(self, l_root, r_root):
        # Base Condition - compare if pos of left and right are unequal
        # required since if they are None the .val in line 21 would fail
        if l_root is None and r_root is None:
            return True
        elif l_root is None or r_root is None:
            return False
        
        # Check if left root of left and right root of right are same
        # if the the children are mirrored
        return (l_root.val == r_root.val) \
                and self.isMirror(l_root.left, r_root.right)\
                and self.isMirror(l_root.right, r_root.left)

# Time Complexity : O(n)
# Space Complexity : O(n) - Queue space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No                

# Iterative Solution
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # initialize queue 
        # Do a BFS with the order of children being
        # the order the values should be the same
        queue = []
        queue.append(root.left)
        queue.append(root.right)
        while queue:
            left = queue.pop(0)
            right = queue.pop(0)
            #Check the base conditions
            if left is None and right is None:
                continue 
            if left is None or right is None:
                return False
            if left.val != right.val:
                return False
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)
        return True
            
