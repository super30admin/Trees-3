# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#Time complexity - O(n) - I am not sure
#Space complexity - O(1) since we are returning true or false
#Explanation - Recursively check both the nodes of the tree if they have equal values

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        return self.helper(root, root)
    def helper(self, node1, node2):
        if node1 == None and node2 == None:
            #print(node1.val)
            #print(node2.val)
            return True
        if node1 != None and node2 == None:
            return False
        if node1 == None and node2 != None:
            return False
        side1 = self.helper(node1.left, node2.right)
        side2 = self.helper(node1.right, node2.left)
        
        if side1== side2:
			#print(side1)
			#print(side2)		
            return (node1.val == node2.val)      