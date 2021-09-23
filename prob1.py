# Time Complexity : O(N) as in worst case we visit all nodes
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : understanding the time complexity
# Your code here along with comments explaining your approach

# 



class TreeNode:

    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
    

class Solution:

    result = [[]] 
    target = 0

    def pathSum(self, root, targetSum):

        global result
        global target

        result = []
        target = targetSum
        
        if root is None:
            return result
        self.helper(root, 0, [])
        return result

    def helper(self, root, currSum, path):

        global result
        global target

        if root is None:
            return 

        currSum += root.val
        path.append(root.val)

        if root.left is None and root.right is None:
            if currSum == target:
                result.append(path.copy())
        
        self.helper(root.left, currSum, path)
        self.helper(root.right, currSum, path)
        path.pop()
        

