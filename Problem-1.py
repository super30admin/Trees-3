"""
# Trees-3

## Problem1 (https://leetcode.com/problems/path-sum-ii/)
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

    5
    / \
    4   8
    /   / \
    11  13  4

 /  \    / \

7    2  5   1
Return:

[

   [5,4,11,2],

   [5,8,4,5]

]

time- O(N)
SPACE with out recursion stack- O(N)
SPACE with recursion stack- O(N + max_depth)

Can you please check my backtracking solution
"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int):
        self.output = []         #output list
        self.helper(root, [], 0, sum)
        return self.output

    def helper(self, root, current_path, current_sum, target):
        if root == None:
            return None
        if root.left == None and root.right == None and current_sum + root.val == target:  #base case
            #      if current_sum + root.val ==target:
            current_path.append(root.val)
            self.output.append(current_path)
            #  current_path.append(root.val)
        #  current_sum =current_sum + root.val
        self.helper(root.left, current_path + [root.val], current_sum + root.val, target)
        self.helper(root.right, current_path + [root.val], current_sum + root.val, target)





#BACKTRACKING  Solution:
def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
    self.output=[]
    self.helper(root, [], 0,sum)
    return self.output

def helper(self,root, current_path, current_sum, target):
    if root==None:
        return None
    if root.left==None and root.right==None and current_sum + root.val ==target:
        temp = current_path
        temp.append(root.val)
        self.output.append(temp)    
    self.helper(root.left, current_path+[root.val], current_sum + root.val, target)
    self.helper(root.right, current_path+[root.val], current_sum + root.val, target)
    current_path[0:len(current_path)-1]
       """

