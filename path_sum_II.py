# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        result = []
        self.helper(root, targetSum, [], 0, result)
        return result

    def helper(
        self,
        root: TreeNode,
        targetSum: int,
        path: List[int],
        curr_sum: int,
        result: List[List[int]],
    ):
        if root is None:
            return

        path = list(path)  # deep copy of the current path
        curr_sum += root.val
        path.append(root.val)

        # If at a leaf node, check if the current sum equals the target sum
        if root.left is None and root.right is None:
            if curr_sum == targetSum:
                result.append(path)

        # Recurse on the left and right children
        self.helper(root.left, targetSum, path, curr_sum, result)
        self.helper(root.right, targetSum, path, curr_sum, result)


# time complexity is O(n*h) where n is number of elements from root to leaf and h is the current elements in the path
# space complexity is O(n*h) where n is number of elements from root to leaf and h is the current elements in the path
