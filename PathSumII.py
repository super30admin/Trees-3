# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# Approach 1: DFS recurssive

# In this approach we are pushing 3 parts of information. Current node we are traversing, sum until that point and the elements that sum upto that cuurent sum. So now whenever we encounter a current sum whose value is equal to the target we add that list of the values have maintained in the stack uptill that point to the resultant list (given that the node is the lead node).

# Time complexity: O(n); n = no of nodes
# Space complexity: O(n^2)
 
# class Solution:
#     def pathSum(self, root: TreeNode, summ: int) -> List[List[int]]: 
#         self.result = []
#         self.target = summ
        
#         if root == None:
#             return self.result
        
#         path = []
#         self.dfs(root, 0, path)
#         return self.result
        
#     def dfs(self, root, currSum: int, path: List[int]):
#         if root == None:
#             return
             
#         newSum = currSum + root.val
#         path.append(root.val)
        
#         # There is a possibility that upto non-leaf node currSum will add upto target. So it should also be a leaf node
#         if newSum == self.target and root.left == None and root.right == None:
#             self.result.append(path)
        
#         self.dfs(root.left, newSum, path.copy())
#         self.dfs(root.right,  newSum, path.copy())
        
# As we can see above space complexity is bottle neck here. We need to improve on that
# Approach2: DFS with backtrack

# A little change we did here is that instead passing a new list copy every time, we are using same 'path' list. So whenever we reach a leaf node which do not sums upto the target sum, we remove that node from path.

class Solution:
    def pathSum(self, root: TreeNode, summ: int) -> List[List[int]]: 
        self.result = []
        self.target = summ
        
        if root == None:
            return self.result
        
        path = []
        self.dfs(root, 0, path)
        return self.result
        
    def dfs(self, root, currSum: int, path: List[int]):
        if root == None:
            return
             
        newSum = currSum + root.val
        path.append(root.val)
        
        if newSum == self.target and root.left == None and root.right == None:
            self.result.append(path.copy()) # <- change: path to path.copy()
        
        self.dfs(root.left, newSum, path) # <- change: pathc.copy to path
        self.dfs(root.right,  newSum, path)  # <- change: pathc.copy to path
        # backtrack
        path.pop()  # <- change: removing last element if it does not add upto the target sum
        

            