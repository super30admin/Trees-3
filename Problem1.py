#Time complexity: O(N) - cost of copying array at the last index comes under this bound
#Space complexity: O(H) - cost of copying array at last index also falls under this bound (along with stack space)

#Accepted on Leetcode

#Approach
#Maintain a sum while traversing the binary tree, at each element add current value to the sum
#Also maintain a single array with the current path, modify this path when backtracking by popping the array or when moving forward by appending to the array
#Whenever we are at a leaf node and sum == target, create a new list with current 'path' and add to the solution



# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right



class Solution:
    

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        curPath = []
        solnPaths = []
        self.helper(root, curPath, 0, targetSum, solnPaths)
        return solnPaths

    def helper(self, root, path, sumVal, target, soln):
        if root == None:
            return

        sumVal += root.val
        path.append(root.val)

        if root.left == None and root.right == None:
            if target == sumVal:
                print(path)
                soln.append([x for x in path])
        
        self.helper(root.left, path, sumVal, target, soln)
        self.helper(root.right, path, sumVal, target, soln)

        path.pop()
        

        
        
