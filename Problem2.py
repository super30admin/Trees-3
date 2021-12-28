#Time Complexity : O(n) - Visiting each node once
#Space Complexity : O(n) - For the recursive stack


def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        if root == None:
            return True
        
        return self.dfs(root.left, root.right)
        
        
    def dfs(self, left, right):
        
        if left == None and right == None:
            return True
        
        if left != None and right != None:
            if left.val != right.val:
                return False
            return (self.dfs(left.left, right.right) and self.dfs(left.right, right.left))
        
        return False
    