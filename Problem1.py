#Problem  113. PATH SUM II
# TIME COMPELXITY: O(H) where H denotes the height of tree
# SPACE COMPLEXITY: O(H) where H denotes the height of tree as we are making recursion stack based on the height of tree (since doing DFS) 

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        self.result=[]
        self.helper(root,targetSum,0,[])
        return self.result

    def helper(self,root,targetSum,currentSum,path):
        #base
        if root is None:
            return

        #logic
        path.append(root.val)
        currentSum+=root.val

        if root.left is None and root.right is None and currentSum==targetSum:
            self.result.append(list(path))

        
        self.helper(root.left,targetSum,currentSum,path)
        self.helper(root.right,targetSum,currentSum,path)
        path.pop()