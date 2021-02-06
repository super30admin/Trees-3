"""
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
Recursive Solution :
"""
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root: return True      

        return self.helper(root.left, root.right)
        
    def helper(self, root1, root2):
        # Base case
        if not root1 and not root2: return True
        if not root1 or not root2: return False
        if root1.val != root2.val: return False

        # Logic
        check1 = self.helper(root1.left, root2.right)
        check2 = self.helper(root1.right, root2.left)

        return (check1 and check2)
"""
Iterative Solution :
"""
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root: return True
        stack = []
        stack.append(root.left)
        stack.append(root.right)
        
        while stack:
            left = stack.pop()
            right = stack.pop()
            if left==None and right==None: continue
            if left==None or right==None or left.val != right.val:
                return False
            stack.append(left.left)
            stack.append(right.right)
            stack.append(left.right)
            stack.append(right.left)
            
        return True