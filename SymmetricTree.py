# Time Complexity : O(N)
# Space Complexity : O(H) for the recursion stack

# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
                
        def recur(p, q):
            if p == None and q == None:
                return True
            if p == None or q == None:
                return False
            if p.val != q.val:
                return False
            
            return recur(p.left, q.right) and recur(p.right, q.left)
        
        return recur(root.left, root.right)