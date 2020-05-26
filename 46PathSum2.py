"""
// Time Complexity :T = O(n) for traversing through entire BT.
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NA

//Explanation:
Maintain the seperate list at each level.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    currentSum = 0
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        if not root:
            return []

        self.final = []
        self.helper(root, [root.val], root.val, targetSum)
        return self.final

    def helper(self, root, temp, currentSum, targetSum):
        if root.left is None and root.right is None and currentSum == targetSum:
            self.final.append(temp)

        if root.left is not None:
            self.helper(root.left, temp + [root.left.val], currentSum + root.left.val, targetSum)
        if root.right is not None:
            self.helper(root.right, temp + [root.right.val], currentSum + root.right.val, targetSum)

"""
# solution to the below problem

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result_stack = []
    traverse_stack = []
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        # edge
        if root is None: return None

        currentSum = 0
        nodes = []

        self.traverse_stack.append(root)
        while root is not None and len(self.traverse_stack) != 0:
            temp = []
            while root is not None:
                currentSum = currentSum + root.val
                nodes.append(root.val)
                temp=nodes.copy()


                self.result_stack.append([currentSum,temp])
                root = root.left
            print(self.result_stack)
            root = self.traverse_stack.pop(-1)
            root = root.right
"""
"""
THIS CODE IS THE EXAMPLE OF PROBLEM CAUSED WHEN PASS BY REFERENCE IS USED
IN THE STACK.
At leaf node 7, visited nodes are ->[5,4,11,7]
At leaf node 2, visited nodes are ->[5,4,11,7,2] THE 7 IS EXTRA
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result_stack = []
    traverse_stack = []
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        # edge
        if root is None: return None

        currentSum = 0
        self.traverse_stack.append(root)
        while root is not None and len(self.traverse_stack) != 0:
            nodes = []
            while root is not None:
                currentSum = currentSum + root.val
                nodes.append(root.val)
                self.result_stack.append([currentSum,nodes])
                root = root.left
            print(self.result_stack)
            root = self.traverse_stack.pop(-1)
            root = root.right
"""
