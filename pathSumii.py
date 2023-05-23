class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from collections import deque

class Solution(object):
    def pathSum(self, root, sum):
        if (root == None):
            return []

        finalList = []
        queue = deque([[root, root.val, [root.val]]])  

        while (len(queue) > 0):
            front = queue.popleft()
            frontNode = front[0]
            currSum = front[1]
            currArray = front[2]

            if (frontNode.left == None and frontNode.right == None and currSum == sum):
                finalList.append(list(currArray))

            if (frontNode.left != None):              
                newArray = list(currArray)
                newArray.append(frontNode.left.val)
                queue.append([frontNode.left, currSum + frontNode.left.val, newArray])

            if (frontNode.right != None):               
                newArray = list(currArray)
                newArray.append(frontNode.right.val)
                queue.append([frontNode.right, currSum + frontNode.right.val, newArray])

        return finalList


class PathSum_Recursive(object):

    def __init__(self):
        self.array = []
        self.finalList = []

    def __pathSum(self, root, sum, value):
    
        if (root == None):
            return

        value += root.val
        self.array.append(root.val)

        if (root.left == None and root.right == None and value == sum): 
            self.finalList.append(list(self.array))

        self.__pathSum(root.left, sum, value)           
        self.__pathSum(root.right, sum, value)          

        self.array.pop()

    def pathSum(self, root, sum):
        if (root == None):
            return []

        self.__pathSum(root, sum, 0)
        return self.finalList


class PathSum_Stack(object):
    def pathSum(self, root, sum):
    
        if (root == None):
            return []

        finalList = []
        dynamicArray = [root.val]
        stack = deque([[root, root.val, 0]])

        while (len(stack) > 0):
            top = stack[-1]
            topNode = top[0]
            topSum = top[1]
            topCount = top[2]

            if topCount == 0:                  
                stack[-1][2] += 1
                if topNode.left != None:
                    stack.append([topNode.left, topSum + topNode.left.val, 0])
                    dynamicArray.append(topNode.left.val)
                continue

            elif topCount == 1:              
                stack[-1][2] += 1
                if topNode.right != None:
                    stack.append([topNode.right, topSum + topNode.right.val, 0])  
                    dynamicArray.append(topNode.right.val)
                continue

            elif topCount == 2:                 
                stack.pop()
                if (topNode.left == None and topNode.right == None and topSum == sum):
                    finalList.append(list(dynamicArray))    
                dynamicArray.pop()        

        return finalList