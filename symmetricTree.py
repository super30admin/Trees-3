class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque


class Solution(object):
    def isSymmetric(self, root):
        
        if (root == None):
            return True

        stack = deque([[root.left, root.right, 0]])

        while (len(stack) > 0):

            top = stack[-1]
            topLeft = top[0]
            topRight = top[1]
            topCount = top[2]

            if (topLeft == None and topRight == None):                     
                stack.pop()
                continue

            if (topLeft == None or topRight == None or topLeft.val != topRight.val):    
                return False

            if topCount == 0:                                   
                stack[-1][2] += 1
                stack.append([topLeft.left, topRight.right, 0]) 
                continue

            if topCount == 1:                                  
                stack[-1][2] += 1
                stack.append([topLeft.right, topRight.left, 0]) 
                continue

            if topCount == 2:
                stack.pop()
                continue

        return True


class SymmetricTree_Recursive(object):

    def __isSymmetric(self, leftNode, rightNode):

        if (leftNode == None and rightNode == None):
            return True

        if (leftNode == None or rightNode == None or leftNode.val != rightNode.val):
            return False

        return (self.__isSymmetric(leftNode.left, rightNode.right) and
                self.__isSymmetric(leftNode.right, rightNode.left))

    def isSymmetric(self, root):
    
        if (root == None):
            return True

        return self.__isSymmetric(root.left, root.right)


class SymmetricTree_Queue(object):
    def isSymmetric(self, root):
        
        if (root == None):
            return True

        
        queue = deque([[root.left, root.right]])

        while (len(queue) > 0):

            front = queue.popleft()
            frontLeft = front[0]
            frontRight = front[1]

            if (frontLeft == None and frontRight == None):       
                continue

            if (frontLeft == None or frontRight == None or frontLeft.val != frontRight.val):  
                return False

            queue.append([frontLeft.left, frontRight.right])
            queue.append([frontLeft.right, frontRight.left])

        return True