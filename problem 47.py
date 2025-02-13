#  https://leetcode.com/problems/path-sum-ii/

# Time Complexity : O(n*h)
# Space Complexity : O(n*h)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root,[],0,targetSum)
        return self.result
    
    def helper(self, root: Optional[TreeNode], path: List[int], currSum: int, targetSum: int):
        if root == None:
            return 
        
        currSum += root.val
        li = list(path)
        li.append(root.val)
        if(root.left == None and root.right == None):
            if currSum == targetSum:
                self.result.append(li)
            return 
        
        self.helper(root.left,li,currSum,targetSum)

        self.helper(root.right,li,currSum,targetSum)
        
        

#solution using backtracking

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper(root,[],0,targetSum)
        return self.result
    
    def helper(self, root: Optional[TreeNode], path: List[int], currSum: int, targetSum: int):
        if root == None:
            return 
        
        currSum += root.val
        #li = list(path)
        path.append(root.val)
        if(root.left == None and root.right == None):
            if currSum == targetSum:
                print(path)
                self.result.append(list(path))
            #return 
        
        self.helper(root.left,path,currSum,targetSum)

        self.helper(root.right,path,currSum,targetSum)
        path.pop()
        
        