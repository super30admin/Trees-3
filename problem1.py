#path sum2 

# // Time Complexity : O(N)
# // Space Complexity :O(h) h=height of the tree
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this : it was confusing to figure out why the list wasn't working the way I wanted it. After watching the lecture, it was very clear
import copy

class Solution(object):
    def pathSum(self, root, targetSum):
        self.paths=[]
        self.sums=[]
        if root==None: return self.paths
        self.helper(root, targetSum, 0)
        return self.paths
    
    def helper(self, root, target, total):
        if root==None:
            return
        self.sums.append(root.val)
        total+=root.val
        
        if (root.left==None and root.right==None):
            if(total == target):
                copysum=copy.copy(self.sums)
                self.paths.append(copysum)
                
            
        self.helper(root.left, target, total  )
        self.helper(root.right, target, total  )
        self.sums.pop()