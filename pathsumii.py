#113. Path Sum II
#Time Complexity : O(V+E)
# // Space Complexity :  O(depth of prevPath + depth of Stack) 
# // Did this code successfully run on Leetcode : Yes
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        output = []
        prevPath =[]
        self.helper(root,sum,0,prevPath,output)
        return output
    
    def helper(self,root,target,curSum,prevPath,output):
        if root == None:
            return 
        
        if root.left ==None and root.right ==None:
            if curSum+root.val==target:
                temp = prevPath[:]
                temp.append(root.val)
                output.append(temp)
            return
        
        prevPath.append(root.val)
        #print(prevPath)
        self.helper(root.left,target,curSum+root.val,prevPath,output)
        self.helper(root.right,target,curSum+root.val,prevPath,output)
        
        prevPath.pop()
                
            