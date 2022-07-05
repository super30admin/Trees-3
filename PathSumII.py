#113. Path Sum II
"""
Time Complexity : O(n)
Space Complexity : O(n)
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result = list()
    i = 0
    #temp_list = []
    
    def helper(self, root, targetSum, currSum, temp_list):
        #base
        if root == None:
            return
        
        #logic
        temp_list.append(root.val)
        self.helper(root.left, targetSum, (currSum + root.val), temp_list )
        
        #print(root.val, currSum, temp_list)
        
        if root.left == None and root.right == None:
            currSum  = currSum + root.val
            #print(root.val, currSum, temp_list)
            if currSum == targetSum:
                #print("here", temp_list)
                self.result.append(list(temp_list))
            
        temp_list.pop()
        
        temp_list.append(root.val)
        self.helper(root.right, targetSum, (currSum + root.val), temp_list )
        temp_list.pop()
        
    
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        currSum = 0
        self.result = []
        self.helper(root, targetSum, 0, [])
        print(self.result)
        return self.result
