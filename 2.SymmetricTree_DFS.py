# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    Time Complexity: 0(n)
    Space Complexity: 0(h)
    Approach: 
        DFS -- Traversal using left and right node at same time
    """
    def __traversal(self, nodeLeft: Optional[TreeNode], nodeRight: Optional[TreeNode]) -> bool:

        # base-case
        if nodeLeft is None and nodeRight is None:
            return True
        
        elif nodeLeft is None and nodeRight is not None:
            return False
        
        elif nodeLeft is not None and nodeRight is None:
            return False

        elif nodeLeft.val != nodeRight.val:
            return False
            
        # logic-case
        
        if self.__traversal(nodeLeft.left, nodeRight.right):
            return self.__traversal(nodeLeft.right, nodeRight.left)
        else:
            return False

    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.__traversal(root.left, root.right)
