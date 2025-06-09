# // Time Complexity : O(N)
# // Space Complexity :O(H+N) 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
# #         self.right = right
# This uses back tracking , lets say we are in middle of tree and node has 2 paths first it wil go to either left or right add elements once call is done it will check if summ equal to target sum 
# or not if yes add to main result .then we pop the element at the end back track how list is before making calls. And again we need to make deep copy while add to main ans
# >>
# BASE CASE
# LOGIC 
# RECURSION 
# BACK TRACK 
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.main_list=[]

        def helper(root, path,currSum,targetSum ):
            
            if not root:return
           
            currSum+=root.val
            path.append(root.val)
            if not root.right and not root.left:
                if currSum==targetSum:
                    # print(path)

                    self.main_list.append([i for i in path])

            #logic
            # print(root.val)
            helper(root.left,path,currSum,targetSum )
            helper(root.right,path,currSum,targetSum )
            path.pop()
        helper(root,[],0,targetSum)
        return self.main_list
        
        


###########################################################################################################################
# This is differnt burute force approach where we add all paths to list at the end we check them time and space complexity would be O(n,2^h) as we willhave 2^h paths 
# Important things to consider .append add in same refernce, +[] give like deep copy



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.main_list=[]

        def helper(root, temp):
            # print(self.main_list)
            #base case
            if not root:return
            if not root.left and not root.right:
                temp=temp+[root.val]
                self.main_list.append(temp)
                return 


            #logic
            # print(root.val)
            helper(root.left,temp+[root.val])
            helper(root.right,temp+[root.val])
        helper(root,[])
        ans=[]
        for i in self.main_list:
            if sum(i)==targetSum:
                ans.append(i)
        return ans
        
