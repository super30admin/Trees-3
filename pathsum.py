# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    #     Defining the output array
    final_array = []

    def getPath(self, root, curr_arr, targetSum):
        # check if the root is not present then return as that will be the base case
        if not root:
            return
        #         and append current root value to the array maintaining for current node
        curr_arr.append(root.val)
        #     Call the same function recursively on left side of the current root
        self.getPath(root.left, curr_arr, targetSum)
        #
        # check if the current node is the leaf node then
        # check the sum of the current array and if it is equal to the sum then add it to the final output array
        if not root.left and not root.right:

            if sum(curr_arr) == targetSum:
                self.final_array.append(list(curr_arr))

        #         Or else call the same function on the right side of the tree
        self.getPath(root.right, curr_arr, targetSum)
        # and eventually remove the last element in the current array to proceed with the another side of the tree
        curr_arr.pop()

    def pathSum(self, root, targetSum):
        #         Initializing  the final output array
        self.final_array = []
        # if root is null return Empty array
        if not root:
            return []
        #         Call recursive function on root
        self.getPath(root, [], targetSum)
        #         return the final output array
        return self.final_array

        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
