# path_sum_II
# time complexity: O(N^2)
# space complexity: O(N)
# Did this code successfully run on Leetcode : NA
# Any problem you faced while coding this : NA

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        def helper(root, total, path, targetSum):
            nonlocal result
            if root is None:
                return 
            total += root.val
            path.append(root.val)
            if root.left is None and root.right is None:
                if total == targetSum:
                    result.append(path.copy())
            helper(root.left,total,path,targetSum)
            helper(root.right, total, path, targetSum)
            path.pop()
        
        helper(root, 0, [], targetSum)
        return result