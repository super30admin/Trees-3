class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right

class Solution:
    def isSymmetric(self,root):
        def isMirror(t1,t2):
            if not t1 and not t2:
                return True
            if not t1 or not t2:
                return False
            return(t1.val==t2.val and 
                   isMirror(t1.left,t2.right)and
                   isMirror(t1.right,t2.left))
        
        return isMirror(root.left,root.right)
    
from collections import deque

def buildTree(values):
    if not values:
        return None
    root=TreeNode(values[0])
    queue=deque([root])
    i=1
    while queue and i<len(values):
        node=queue.popleft()
        if i<len(values)and values[i] is not None:
            node.left=TreeNode(values[i])
            queue.append(node.left)
        i += 1
        if i <len(values)and values[i] is not None:
            node.right=TreeNode(values[i])
            queue.append(node.right)
        i+=1
    return root

sol=Solution()    

values1=[1,2,2,3,4,4,3]
root1=buildTree(values1)
print(sol.isSymmetric(root1))

values2=[1,2,2,None,3,None,3]
root2=buildTree(values2)
print(sol.isSymmetric(root2))

values3=[1]
root3=buildTree(values3)
print(sol.isSymmetric(root3))

values4=[1,2,2,3,None,None,3]
root4=buildTree(values4)
print(sol.isSymmetric(root4))