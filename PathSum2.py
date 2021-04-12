# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity is O(n), n being number of nodes
# Space Complexity is O(h), h being the height of the tree
class Solution(object):
    def __init__(self):
        self.output = []
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        if root is None:
            return self.output
        self.backtrack(root,[],0,targetSum)
        return self.output
    
    def backtrack(self,root,path,prevSum,target):
        currSum = prevSum + root.val
        path.append(root.val)
        if(root.left is None and root.right is None and currSum == target):
            self.output.append(list(path))
        if(root.left):
            self.backtrack(root.left,path,currSum,target)
        if(root.right):
            self.backtrack(root.right,path,currSum,target)
        path.pop()