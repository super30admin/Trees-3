# problem 1 : 113. Path Sum II : https://leetcode.com/problems/path-sum-ii/
# Time Complexity : O(n^2)
# Space Complexity : O(n^2) : if considering the output space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        if not root:
            return []
        self.res = []       
        self.helper(root,0,[],sum)
        return self.res

    def helper(self, node, total, l,sum):
        l.append(node.val)
        total += node.val
        if not node.left and not node.right :
            if total == sum:
                self.res.append(list(l))             
        else:      
            if node.left:
                self.helper(node.left, total, l,sum)
            if node.right:
                self.helper(node.right, total, l,sum)
        l.pop()
        



# problem 2 : 101. Symmetric Tree : https://leetcode.com/problems/symmetric-tree/
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        return self.helper(root.left, root.right)
    
    def helper(self,left,right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        if left.val != right.val:
            return False
        return self.helper(left.left, right.right) and self.helper(left.right, right.left)
    
## check postorder traversal and reverse postorder traversal
#     def isSymmetric(self, root: TreeNode) -> bool:
#         postRes, revPostRes = '', ''
#         postRes = self.getPost(root, postRes)
#         revPostRes = self.getrevPost(root, revPostRes)
#         #print(postRes)
#         #print(revPostRes)
#         if postRes == revPostRes :
#             return True
#         return False
        
        
#     def getPost(self, root: TreeNode, postRes: str) -> str:
#         if root is None :
#             return postRes + 'N'
#         postRes = self.getPost(root.left, postRes)
#         postRes = self.getPost(root.right, postRes)
#         return postRes + str(root.val)
        
        
        
#     def getrevPost(self, root: TreeNode, revPostRes: str) -> str:
#         if root is None :
#             return revPostRes + 'N'
#         revPostRes = self.getrevPost(root.right, revPostRes)
#         revPostRes = self.getrevPost(root.left, revPostRes)
#         return revPostRes + str(root.val)
        

