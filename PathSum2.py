# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        # TC : O(n)
        # SC : O(h)
        res = []
        def dfs(root: Optional[TreeNode],curSum:int,path:List[int]) -> None:
            # base
            if root is None:
                return
            # logic
            curSum += root.val
            path.append(root.val)
            if root.left is None and root.right is None:
                if curSum == targetSum:
                    # copying path as a new list instance to avoid empty list error due to pass by memory refference
                    res.append(list(path))
            dfs(root.left,curSum,path)
            dfs(root.right,curSum,path)
            path.pop()


        if root is None:
            return []
        dfs(root,0,[])
        return res
        