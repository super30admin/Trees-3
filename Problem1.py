"""
// Time Complexity : 0(n^2), traversing each node and copying the path at each valid leaf
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

--> most optimized solution uses backtracking, we explore a path and backtrack from there to explore other paths, it space efficient this way

// Your code here along with comments explaining your approach

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def helper(self, root, cur_sum, path):
        if root == None:
            return 
    
        cur_sum += root.val #sum at each node, along each path
        path.append(root.val) #keep track of path till now
        
        if not root.left and not root.right:
            if cur_sum == self.tar:
                self.res.append(path.copy()) #create a new copy of path to store in res, original path list will be empty at the end
                
        #self.helper(root.left, cur_sum,path.copy())
        #self.helper(root.right, cur_sum,path.copy())
        
        
        self.helper(root.left, cur_sum, path)
        self.helper(root.right, cur_sum, path)
        
        path.pop() #backtracking, we romeve every node when its been explored
         
        
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if not root:
            return []
        
        self.res =[] #global list to store result
        self.tar = sum
        self.helper(root, 0,[])
        return self.res