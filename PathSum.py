class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right
    
class Solution():
    def pathSum(self, root, targetSum):
        result=[]

        def dfs(node,path,current_sum):
            if not node:
                return
        
            path.append(node.val)
            current_sum += node.val

            if not node.left and not node.right and current_sum == targetSum:
                result.append(list(path))
            else:
                dfs(node.left,path,current_sum)
                dfs(node.right,path,current_sum)

            path.pop()
    
        dfs(root,[],0)
        return result

from collections import deque

def buildTree(values):
    if not values:
        return None
    root=TreeNode(values[0])
    q=deque([root])
    i=1
    while q and i < len(values):
        node=q.popleft()
        if values[i] is not None:
            node.left=TreeNode(values[i])
            q.append(node.left)
        i +=1
        if i<len(values) and values[i] is not None:
            node.right=TreeNode(values[i])
            q.append(node.right)
        i +=1
    return root

root=buildTree([5,4,8,11,None,13,4,7,2,None,None,5,1])
sol=Solution()
print(sol.pathSum(root,22))