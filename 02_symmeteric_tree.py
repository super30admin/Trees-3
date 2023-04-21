'''
Approach:
---------
starting with both pointers on root node
left will dfs is NLR order
right will dfs is NRL order


Complexity Analysis:
--------------------
TC: O(n/2)=O(n) since we are visiting 2 nodes simultaneously
SC: O(H) we will have recursive stack equal to the height of the tree 

'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        #two pointer left and right
        #left pointer will do NLR
        left = root
        
        #right pointer will do NRL both DFS
        right = root
        
        def recursion(left, right):
            if left == None and right == None:
                return True
            if left and right:
                if left.val == right.val:
                    flag1 = recursion(left.left, right.right)
                    flag2 = recursion(left.right, right.left)
                    if flag1 == True and flag2==True:
                        return True
                    return False
            else:
                return False
        
        return recursion(left, right)
            
        