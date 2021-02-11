#Time Complexity :O(n)
#Space Complexity :O(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    isTrue=True
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if(root==None):
            return True
        
        self.helper(root.left,root.right)
        return self.isTrue
    
    def helper(self,left,right):
        #base
        if(left==None and right==None):
            return
        if(left==None or right==None or left.val!=right.val):
            self.isTrue=False
            return 
        
        #logicc
        self.helper(left.left,right.right)
        self.helper(left.right,right.left)
        
        
        