# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        q=deque()
        q.append(root)
        q.append(root)

        while q:
            t1=q.popleft()
            t2=q.popleft()
            
            # print(t1.val,end=" ")
            # print(t2.val)

            if not t1 and not t2:
                continue
            if not t1 or not t2:
                return False
            if t1.val!=t2.val:
                return False
            
            if t1!=None and t2!=None:
                q.append(t1.left)
                q.append(t2.right)
                q.append(t1.right)
                q.append(t2.left)
        
        return True
        