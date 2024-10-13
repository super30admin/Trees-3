# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Understanding the traversal of tree

# Your code here along with comments explaining your approach 
#Backtracking Approach: Time Complexity --> O(n)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        #Assign class variable result
        self.result=[]
        self.helper(root, targetSum, [], 0)
        return self.result
    #Function to get the currSum at each node
    def helper(self, root, targetSum, path, currSum):
        #Action
        #If root is null then return control to previously called function line
        #Base Case
        if(root == None):
            return
        #Update Current Sum at each
        currSum+=root.val
        #Add that node to path list
        path.append(root.val)
        #To check if the node is leaf
        if(root.left==None and root.right==None):
            #If the path leads to target add that list of nodes to result list
            if(currSum==targetSum): 
                self.result.append(list(path))
        #Recursion
        self.helper(root.left, targetSum, path, currSum)
        self.helper(root.right, targetSum, path, currSum)
        #Backtracking
        path.pop()

#Brute Force Approach : Deep Copy, Time Complexity --> O(n*h)
# class Solution:
#     def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
#         self.result=[]
#         self.helper(root, targetSum, [], 0)
#         return self.result
#     def helper(self, root, targetSum, path, currSum):
#         #Action
#         if(root == None):
#             return
#         list1 = path[:]
#         currSum+=root.val
#         list1.append(root.val)
#         if(root.left==None and root.right==None):
#             if(currSum==targetSum):
#                 self.result.append(list1)
#         #Recursion
#         self.helper(root.left, targetSum, list1, currSum)
#         self.helper(root.right, targetSum, list1, currSum)