"""
Time complexity O(N)
Space complexity O(1)
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_pathSum:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if root is None:
            return []
        path=[]
        currsum=0
        self.res=[]
        self.pathSumHelper(root,currsum,path,sum)
        return self.res
    
    def pathSumHelper(self,root,currsum,path,sum):
        if not root:
            return 
        
        currsum+=root.val
        path.append(root.val)
        
        if root.left is None and root.right is None:
            if(currsum==sum):
                self.res.append([*path])
                print(self.res)
            
            
        self.pathSumHelper(root.left,currsum,path,sum)
        self.pathSumHelper(root.right,currsum,path,sum)
        currsum-=root.val
        path.pop()