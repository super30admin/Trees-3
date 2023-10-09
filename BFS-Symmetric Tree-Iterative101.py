# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#BFS Approach
# Time Complexity: O(n) where n is the number of elements in the tree
# Space Complexity: O(h) where h is the height of the tree
class Solution(object):
    def isSymmetric(self, root):
        if root is None: # If root is empty then return
            return
        q = []
        q.append(root.left)
        q.append(root.right)
        while(q):
            #print (q)
            leftRoot = q.pop(0)
            rightRoot = q.pop(0)
            # print("left",leftRoot)
            # print("\\")
            # print("right",rightRoot)   
            if leftRoot is None and rightRoot is None: 
                continue
            if leftRoot is None or rightRoot is None:
                return False
            if leftRoot.val != rightRoot.val:
                return False
            # comparing the leaves
            # two corresponsing should be yhe same
            q.append(leftRoot.left)
            q.append(rightRoot.right)   
            q.append(leftRoot.right)
            q.append(rightRoot.left)
                     
        return True
            
    
        
    





        
       
        

        
