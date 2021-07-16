#Time Complexity: O(N^2).
#Auxiliary Space: O(N)
#Did this code successfully run on Leetcode :Yes

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def __init__(self):
        self.result = []
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        def inorder(root,cursum,templist):
            if not root:
                return
            cursum = cursum+root.val
            templist.append(root.val)
            inorder(root.left,cursum,templist)
            if not root.left and not root.right:
                if cursum==targetSum:
                    self.result.append(list(templist))

            inorder(root.right,cursum,templist)
            del templist[-1]
           
        
        inorder(root,0,[])
        return self.result