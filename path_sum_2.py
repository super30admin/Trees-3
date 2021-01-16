# Time Complexity : O(N) since travese once and uses backtracking
# Space Complexity : O(H) it uses of recursive stack 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.result = []
        self.target = sum

        if not root:
            return []


        self.helper(root, 0, [])
        return self.result

    
    def helper(self, root, currSum, path):

        # base case
        if not root:
            return 

        # logic behind the pathsum
        currSum = currSum + root.val

        #action 
        path.append(root.val)

        if not root.left and not root.right:
            if currSum == self.target:
                #After backtracking the reference of the list become empty so we need a #copy of it since it's pass by reference 
                self.result.append(path.copy())

        # recursive call is being made to find left and right path which is equal to #sum 
        self.helper(root.left, currSum, path)
        self.helper(root.right, currSum, path)

        # backtracking method which pop as we proceed
        path.pop()
