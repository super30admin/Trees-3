# Time Complexity : O(h) -> O(n) in case of skewed tree
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# BACKTRACK
# use:
# 1. Action
# 2. Recursion
# 3. Backtrack
# We stored  list at each stage of recursion
# this list was call by reference hence as we used backtracking
# Before recursion we add the new root and after recursion we remove it
# when we find the leaf node and target == sum(l) we eill add that to res list


class Solution:
    res = []
    
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.res = []
        self.helper(root, targetSum, [])
        
        return self.res
        
    def helper(self, root,targetSum, l):
        
        #base
        if not root: return
        
        #logic
        #Action
        l.append(root.val)
        if root.left == None and root.right == None and targetSum == sum(l):
            self.res.append(l.copy())
        #recurse
        self.helper(root.left, targetSum, l)
        self.helper(root.right, targetSum, l)
        #backtrack
        l.pop()
        