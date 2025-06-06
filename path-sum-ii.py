'''
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
'''

# // Time Complexity : O(n)
# // Space Complexity : O(h)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# here, the logic is simple. the main problem comes when we try to pass the path array object up the recursion stack. since passing objects means we pass by 
# reference, everytime we update a path element, the original array list gets updated. so, when we go back up the tree, the older nodes are still in the path list  
# can think of this as if the path acts like a global varible, so it has all the nodes. the way to solve this is that we create a deep copy of the path list at
# every node. That is, we basically we just copy the array we get into a new array. this creates a new object, and we use this object. this works, but takes time 
# space. -------- i.e. brute force
# can we do better? we can pop at the end of both go_left and go_right, i.e, we BACKTRACK! we then do the deep copy only when we find the actual path. 
# normal recursion until now -> base condition -> logic -> recurse
# backtracking adds something -> base condition -> logic -> recurse -> backtrack

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
        path=[]
        self.helper(root, path, 0, targetSum)
        return self.result
        
    def helper(self, root, path, _sum, targetSum):
        # base
        if root == None: return

        # logic
        path.append(root.val)
        _sum += root.val
        if _sum == targetSum and root.left == None and root.right == None:
            self.result.append(path[:])

        # recursion
        self.helper(root.left, path, _sum, targetSum)
        self.helper(root.right, path, _sum, targetSum)

        # backtrack
        path.pop()
