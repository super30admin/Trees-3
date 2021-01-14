'''
Solution:
1.  The main idea is to add each node's value based on its parents' values and also append the element to a temporary list
2.  These can be done recursively or iteratively using a stack (DFS) or a queue (BFS)
3.  Append if total Sum at a leaf is equal to target sum.

-- Passed all test cases on Leetcode successfully for all 3 Recursive, Iterative (Stack / Queue) approaches.

Time Complexity:    Recursive -- O(nodes), Iterative (Stack-DFS) -- O(nodes) and Iterative (Queue-BFS)-- O(nodes)
Space Complexity:   Recursive -- O(height), Iterative (Stack-DFS) -- O(height) and Iterative (Queue-BFS)-- O(height * nodes)
For BFS, I was creating a new arraylist whenever an element is added, and so maximum elements in the queue can be number of nodes
and each entry in the queue can have a arraylist of size height at any point of time

'''

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque


class PathSum_Queue(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        #   edge case
        if (root == None):
            return []

        finalList = []
        queue = deque([[root, root.val, [root.val]]])   #   initialize queue with an element containing node, sum and list

        while (len(queue) > 0):
            front = queue.popleft()
            frontNode = front[0]
            currSum = front[1]
            currArray = front[2]

            if (frontNode.left == None and frontNode.right == None and currSum == sum): #   if leaf, and sum == target sum
                finalList.append(list(currArray))

            if (frontNode.left != None):                #   if left exists, add node info to the queue
                newArray = list(currArray)
                newArray.append(frontNode.left.val)
                queue.append([frontNode.left, currSum + frontNode.left.val, newArray])

            if (frontNode.right != None):               #   if right exists, add node info to the queue
                newArray = list(currArray)
                newArray.append(frontNode.right.val)
                queue.append([frontNode.right, currSum + frontNode.right.val, newArray])

        return finalList


class PathSum_Recursive(object):

    def __init__(self):
        #   attributes of this class to maintain global
        self.array = []
        self.finalList = []

    def __pathSum(self, root, sum, value):
        #   base case
        if (root == None):
            return

        value += root.val
        self.array.append(root.val)

        if (root.left == None and root.right == None and value == sum): #   if leaf, and sum = target sum => append the list
            self.finalList.append(list(self.array))

        self.__pathSum(root.left, sum, value)           #   recursive on left
        self.__pathSum(root.right, sum, value)          #   recursive on right

        self.array.pop()

    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        if (root == None):
            return []

        #   calling helper function
        self.__pathSum(root, sum, 0)
        return self.finalList


class PathSum_Stack(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        #   edge case
        if (root == None):
            return []

        finalList = []
        dynamicArray = [root.val]
        stack = deque([[root, root.val, 0]])    #   initialize stack with element containing node, sum and count (0,1,2)

        while (len(stack) > 0):
            top = stack[-1]
            topNode = top[0]
            topSum = top[1]
            topCount = top[2]

            if topCount == 0:                   #   count 0 => no child visited
                stack[-1][2] += 1
                if topNode.left != None:
                    stack.append([topNode.left, topSum + topNode.left.val, 0])  #   update with correct sum
                    dynamicArray.append(topNode.left.val)
                continue

            elif topCount == 1:                 #   count 1 => one child visited
                stack[-1][2] += 1
                if topNode.right != None:
                    stack.append([topNode.right, topSum + topNode.right.val, 0])    #   update with correct sum
                    dynamicArray.append(topNode.right.val)
                continue

            elif topCount == 2:                 #   count 2 => both visited
                stack.pop()
                if (topNode.left == None and topNode.right == None and topSum == sum):
                    finalList.append(list(dynamicArray))    #   if leaf and if sum == target sum, add a list of current list
                dynamicArray.pop()              #   just pop last element from the dynamic array we are using

        return finalList