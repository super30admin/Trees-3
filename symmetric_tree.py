# O(N) TIME AND O(D) SPACE WHERE N IS NO.OF NODES AND D IS DEPTH OF TREE
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        return self.helper(root.left,root.right)
    
    def helper(self,node1,node2):
        if node1 is None and node2 is None:
            return True
        if node1 is None or node2 is None or node1.val != node2.val:
            return False
        return self.helper(node1.left,node2.right) and self.helper(node1.right,node2.left)