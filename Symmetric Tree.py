# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #Solution 1
    def isSymmetric(self, root: TreeNode) -> bool:
        #Approach: Recursion; boolean helper
        #Time Complexity: O(n) // visiting every node exactly once
        #Space Complexity: O(h) // recursion stack
        
        if not root:
            return True
        
        return self.helper(root.left, root.right)
    
    def helper(self, left, right):
        #base
        if not left and not right:
            return True
        if not left or not right or left.val != right.val:
            return False
        
        #logic
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
    
    #Solution 2
    """
    def isSymmetric(self, root: TreeNode) -> bool:
        #Approach: Recursion; void helper
        #Time Complexity: O(n) // visiting every node exactly once
        #Space Complexity: O(h) // recursion stack
        
        if not root:
            return True
        
        self.isValid = True
        self.helper(root.left, root.right)
        return self.isValid
    
    def helper(self, left, right):
        #base
        if not left and not right:
            return
        if not left or not right or left.val != right.val:
            self.isValid = False
            return
        
        #logic
        self.helper(left.left, right.right)
        self.helper(left.right, right.left)
    """
    
    #Solution 3
    """
    def isSymmetric(self, root: TreeNode) -> bool:
        #Approach: Iterative
        #Time Complexity: O(n) // visiting every node exactly once
        #Space Complexity: O(h) // recursion stack
        
        if not root:
            return True
        
        st = []
        st.append((root.left, root.right))
        
        while st:
            left, right = st.pop()
            
            if not left and not right:
                continue
            if not left or not right or left.val != right.val:
                return False
            
            st.append((left.left, right.right))
            st.append((left.right, right.left))
        
        return True
    """