#Time complexity: O(n)   
#Space complexity: O(h) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

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
        self.result = []
        if root is None:
            return self.result
        def helper(root,targetSum,curSum,path):
            #base
            if root is None:
                return None
            #logic
            curSum += root.val
            path.append(root.val)
            if root.left is None and root.right is None:
                if curSum == targetSum:
                    # Creating a new list for the result path as the tracking path list would be backtracked
                    resPath = [x for x in path]
                    self.result.append(resPath)
            helper(root.left,targetSum,curSum,path)
            helper(root.right,targetSum,curSum,path)
            #backtrack
            #By this step we don't have to create a new list everytime we go to a new node
            path.pop()
        helper(root,targetSum,0,[])
        return self.result