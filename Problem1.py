# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root: return []
        result = []

        def dfs(root, cur_path, cur_sum):
            if not root:
                return


            cur_path.append(root.val)
            cur_sum+=root.val

            if not root.left and not root.right:
                nonlocal result
                if cur_sum == targetSum:
                    result.append(cur_path.copy())


            dfs(root.left, cur_path, cur_sum)
            dfs(root.right, cur_path, cur_sum)
            cur_path.pop()
        
        dfs(root, [], 0)
        return result
