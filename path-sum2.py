# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result =[]
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root,0, targetSum,[])
        return self.result
    def helper(self,root:TreeNode,currSum:int, targetSum:int,path=list[int]):
        if root == None:
            return
        currSum+=root.val
        path.append(root.val)

        if (root.left is None and root.right is None and currSum == targetSum):
            self.result.append(list(path))
        self.helper(root.left,currSum,targetSum,path)
        self.helper(root.right,currSum,targetSum,path)
        path.pop()


        