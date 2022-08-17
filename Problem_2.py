"""
Time Complexity : O(N) for both sol
Space Complexity :O(N) for both sol
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Problem2 (https://leetcode.com/problems/symmetric-tree/)
"""
# Approach - 1
import collections
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None : return True
        q = deque() 
        q.append(root.left)
        q.append(root.right)
        while q:
            left = q.popleft()
            right = q.popleft()
            
            if left == None and right == None: continue
            if left == None or right == None or left.val != right.val: return False
            
            q.append(left.left)
            q.append(right.right)
            q.append(left.right)
            q.append(right.left)
            
        return True

# Approach - 2
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None: return True
        self.flag = True
        
        
        def dfs(left, right):
            # base
            if left == None and right == None : return
            if left == None or right == None or left.val != right.val:
                self.flag = False
                return
            
            #logic
            if self.flag:
                dfs(left.left, right.right)
            if self.flag:
                dfs(left.right, right.left)
        
        dfs(root.left, root.right)