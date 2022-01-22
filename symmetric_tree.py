# Definition for a binary tree node.
# TC : O(n)
# SC :O(height of tree) in best case

from pip import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def traversor(left_tree, right_tree):
            
            if left_tree==None and right_tree==None:
                return True
            if left_tree and right_tree and left_tree.left == None and left_tree.right == None and right_tree.left == None and right_tree.right == None:
                if left_tree.val == right_tree.val:
                    return True
            
            if left_tree and right_tree:
                print(left_tree.val, right_tree.val)
                if left_tree.val == right_tree.val:
                            return traversor(left_tree.left, right_tree.right) and traversor(left_tree.right, right_tree.left) 
                        
            return False
        
        return traversor(root.left, root.right)
            
        