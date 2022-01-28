# Leetcode Execution: YES
# Time Complexity: O(n)
# Space Complexity:O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # we will be using the bfs approach 
        # we add the elements to the queue like left of node 1 and right of node 2 then right of node and left of node 2 
        # we do this iteratively 
        # and for every iteration we take out two nodes and make it node and node two and check of they are same in a particular way
        
        
        q=[]
        q.append(root.left)
        q.append(root.right)
        while len(q)>0:
            node=q.pop(0)
            node2=q.pop(0)
            if node==None and node2==None:
                pass
            elif node==None or node2==None or node.val!=node2.val:
                return False
            else:
                q.append(node.left)
                q.append(node2.right)
                q.append(node.right)
                q.append(node2.left)
        return True
        