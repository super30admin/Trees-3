class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def helper(self,left,right):
            if left==None and right==None:
                return True
            if left==None or right==None or left.val!=right.val:
                return False
            return helper(self,left.left,right.right) and helper(self,left.right,right.left)
        if root==None:
            return True
        return helper(self,root.left,root.right)

#Time-Complexity: O(N)
#Space-Complexity: O(H) where H is the height of tree