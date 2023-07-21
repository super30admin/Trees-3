#Time Complexity :O(n)
#Space Complexity :O(h) h is the height of the tree
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result=[]
        return self.helper(root,targetSum,0,[])

    def helper(self, root, targetSum, CurrSum,path):
        #base
        if not root:
            return 
        
        #logic
        CurrSum+=root.val
        path.append(root.val)

        #action
        if not root.left and not root.right:
            if CurrSum==targetSum:
                self.result.append(list(path))

        #recursion
        self.helper(root.left,targetSum,CurrSum,path)
        self.helper(root.right,targetSum,CurrSum,path)

        #backtracking
        del path[len(path)-1]
        return self.result
