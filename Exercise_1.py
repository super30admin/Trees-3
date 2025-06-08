# S30 Problem #47 Root-to-leaf Sum II
#LeetCode #113 https://leetcode.com/problems/path-sum-ii/description/

# Author : Akaash Trivedi
# for backtracking solution
# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No


# Creating deep copy of path at every node
# Time comp: O(nh) going over all the nodes (n) + deep copy
# Space comp: O(h) height of the tree for recursive stack + deep copy O(nh)
class Solution:
    def __init__(self):
        self.result = []
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        path = []
        self.helper(root, targetSum, path, 0)
        return self.result
    
    # currSum is going as value
    # path is passed as reference
    def helper(self, root, targetSum, path, currSum):
        # base
        if root is None:
            return
        # logic
        currSum += root.val
        # keep deep copy of path at every node
        li = list(path)
        li.append(root.val)
        # print(li)
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append(li)
            return
        self.helper(root.left, targetSum, li, currSum)
        self.helper(root.right, targetSum, li, currSum)
    

# backtracking

class Solution:
    def __init__(self):
        self.result = []
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        path = []
        self.helper(root, targetSum, path, 0)
        return self.result
    
    # currSum is going as value
    # path is passed as reference
    def helper(self, root, targetSum, path, currSum):
        # base
        if root is None:
            return
        # logic
        currSum += root.val
        #action
        path.append(root.val)
        if root.left == None and root.right == None:
            if currSum == targetSum:
                #print(path)
                self.result.append(list(path))
        # recurse
        self.helper(root.left, targetSum, path, currSum)
        self.helper(root.right, targetSum, path, currSum)

        #backtrack
        path.pop()