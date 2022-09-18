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
        result = []
        temp = []
        def path(root,target,temp,result):
            if(not root):
                return
            temp.append(root.val)
            if(root.left==None and root.right==None and root.val==target):
                temp_copy = temp[:]
                result.append(temp_copy)
            path(root.left,target-root.val,temp,result)
            path(root.right,target-root.val,temp,result)
            temp.pop()
        path(root,targetSum,temp,result)
        return result