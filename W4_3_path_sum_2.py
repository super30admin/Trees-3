# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.number_ways = 0
        self.result = []
        self.helper(root, 0, targetSum, list())
        return self.result

    def helper(self, root, currSum, targetSum, result_list):
        #Base
        if root == None:
            return
        #Logic
        currSum = currSum + root.val
        result_list.append(root.val)
        
        self.helper(root.left, currSum, targetSum, result_list.copy())
        self.helper(root.right, currSum, targetSum, result_list.copy())
        
        # Check if the current node is root and the sum is targetsum
        if root.left is None and root.right is None and currSum == targetSum:
            self.result.append(result_list)

# Void based recursion
# Time: O(N * h)
# Space: O(h^2)

