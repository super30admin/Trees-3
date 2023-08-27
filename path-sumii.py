# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.res = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        arr = []
        if not root:
            return []

        self.checkSum(0,targetSum,root,arr)
        return self.res

    def checkSum(self,sm,targetSum,node,arr):
        smValue = sm +node.val

        if not node.left and node.right:
            if smValue == targetSum:
                arr.append(node.val)
                newarr = copy.deepcopy(arr)
                self.res.append(newarr)
                arr.pop()
                return
        else:
            arr.append(node.val)
            if node.left:
                self.checkSum(smValue,targetSum,node.left,arr)
            else:
                self.checkSum(smValue,targetSum,node.right,arr)
            arr.pop()
            return


    