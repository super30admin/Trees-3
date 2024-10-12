# 113. Path Sum II
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def helper(root,currSum,path,targetSum):
            if not root:
                return

            newList = list(path)
            currSum += root.val
            newList.append(root.val)
            if root.left == None and root.right == None:
                if currSum == targetSum:
                    result.append(newList)

            helper(root.left,currSum,newList,targetSum)
            helper(root.right,currSum,newList,targetSum)
            

        result = []
        path = []
        helper(root,0,path,targetSum)
        return result
        