# Trees-3

# Time Complexity: O(n)
# Space Complexity: O(h)
## Problem1 (https://leetcode.com/problems/path-sum-ii/)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        def dfs(node, current_path, current_sum):
            if(node==None): return
            current_path.append(node.val)
            current_sum+=node.val
            if node.left==None and node.right==None and current_sum==targetSum:
                result.append(list(current_path))
            dfs(node.left, current_path, current_sum)
            dfs(node.right, current_path, current_sum)
            current_path.pop()
        dfs(root, [], 0)
        return result

# Time Complexity: O(n)
# Space Complexity: O(h)
## Problem2 (https://leetcode.com/problems/symmetric-tree/)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def isMirror(left:Optional[TreeNode] , right:Optional[TreeNode]):
            if not left and not right:
                return True
            if not left or not right:
                return False
            return left.val == right.val and isMirror(left.left, right.right) and isMirror(left.right, right.left)
        return isMirror(root.left, root.right)
        
