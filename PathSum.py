class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res: List[List[int]] = []

        def dfs(node: Optional[TreeNode], rem: int, path: List[int]) -> None:
            if not node:
                return

         
            path.append(node.val)
            rem -= node.val

           
            if not node.left and not node.right and rem == 0:
                res.append(path.copy())

          
            dfs(node.left, rem, path)
            dfs(node.right, rem, path)

            path.pop()

        dfs(root, targetSum, [])
        return res
#  Time Complexity : O(N + K·H)
#    Visit each node once (O(N)); for each valid path (K paths), copying costs O(H) where H is path length ≤ tree height.
#  Space Complexity : O(H) extra for recursion stack; output uses O(K·H).
#  Did this code successfully run on LeetCode : Yes (113).
#  Any problem you faced while coding this :
#    - Forgetting to backtrack (missing path.pop()).
#    - Mutating the same list for multiple branches (must copy when saving).
#    - Checking sum before confirming it's a leaf (must be root→leaf).