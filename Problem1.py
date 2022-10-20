# Time Complexity : O(n) n is the number of elements in the tree
# Space Complexity : O(h)  here h is the height of the tree that means the recursive stack will have values upto the height of tree max
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach : - Here we recursively traverse the tree and add values of every branch in sum 
# and once we hit when root is null we exit the recursion


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    finalArray = []
    target = 0
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.target = targetSum
        self.finalArray = []
        self.dfs(root, 0, [])
        return self.finalArray
    
    def dfs(self, root, sum, path):
        if root == None:
            return
        path.append(root.val)
        currSum = sum + root.val
        if root.left== None and root.right==None:
            if self.target == currSum:
                self.finalArray.append(path.copy())
        self.dfs(root.left, currSum, path)
        self.dfs(root.right, currSum, path)
        #BackTracking done 
        path.pop(len(path)-1)


