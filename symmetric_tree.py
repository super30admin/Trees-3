class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def helper( left, right ):
            if not left and not right :
                return True 
            if not left or not right:
                return False
            
            return (left.val == right.val ) and helper( left.left, right.right )and helper( left.right, right.left )
            
        return helper(root.left, root.right)
