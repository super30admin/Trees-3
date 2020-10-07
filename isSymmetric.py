class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        """
        Time Complexity: O(N)
        Space Complexity: O(N)

        Accepted.
        """
        if root==None:
            return True
        
        child1 = root.left
        child2 = root.right
        
        return self.traversal(child1, child2)
    
    def traversal(self, child1, child2):
        #check fo leaf node reach
        if not child1 and not child2:
            return True
        elif not child1 or not child2: #Asymmetric
            return False
        
        t1 = self.traversal(child1.left, child2.right)
        t2 = self.traversal(child1.right, child2.left)
        
        if t1 & t2 and child1.val == child2.val:
            return True
        return False