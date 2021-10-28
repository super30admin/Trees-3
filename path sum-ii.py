# TC-O(n**2)
# SC-O(n)n=height

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        path = []
        self.helper(root, targetSum, 0, result, path)
        return result

    def helper(self, root, target, currsum, result, path):
        temp = []
        if root == None:
            return
        # path.append(root.val)

        # currsum+=root.val
        # # print(currsum)
        if (root.left == None) and (root.right == None):
            temp = path.copy()
            temp.append(root.val)
            if currsum + root.val == target:
                result.append(temp)
                print(result)
            return
        path.append(root.val)
        currsum += root.val
        self.helper(root.left, target, currsum, result, path)
        self.helper(root.right, target, currsum, result, path)
        path.pop()
