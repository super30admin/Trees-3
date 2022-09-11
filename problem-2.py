#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def mirror(self,root1,root2)->bool:
        if root1 == None and root2 == None:
            return True
        if root1 == None or root2 == None:
            return False
        return (root1.val == root2.val) and self.mirror(root1.left,root2.right) and self.mirror(root1.right,root2.left) # Comparing if the 2 subtrees are mirror images to each other
    
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None: #Base case
            return True
        return self.mirror(root.left,root.right)