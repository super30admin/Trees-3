# // Time Complexity : O(max(n,c * maxdepth))
# // Space Complexity :  O(maxdepth of prevPath + maxdepth of RecursiveStack) 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : A little bit... in figuring out the time and spcae complexities

# // Your code here along with comments explaining your approach


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        prevPath = []
        output = []
        self.recur(root, sum, 0, prevPath, output)

        return output
        
        
    
    def recur(self, root:TreeNode, target, currSum, prevPath, output: List[List[int]]):
        
        # if the root is null, do nothing
        if root == None:
            return 
        
        #when at leaf node: if we have our answer, add to the output
        if root.left == None and root.right == None:
            
            if (currSum+root.val)==target:
                temp = prevPath[:] #O(maxdepth), for every leaf node
                temp.append(root.val)
                output.append(temp)    
            return
        
        # add root's value to the prev path and move ahead
        # make recursive calls
        prevPath.append(root.val)
        self.recur(root.left, target, currSum + root.val, prevPath, output)
        self.recur(root.right, target, currSum + root.val, prevPath, output)
        
        #pop out the last element from the list
        prevPath.pop()
        
        
                
            
        
        