#Time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#do a BFS level order traversal on the tree. Pop out 2 nodes at a time and check if the 
#left and right parts of these 2 nodes are symetrical ie left.left and right.right, left.right and right.left.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        if(root.left==None and root.right==None):
            return True
        if(root.left==None or root.right==None):
            return False
        Q=[root.left,root.right]
        while(Q):
            n=len(Q)
            if(n%2==1):
                return False
            while(n>0):
                left=Q[0]
                right=Q[1]
                del(Q[0])
                del(Q[0])
                if(left.val!=right.val):
                    return False
                if(left.left==None and right.right!=None):
                    return False
                if(left.right==None and right.left!=None):
                    return False
                if(right.left==None and left.right!=None):
                    return False
                if(right.right==None and left.left!=None):
                    return False
                if(left.left):
                    Q.append(left.left)
                    
                if(right.right):
                    Q.append(right.right)
            
                if(left.right):
                    Q.append(left.right)
                if(right.left):
                    Q.append(right.left)
                    
                n-=2
        return True
