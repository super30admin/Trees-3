# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time complexity O(N) where N is number of nodes in the tree
# Space complexity O(H) where H is height of the tree
class Solution(object):
    def helper(self, root, sum_total, lst, result):
        if root.left is None and root.right is None:
            if root.val == sum_total:
                result.append(lst + [root.val])
            
        if root.left:
            self.helper(root.left, sum_total - root.val, lst + [root.val], result)
        if root.right:
            self.helper(root.right, sum_total - root.val, lst + [root.val], result)
      
        
    def pathSum(self, root, targetSum):
        """
        We need a lst to add node elements and result list to add 
        the lsts that give target
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        if root is None:
            return []
        result = []
        self.helper(root, targetSum, [], result)
        return result