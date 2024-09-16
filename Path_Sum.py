// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach: checking current sum and appending the array which is equal to the target



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:

        if root == None:
            return None
        
        result = []
        output = []
        
        self.check(root, sum, 0, result, output)
        return output
        
    def check(self, root: TreeNode, target, curSum, result, output):
        
        if root == None:
            return
        
        
        if(root.left == None and root.right == None):
            if (curSum + root.val == target):
                temp = []
                for i in result:
                    temp.append(i)
                temp.append(root.val)
                output.append(temp)
                
              
        result.append(root.val)
        
        self.check(root.left, target, curSum + root.val, result, output)
        self.check(root.right, target, curSum + root.val, result, output)
        
        result.pop()
        
