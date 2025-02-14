#Time complexity O(n^2)
#Space complexity O(n^2)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:

        return self.helper(preorder, inorder)
    
    def helper(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        ##base case
        if(len(preorder) == 0):
            return None

        ##logic
        rootVal = preorder[0]
        root = TreeNode(rootVal)

        rootIdx = inorder.index(rootVal)
            
        inleft = inorder[0:rootIdx]
        inright = inorder[rootIdx+1:]
        preleft = preorder[1:1+len(inleft)]
        preright = preorder[1+len(inleft):]

        root.left = self.helper(preleft, inleft)
        root.right = self.helper(preright,inright)

        return root


        