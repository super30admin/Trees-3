'''
Solution:
1.  The main idea is to consider left's left, right's right as a pair and left's right and right's left as a pair and
    evaluate these pairs.
2. These can be done recursively or iteratively using a stack (DFS) or a queue (BFS)
3.  Return false if any of the pairs is not equal otherwise return true.

-- Passed all test cases on Leetcode successfully for all 3 Recursive, Iterative (Stack / Queue) approaches.

Time Complexity:    Recursive -- O(height), Iterative (Stack-DFS) -- O(height) and Iterative (Queue-BFS)-- O(nodes)
Space Complexity:   Recursive -- O(height), Iterative (Stack-DFS) -- O(height) and Iterative (Queue-BFS)-- O(nodes)

'''

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque


class SymmetricTree_Stack(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        # edge case check
        if (root == None):
            return True

        #   initialize stack
        #   each element i =n stack contains two nodes whose values are to be compared ans a count (0, 1, 2 indicating
        #   how many children have been visited)
        stack = deque([[root.left, root.right, 0]])

        while (len(stack) > 0):

            top = stack[-1]
            topLeft = top[0]
            topRight = top[1]
            topCount = top[2]

            if (topLeft == None and topRight == None):                      #   both nulls then continue
                stack.pop()
                continue

            if (topLeft == None or topRight == None or topLeft.val != topRight.val):    #   false cases
                return False

            if topCount == 0:                                   #   count 0 => no child visited
                stack[-1][2] += 1
                stack.append([topLeft.left, topRight.right, 0]) #   push left's left and right's right
                continue

            if topCount == 1:                                   #   count 1 => one child visited
                stack[-1][2] += 1
                stack.append([topLeft.right, topRight.left, 0]) #   push left's right and right's left
                continue

            if topCount == 2:                                   #   count 2 => both children visited and just pop
                stack.pop()
                continue

        return True


class SymmetricTree_Recursive(object):

    def __isSymmetric(self, leftNode, rightNode):

        #   base cases
        if (leftNode == None and rightNode == None):
            return True

        if (leftNode == None or rightNode == None or leftNode.val != rightNode.val):
            return False

        #   recursive calls evaluating 2 pairs of nodes
        return (self.__isSymmetric(leftNode.left, rightNode.right) and
                self.__isSymmetric(leftNode.right, rightNode.left))

    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #   edge case check
        if (root == None):
            return True

        #   call helper function
        return self.__isSymmetric(root.left, root.right)


class SymmetricTree_Queue(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """

        #   edge case check
        if (root == None):
            return True

        #   initialize queue and each element in queue contains one pair whose nodes' values are to be compared
        queue = deque([[root.left, root.right]])

        while (len(queue) > 0):

            front = queue.popleft()
            frontLeft = front[0]
            frontRight = front[1]

            if (frontLeft == None and frontRight == None):          #   if both nodes are null, then continue
                continue

            if (frontLeft == None or frontRight == None or frontLeft.val != frontRight.val):    #   false cases
                return False

            queue.append([frontLeft.left, frontRight.right])        #   pair of left's left and right's right
            queue.append([frontLeft.right, frontRight.left])        #   pair of left's right and right's left

        return True