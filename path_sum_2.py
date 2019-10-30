'''
Did it run on leetcode: Yes
Problems: How to keep track of path as python shares addres than making a copy of a list

Time Complexity: 0(N)  we are visiting all nodes
Space complexity: 0(N+h) stack and list space

Algorithm:

- Traverse around the whole tree and keep track of path visited.
- when you encounter a leaf node check the sum value left should be equal to node value

'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        self.allPaths = []
        self.pathSumUtil(root,[],sum)
        return self.allPaths
    
    def pathSumUtil(self,node,currPath,sum):
        
        if not node:
            return
        
        if not node.left and not node.right:
            if sum==node.val:
                currPath.append(node.val)
                self.allPaths.append(currPath[:])
                currPath.pop()
            return
        else:
            currPath.append(node.val)
            self.pathSumUtil(node.left,currPath,sum-node.val)
            self.pathSumUtil(node.right,currPath,sum-node.val)
            currPath.pop()
            return