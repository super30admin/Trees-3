# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    '''Time Complexity: O(n)
    Space Complexity: O(h)'''
  
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        #Using bfs
        if not root:
            return True
        
        #Create queue... no need to check to check for the root
        queue=deque()
        #add left and right child of the root
        queue.append(root.left)
        queue.append(root.right)
        #while queue is not empty
        while len(queue)!=0:
            #pop fifo
            left=queue.popleft()
            right=queue.popleft()
            #if both none continue
            if left is None and right is None:
                continue
            #else return false
            if left is None or right is None or left.val != right.val:
                return False
            #add
            queue.append(left.left)
            queue.append(right.right)
            queue.append(left.right)
            queue.append(right.left)
        return True
            
        
        
