# // Time Complexity :O(n) traversal and copying path
# // Space Complexity :O(h) stack space and copying path
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> list[list[int]]:
        result = []
        path = []

        def helper(root,currSum,targetSum,path):

            # basecase
            if root == None:
                return 

            # logic init       
            path.append(root.val)                   # add element ot path
            currSum  += root.val                    # add value to sum

            if not root.left and not root.right:    # not leaf?
                if targetSum == currSum:            
                    result.append(path[:])          # deep copy

            # recursion
            helper(root.left, currSum,targetSum, path)
            helper(root.right, currSum,targetSum, path)

            # backtrack
            path.pop()                              # remove elemet

        helper(root,0,targetSum,path)
        return result