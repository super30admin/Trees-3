# TC : O()
# SC : O(h)
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
        result = []
        
        if root == None:
            return []
        def dfs(root, currSum, path, targetSum):
            if root == None:
                return
            currSum = currSum + root.val
            path.append(root.val)
            if root.left == None and root.right == None:
                if currSum == targetSum:
                    result.append(list(path))
                #return
            dfs(root.left, currSum, path, targetSum)
            dfs(root.right, currSum, path, targetSum)
            path.pop()
            
        dfs(root,0,[],targetSum)
        return result
