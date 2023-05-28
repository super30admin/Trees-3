#Time Complexity:O(n)
#Space Complexity:O(h-height of the tree)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        self.result=[]
        self.dfs(root,[],targetSum)
        return self.result

    def dfs(self,root,path,target):
        if root==None:
            return
        path.append(root.val)
        if not root.left and not root.right and root.val==target:
            self.result.append(copy.copy(path))
        self.dfs(root.left,path,target-root.val)
        self.dfs(root.right,path,target-root.val)
        path.pop()