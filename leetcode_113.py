#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Mar 15 00:00:00 2026

@author: rishigoswamy

    LeetCode 113: Path Sum II
    Link: https://leetcode.com/problems/path-sum-ii/

    Problem:
    Given the root of a binary tree and an integer targetSum, return all root-to-leaf
    paths where the sum of the node values equals targetSum. Each path should be
    returned as a list of node values.

    Approach:
    DFS with backtracking. Maintain a running array and currSum as we recurse.
    At each leaf, check if currSum == targetSum and append a copy of array to results.
    Backtrack by popping the last element from array on return.

    1️⃣ Append current node's value to array; add to currSum.
    2️⃣ At a leaf, if currSum == targetSum → append array.copy() to self.res.
    3️⃣ Recurse left and right subtrees.
    4️⃣ Backtrack: pop last element from array before returning.

    // Time Complexity : O(n)
        Every node is visited once.
    // Space Complexity : O(h)
        Recursive call stack depth equals the height of the tree.
        The array at any point holds at most h elements.

"""

from typing import List, Optional

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def traversal(root, array, currSum):
            if not root:
                return

            array.append(root.val)
            currSum += root.val
            if not root.left and not root.right:
                if currSum == targetSum:
                    self.res.append(array.copy())
            traversal(root.left, array, currSum)
            traversal(root.right, array, currSum)

            array.pop()

        self.res = []
        traversal(root, [], 0)
        return self.res

    '''
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def traversal(root, array):
            if not root:
                return

            array.append(root.val)
            currSum = sum(array)
            if not root.left and not root.right:
                if currSum == targetSum:
                    self.res.append(array.copy())
            traversal(root.left, array)
            traversal(root.right, array)

            array.pop()

        self.res = []
        traversal(root, [])
        return self.res
    '''

    '''
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def traversal(root, array, currSum):
            if not root:
                return

            array.append(root.val)
            tempLeft = []
            for item in array:
                tempLeft.append(item)
            tempRight = []
            for item in array:
                tempRight.append(item)
            currSum += root.val
            if not root.left and not root.right:
                if currSum == targetSum:
                    self.res.append(array)
            traversal(root.left, tempLeft, currSum)
            traversal(root.right, tempRight, currSum)

        self.res = []
        traversal(root, [], 0)
        return self.res
    '''

    '''
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if not root:
            return []

        queue = []
        queue.append([root, root.val, [root.val]])
        res = []

        while queue:
            node, currSum, path = queue.pop(0)
            if node.left:
                temp = []
                for item in path:
                    temp.append(item)
                temp.append(node.left.val)
                queue.append([node.left, currSum + node.left.val, temp])

            if node.right:
                temp = []
                for item in path:
                    temp.append(item)
                temp.append(node.right.val)
                queue.append([node.right, currSum + node.right.val, temp])

            if not node.left and not node.right:
                if currSum == targetSum:
                    res.append(path)

        return res
    '''
