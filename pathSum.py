# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        def dfs(node,path,current_sum):
            if not node:
                return

            path.append(node.val)
            current_sum += node.val

            if not node.left and not node.right and current_sum == targetSum:
                result.append(list(path))
            dfs (node.left,path,current_sum)
            dfs (node.right,path,current_sum)

            path.pop()
        result = []
        dfs(root,[],0)
        return result
        
#time complexity: N number of nodes in Tree.
# space complexity: H height height of the tree
