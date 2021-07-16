# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        
        def dopath(root,curNodes,cursum):
            if root:
                cursum=cursum+root.val
                curNodes.append(root.val)
                dopath(root.left,curNodes,cursum)
                
                if cursum==targetSum and root.left==None and root.right==None:
                    
                    self.result.append([x for x in curNodes])
                dopath(root.right,curNodes,cursum)
                curNodes.pop()
                
        self.result=[]
        dopath(root,[],0)
        return self.result
    # time O(n)amortized -as worst will be O(n^2) for copying list everytime
    # Space O(n)
