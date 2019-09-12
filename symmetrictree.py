#time complexity: o(n)
#leetcode: accepted
#doubt:  finding it difficult to traverse the recurrsive statements
#explaination: for a tree to be symmetric, its left and right valuesshould be the same and you start it from the root node.if the roots have children, you compare the values of the left and right childs and keep calling it recursively  until the base case occur which is root code is None





# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        def ismirror(root1,root2):
            if root1 is None and root2 is None:
                return True
            if root1 is not None and root2 is not None:
                if root1.val==root2.val:
                    return(ismirror(root1.left,root2.right) and ismirror(root1.right,root2.left))
        return ismirror(root,root)