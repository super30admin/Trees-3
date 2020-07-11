# Time Complexity : O(n) [n = number of nodes in tree]
# Space Complexity : O(h) [h = height of tree]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. Compare the value of the left child and right child
# 2. Push the left child and right child on to stack to equality of the following - 
#   2.1 left of left child and right of right child 
#   2.2 left of right child and right of left child
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        if not root.left and not root.right:
            return True
        
        stack = [root.left,root.right]
        
        while stack:
            l = stack.pop()
            r = stack.pop()
            if not l and not r:
                continue
                
            if (l and not r) or (not l and r) or l.val != r.val:
                return False
            
            stack.append(l.left)
            stack.append(r.right)
            stack.append(l.right)
            stack.append(r.left)    
        return True