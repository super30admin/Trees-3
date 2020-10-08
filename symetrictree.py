class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        
        if not root:
            return True
        
        left = root.left
        right = root.right
        
        def check(l,r):
            if not l and not r:
                return True
            
            if not l and r:
                return False
            
            if l and not r:
                return False
            
            if l.val!=r.val:
                return False
            
            return check(l.left,r.right) and check(l.right,r.left)
        
        return check(left,right)
        
        
        # time and space complexity is o(n), approach is self explainatory. just need to check if left subtree is mirror image of right subtree or not. 
