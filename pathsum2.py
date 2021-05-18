# Definition for a binary tree node.
from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    result=[]
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:

        self.recsolution(root=root,currentsum=0,path=[],targetSum=targetSum)

        return self.result


    def recsolution(self,root: TreeNode, currentsum: int, path: List,targetSum:int):
        if root is None:
            return
        currentsum+=root.val
        path.append(root.val)
        if root.left is None and root.right is None:
            if currentsum==targetSum:
                self.result.append(path)

        self.recsolution(root=root.left,currentsum=currentsum,path=path.copy(),targetSum=targetSum)
        self.recsolution(root=root.right, currentsum=currentsum, path=path.copy(), targetSum=targetSum)





if __name__ == '__main__':
    root = TreeNode(5)
    root.left = TreeNode(4)
    root.right = TreeNode(8)
    root.left.left = TreeNode(11)
    root.left.left.left=TreeNode(7)
    root.left.left.right=TreeNode(2)

    root.right.left = TreeNode(13)
    root.right.right = TreeNode(4)
    root.right.left.left = TreeNode(5)
    root.right.left.right = TreeNode(1)

    print(Solution().pathSum(root=root,targetSum=22))
