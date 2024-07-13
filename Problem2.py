#I used a recursive approach to check if the tree is symmetric. I created a helper function isEqual that takes two nodes as input and compares them. The function first checks if both nodes are null (which is a valid symmetric case), or if one is null and the other isn't (which is not symmetric). If the values of the nodes are different, it's not symmetric. The key part is the recursive calls: I check if the left subtree of the first node is equal to the right subtree of the second node (inner symmetry), and if the right subtree of the first node is equal to the left subtree of the second node (outer symmetry). Both these conditions must be true for the tree to be symmetric. Finally, I call this helper function on the left and right subtrees of the root node.

class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        
        def isEqual(t1,t2):
            if not t1 and not t2: return True
            if not t1 or not t2:return False
            if t1.val!=t2.val: return False
            inner=isEqual(t1.left,t2.right)
            outer=isEqual(t1.right,t2.left)
            
            return inner and outer
        return isEqual(root.left,root.right)