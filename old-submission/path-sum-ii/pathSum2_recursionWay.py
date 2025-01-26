# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.rtrPair = []
    
    def helper_pathSum(self,node,tgt,pairList):
        
        # base
        if node == None:
            return
        
        # logic
        # 1. Copy the pairList elements into a newList
        list = pairList[:]
        
        if (tgt-node.val == 0) and (node.left == None and node.right == None):
            # Result is 0 and it's a leaf node
            list.append(node.val)
            self.rtrPair.append(list)
            return
        
        else:
            # go further to get zero till leaf
            list.append(node.val)
            
            # check on lhs
            self.helper_pathSum(node.left,(tgt-node.val),list)
        
            # check on rhs
            self.helper_pathSum(node.right,(tgt-node.val),list)
    
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.helper_pathSum(root,targetSum,[])
        return self.rtrPair
