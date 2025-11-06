# Time Complexity : O(n)
# Space Complexity : O(n) cz recursive stack is going to take space as well
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes


# Your code here along with comments explaining your approach
'''Go through each node, check left, check right, check if currnt sum is equal to the target sum. If yes, then add into the global res, c
an do the same with path, or set path to new list while passing it to helper again, so that the path goes in as a reference and not as a value.
Or pop last element of path when left and right recursion is done, and add path to res as a new list so that it goes again by value and not by reference. 
Cz a datastructure inside a datastructure is a reference'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        self.helper(root,0,targetSum,[])
        return self.res
        
    
    def helper(self,root,currSum,target,path):
        # base
        if root is None: 
            return

        currSum += root.val
        path.append(root.val)
        if root.left == None and root.right == None and currSum == target:
            self.res.append(list(path))

        # left
        self.helper(root.left,currSum,target,path)

        # right
        self.helper(root.right,currSum,target,path)

        # backtrack
        if len(path) != 0:
            path.pop()




# Time Complexity : O(n)
# Space Complexity : O(h) h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes

# Approach:

# Comparing outer nodes (left.left vs right.right) and inner nodes (left.right vs right.left) recursively
# Ensuring current node values match and both subtree checks pass

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        return self.helper(root.left,root.right)
    
    def helper(self,lefttree, righttree):
        if not lefttree and not righttree:
            return True

        if not lefttree or not righttree:
            return False

        checkleft = self.helper(lefttree.left,righttree.right)
        checkright = self.helper(lefttree.right,righttree.left)

        return lefttree.val == righttree.val and checkleft and checkright


