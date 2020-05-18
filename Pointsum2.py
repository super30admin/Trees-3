#Time COmplexity : O(N)
#Space Complexity : O(H*N) where H is is the height of the tree ad N is Number of Nodes in the list

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        result = []
        def helper(root,currsum = 0,temp = []):
            if root == None:
                return
            temp.append(root.val)
            currsum+=root.val
        
            if root.left == None and root.right ==None:
                if currsum == sum:
                    result.append(temp)
            helper(root.left,currsum,temp[:])
            helper(root.right,currsum,temp[:])
        helper (root)
        return result