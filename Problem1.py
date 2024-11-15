# Problem 1: Path Sum-II

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.all_paths = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root, [], 0, targetSum)
        return self.all_paths

    def helper(self, root, currList, currSum, targetSum):
        # base
        if not root:
            return
        # logic

        # action
        currList.append(root.val)
        currSum += root.val

        if not root.left and not root.right:
            # this is a leaf node
            # if sum equals target add deep copy of current list to result
            # note: List is called by reference so remember to pop(backtrack)
            if currSum == targetSum:
                an_answer_list = []
                an_answer_list.extend(currList)
                self.all_paths.append(an_answer_list)
            # Optimizing leaf node checks: [Optional]
            currList.pop()
            return

        # recurse
        self.helper(root.left, currList, currSum, targetSum)
        self.helper(root.right, currList, currSum, targetSum)

        # Backtrack
        currList.pop()

"""
    Complexity Analysis:
    Time: O(n) [n - #nodes in the tree]
    Space: O(n) [size of stack = Height of tree]
    Did the code run successfully on Leetcode?: Yes
    Did you face any issues while soving this problem? : No, the lecture video explained the strategy clearly.
"""
