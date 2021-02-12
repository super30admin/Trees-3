class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        return self.getPaths(root,targetSum,0,[],[])
        
    
    def getPaths(self,node,targetSum,currentSum,path,output):
        if node is None:
            return
        currentSum += node.val
        path.append(node.val)
        
        if node.left is None and node.right is None:
            if currentSum == targetSum:
                output.append(path[:])
        
        self.getPaths(node.left,targetSum,currentSum,path,output)
        self.getPaths(node.right,targetSum,currentSum,path,output)
        
        path.pop()
        
        return output
        