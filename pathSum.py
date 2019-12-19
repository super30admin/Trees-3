# Time Complexity : O(n)
# Space Complexity : O(k) k:height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : remSum - node.val== 0 condition

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def __helper(self, node, remSum, List):
        # Base Condition
        if node is None:
            return List
        
        if node.left is None and node.right is None and remSum - node.val== 0:
            self.retList.append(List + [node.val])
            return
        
        self.__helper(node.left, remSum - node.val,List + [node.val])
        self.__helper(node.right, remSum - node.val,List + [node.val])
        
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        self.retList = []
        self.__helper(root, sum, [])
        return self.retList