#Time Complexity : O(n)
#Space Complexity : O(n)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        self.flag = True
        self.helper(root.left, root.right)
        return self.flag
        
        
    def helper(self,root1, root2):
        if(root1 == None and root2 == None):
            return 
        
        if((root1 == None and root2 != None) or (root1 != None and root2 == None) or (root1.val != root2.val)):
            self.flag = False
            return
        
        self.helper(root1.left, root2.right)
        self.helper(root1.right, root2.left)
        
