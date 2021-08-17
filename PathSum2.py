"""
//Time Complexity : O(n^2)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
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
        if root == None:
            return []
        result = []
        self.dfs(root,targetSum,[],result)
        return result
    def dfs(self,root,targetSum,path,result):
        #base
        if root == None:
            return
        
        #logic
        path.append(root.val)
        if(root.left==None and root.right==None):
            if(targetSum - root.val == 0):
                result.append(path)
        self.dfs(root.left,targetSum - root.val,list(path),result)
        self.dfs(root.right,targetSum - root.val,list(path),result)
        