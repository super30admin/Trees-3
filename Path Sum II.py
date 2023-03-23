# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Time Complexity: O(n)
# Space Complexity: O(n) where n could be the height of the tree in worst case
class Solution:

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        path = []
        def pathsum(root, currsum):
            # Base Case
            if not root: return

            # Logic
            currsum = currsum + root.val
            # print(currsum)
            path.append(root.val)
            # print("Path", path)
            if not root.left and not root.right:

                if currsum == targetSum:
                    # print(path)
                    result.append(copy.deepcopy(path))

            # Recursion
            pathsum(root.left, currsum)
            pathsum(root.right, currsum)

            # Backtrack
            path.pop()

        pathsum(root, 0)
        return result



