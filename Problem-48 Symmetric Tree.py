# 101. Symmetric Tree
# https://leetcode.com/problems/symmetric-tree/

# Recursive Approach
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


# Iterative Approach
# Time complexiety: 
# Space complexiety: 
class Solution:
    def isSymmetric(self, root) -> bool:
        pass