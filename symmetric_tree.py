class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root == None:
            return True
        self.isSymmetric = True
        self.dfs(root.left, root.right)
        return self.isSymmetric
        
    def dfs(self, left: Optional[TreeNode], right: Optional[TreeNode]) -> None:
        if left == None and right == None:
            return 
        if left == None or right == None:
            self.isSymmetric = False
            return
        if left.val != right.val:
            self.isSymmetric = False
            return
        self.dfs(left.left, right.right)
        self.dfs(left.right, right.left)

# Time complexity - O(n)
# Space complexity - O(h)