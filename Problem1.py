# Time comlexity : O(n) --> traversing the whole tree
# Space complexity : O(h) --> to maintain the path
# Leetcode : Solved and submitted

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        # creating empty lists to fill the path and result, then call the helper function
        self.path = []
        self.res = []
        self.helper(root, 0, self.path, targetSum)
        return self.res    
    
    def helper(self, root, sum_till_now, path, targetSum):
       # check if the root is null, then return 0
        if root is None:
            return 0
        
        # action
        # add the value of current root to the sum seen so far, add the node to the path, as this is the value that we have traversed
        sum_till_now += root.val
        self.path.append(root.val)
        
        # if we have reached a leaf node, then check if the sum is equal to targetSum, if yes then add the path to the res
        # we use a temp variable, because path is used as a reference to the path list
        if root.left is None and root.right is None:
            if sum_till_now == targetSum:
                temp = self.path[:]
                self.res.append(temp)
        
        # recursion
        # recursively call the left and right subtree
        self.helper(root.left, sum_till_now, self.path, targetSum)
        self.helper(root.right, sum_till_now, self.path, targetSum)
        
        # backtrack
        # remove the node which is seen so far, so that we do not have to create a new list at every node, saving space from O(n^2) to O(n)
        self.path.pop()
        
