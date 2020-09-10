# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if(root == None):
            return []
        
        output = []
        rootToLeaf = []
        
        self.recurr(root, 0, sum, rootToLeaf, output)
        return output
        
    def recurr(self, root, total, target, rootToLeaf, output):
        if(root == None):
            return
        
        if(root.left == None and root.right == None):
            if(total + root.val == target):
                temp = rootToLeaf[:]
                temp.append(root.val)
                output.append(temp)
            return
        
        rootToLeaf.append(root.val)
        
        self.recurr(root.left, total + root.val, target, rootToLeaf, output)
        self.recurr(root.right, total + root.val, target, rootToLeaf, output)
        
        del rootToLeaf[-1]
