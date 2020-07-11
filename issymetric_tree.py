'''
Did it run on leet code: Yes

Time Compelxity: 0(N2)
- Traversing whole array
- checking queue in my bfs

Space complexity: 0(N)
- for the queue

Algorithm:
- Traverse every level and check if the reverse is same if its not its is not symmetric
else continue for next level
'''


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        
        if not root.left and not root.right:
            return True
        
        queue = [root]
        
        while True:
            level = [node.val if node else -1 for node in queue]
            if level == level[::-1]:
                size = len(queue)
                for i in range(size):
                    if queue[i]:
                        queue.append(queue[i].left)
                        queue.append(queue[i].right)
                queue = queue[size:]
                if len(queue)==0:
                    break
            else:
                return False
        
        return True