# 101. Symmetric Tree
# https://leetcode.com/problems/symmetric-tree/

# Recursive Approach - 1
# Time complexiety: O(n)
# Space complexiety: O(n)
class Solution:
    def _helper(self, root, s, isLeft):
        if not root:
            s.append(-1000)
            return s
        
        if isLeft:
            s.append(root.val)
            self._helper(root.left,s, True)
            self._helper(root.right,s, True)
        else:
            s.append(root.val)
            self._helper(root.right,s, False)
            self._helper(root.left,s, False)
        return s
    
    def isSymmetric(self, root) -> bool:
        return self._helper(root.left, [], True) == self._helper(root.right, [], False)


# Recursive Approach - 2
# Time complexiety: O(n)
# Space complexiety: O(n)
class Solution:
    def _helper(self, l, r):
        if l == None and r == None:
            return True
        
        if l == None or r == None:
            return False
        
        if l.val != r.val:
            return False
        
        return self._helper(l.left,r.right) and self._helper(l.right,r.left)       
    
    def isSymmetric(self, root) -> bool:
        if not root:
            return False
        
        return self._helper(root.left,root.right)


# Iterative Approach
# Time complexiety: O(n)
# Space complexiety: O(n)
class Solution:   
    def isSymmetric(self, root) -> bool:
        if not root:
            return False
        
        stack = []
        stack.append(root.left)
        stack.append(root.right)
        
        while stack:
            r = stack.pop()
            l = stack.pop()
            
            if l == None and r == None:
                continue
            
            if l == None or r == None:
                return False
            
            if l.val != r.val:
                return False
            
            stack.append(l.left)
            stack.append(r.right)
            stack.append(l.right)
            stack.append(r.left)
        return True