# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    """
    TC: O(n)
    SC: O( total number of possible sums * max depth + max depth of the tree)
    """

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        if root == None:
            return None

        output = []

        def getSum(root, target, path, currSum):

            # if the root is null then return back
            if root == None:
                return

            # increment the currSum by root value
            # and append that root value to the path
            currSum += root.val
            path.append(root.val)

            # if the leaf node is reached
            # and target is equal to the currSum
            if root.left == None and root.right == None:
                if target == currSum:
                    output.append(copy.deepcopy(path))
                path.pop()
                return

            getSum(root.left, target, path, currSum)
            getSum(root.right, target, path, currSum)

            path.pop()

        getSum(root, targetSum, [], 0)
        return output
