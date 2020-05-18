#Time Complexity : O(N) +O(M) where N is number of Nodes in left side and M is number of nodes in roght side
#Space Complexity : O(H) +O(H)  where H is height of tree as nodes will be sotred in stack for left and right nodes 

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def mirror(rootA,rootB):
            if rootA == None and rootB ==None:
                return True
            elif rootA == None or rootB == None:
                return False
            elif rootA.val == rootB.val and mirror(rootA.left,rootB.right) and mirror(rootA.right,rootB.left):
                return True
            return False
        return mirror(root,root)
            