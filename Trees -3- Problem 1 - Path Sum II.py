"""
 FAANMG Problem #48 {Medium}


113. Path Sum II

Time Complexity : O(N)



Space Complexity : O(N*H)

Recursion

Did this code successfully run on Leetcode : Yes
  

We will be traversing through each nodes 
When we reach the Leaf, we will cehc if the curr Sum is equal to the target



@name: Rahul Govindkumar_RN27JUL2022
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    

    def helper(self, root,currSum, path, targetSum):
        
        #base
        if root is None:
            return
        
        #logic
        
        currSum += root.val
        
        #Create temp[] copies at each recursion to store the current path
        temp = path.copy()
        temp.append(root.val)
        
        if(root.left is None and root.right is None):
        
            #Check if equal to the target val
            if(currSum == targetSum):
                self.result.append(temp)
        
        
        self.helper( root.left,currSum, temp, targetSum)
        self.helper( root.right ,currSum, temp, targetSum)
        
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        self.result=[]
        
        path =[]
        
        self.helper(root,0, path, targetSum)
        
        return self.result
    

"""
 FAANMG Problem #48 {Medium}


113. Path Sum II

Time Complexity : O(N)



Space Complexity : O(N*H)

Backtracking

Did this code successfully run on Leetcode : Yes
  

We will be traversing through each nodes 
When we reach the Leaf, we will cehc if the curr Sum is equal to the target

If yes then add the new path copy at that instance
then at the end pop the element as parth of backtracking


@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
   
        
    def helper(self, root,currSum, targetSum):
        
        #base
        if root is None:
            return
        
        #logic
        
        currSum += root.val
        
        #action :add the value of current root to the sum seen so far, add the node to the path, as this is the value that we have traversed
        self.path.append(root.val)
        
        if(root.left is None and root.right is None):
        
            if(currSum == targetSum):
                temp = self.path.copy()
                self.result.append(temp)
        
        #recurse :recursively call the left and right subtree
        self.helper( root.left,currSum,  targetSum)
        self.helper( root.right ,currSum, targetSum)
        
        
        #backtrack
        #remove the node visited and saving space from O(n^2) to O(n)
        self.path.pop()
        
        
        
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        self.result=[]
        
        self.path =[]
        
        self.helper(root,0, targetSum)
        
        return self.result
    
                