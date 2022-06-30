# Time Complexity : O(n)
# Space Complexity : O(height)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        self.currentPath = []
        self.path(root,targetSum)
        return self.res
        
    def path(self,root,targetsum):
        
        if root == None:
            return
        
        targetsum -= root.val
        self.currentPath.append(root.val)
        
        if root.left == None and root.right == None and targetsum == 0:
            self.res.append(list(self.currentPath))
            
        self.path(root.left,targetsum)
        self.path(root.right,targetsum)
        
        self.currentPath.pop()