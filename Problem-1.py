# 113. Path Sum II
'''
Leetcode all test cases passed: Yes
Solution:
     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        n is the no of nodes in the tree
        h is the height of tree 
        Space Complexity: O(h)
        Time Complexity: O(n)
'''
class Solution:
    def __init__(self):
        self.result = []
        self.path = []
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.dfs(root,0,targetSum)
        return self.result
    def dfs(self,root,currSum,targetSum):
        #Base
        if root == None:
            return
        #logic
        self.path.append(root.val)
        currSum = currSum + root.val 
        if root.left == None and root.right == None:
            if targetSum == currSum:
                self.result.append(self.path[:])
        #action
        self.dfs(root.left,currSum,targetSum)
        self.dfs(root.right,currSum,targetSum)
        self.path.pop()
