# Time Complexity - O(N)
# Space Complexity - O(N)
 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        q = deque()
        q.append(root)
        
        while q:
            len_q = len(q)
            tmplist = []
            for i in range(len_q):
                node = q.popleft()
                if node is None:
                    tmplist.append(None)
                else:
                    tmplist.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
            if (tmplist != tmplist[::-1]):
                return False
            
        return True
            

