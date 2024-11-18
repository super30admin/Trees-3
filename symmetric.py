# // Time Complexity :O(n) for (3n)copy+invert+check if same
# // Space Complexity :O(n)+h for deepcopy and recursion stack
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this : Depth First Search


# // Your code here along with comments explaining your approach

# We invert the copy the tree then invert it and compare
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def copy(root):                         # create a deepcopy of tree 1
            if not root:
                return        
            node = TreeNode(root.val)
            node.left = copy(root.left)         
            node.right = copy(root.right)       
            return node

        def invert(root):                       # invert the tree
            if not root:
                return 
            #swap
            temp = root.right
            root.right = root.left 
            root.left = temp

            invert(root.left)                   
            invert(root.right)                  
            return root
        
        tree2 = invert(copy(root))              
        return self.sameTree(root,tree2)        # now compare tree1 and tree2
        
    def sameTree(self,p,q):
        if not p and not q:
            return True
        if not p or not q:
            return False
        if p.val != q.val:
            return False

        return self.sameTree(p.left,q.left) and self.sameTree(p.right,q.right)

# # faster approach
# class Solution:
#     def isSymmetric(self, root: Optional[TreeNode]) -> bool:
#         return self.dfs(root.left,root.right)

#     def dfs(self,left,right):           
#         #basecase
#         if not left and not right:      # both empty? leafnode
#             return True
#         if not left or not right:       # one empty/other not
#             return False
#         #logic
#         if left.val != right.val:        
#             return False

#         return self.dfs(left.left,right.right) and self.dfs(left.right,right.left)