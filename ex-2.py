#time complexity: O(n) we travel to all nodes 
#space complexity: O(n) - at worst case where we create n/2 pairs for full binary tree.

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
        queue = deque([(root.left, root.right)]) #added a tuple of left and right node of the root 
        while queue:
            n1, n2 = queue.popleft() #popping the tuple(pair)
            if not n1 and not n2:  #when its parent is a leaf
                continue #skips the statements after that and start from while loop
            if not n1 or not n2 or (n1.val != n2.val):   #if atleast one is not none adn if both are not none then its values are different 
                return False
            queue.append((n1.left, n2.right))  #For symmetry 
            queue.append((n1.right, n2.left))
        return True
            
