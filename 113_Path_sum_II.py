# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Leetcode problem link : https://leetcode.com/problems/path-sum-ii/
# Time Complexity : O(max(n,c*maxdepth)) where c is the no of leaves or diameter and maxdepth is the max length from root to leaf anywhere in the tree
#  Space Complexity : O(max depth)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Intuition => The intuition behind this approach is maintain a currentpath variable which has the path travelled so far and a current sum which will have current sum till that node. Keep removing values from it
        as when we traverse back up in the tree.
        
      '''
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        # declare response variable once (passed by reference)
        output = []
        # call recursion function that keeps updating output passed as parameter
        self.recursion(root,sum,[],0,output)
        # return response
        return output
    
    def recursion(self,root,target,currPath,currSum,output):
        # edge case
        if not root:
            return
        # base case when reached a leaf node
        if not root.left and not root.right:
            temp = [currPath[i] for i in range(len(currPath))] # O(maxdepth) for leaf node to copy list
            # add current node to temp
            temp.append(root.val)
            # if sum is equal to target sum, add to output and return
            if currSum + root.val == target:
                output.append(temp)
            return
        # if its not a leaf node, need to add current node to currPath
        currPath.append(root.val)
        # call recursion on left and right nodes
        self.recursion(root.left,target,currPath,currSum+root.val,output)
        self.recursion(root.right,target,currPath,currSum+root.val,output)
        # remove the current element before going back up in the tree
        currPath.pop()
        