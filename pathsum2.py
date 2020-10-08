# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        result =[]
        self.helper(root,sum,[],result)
        return result
        
    def helper(self,current,sum_,currentpath,result):
        if not current:
            return 
        currentpath.append(current.val)
        if current.val == sum_ and current.left is None and current.right is None:
            result.append(list(currentpath))
        else:
            self.helper(current.left,sum_-current.val,currentpath,result)
            self.helper(current.right,sum_-current.val,currentpath,result)
        del currentpath[-1]
        
        
    ''' We have to return list of lists, where root to leaf path is equal to the required sum. 
    We will be traversing all the nodes and for each leaf node we will be store the list having 
    path from root to leaf if the sum is equal to sum required. Which explains the tc of o(n^2),
    space complexity is o(n^2) if we are considering space from result list    '''
