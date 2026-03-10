#Path Sum II

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time complexity -> O(n), going through each element fif the item
# Space complexity -> O(h), depth of the tree both the stack space and the array space
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        resultList=[]
        pathList = []

        currentSum = 0

        if root!= None:
            self.helper(root, targetSum, resultList, pathList, currentSum)


        return resultList
    
    def helper(self,root, targetSum, resultList, pathList, currentSum):
        pathList.append(root.val)
        currentSum+=root.val

        if root.left != None:
            self.helper(root.left, targetSum, resultList, pathList, currentSum)

        if root.right != None:
            self.helper(root.right, targetSum, resultList, pathList, currentSum)

        if root.left == None and root.right == None and currentSum==targetSum:
            resultList.append(pathList[:])

        pathList.pop()