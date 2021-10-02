# sym_tree
# time complexity: O(N)
# space complexity: O(N)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : NA

class Solution(object):
    def isSymmetric(self, root):
        def isSym(L,R):
            if not L and not R: return True
            if L and R and L.val == R.val: 
                return isSym(L.left, R.right) and isSym(L.right, R.left)
            return False
        if root is None:
            return True
        return isSym(root.left, root.right)