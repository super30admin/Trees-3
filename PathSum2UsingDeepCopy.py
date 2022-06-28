# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def helper(self, root, targetSum, result, currentsum, path):
        if not root:
            return
        currentsum+=root.val

        path.append(root.val)
        if currentsum==targetSum and root.left is None and root.right is None:
            result.append(path)
            return result
        
        self.helper(root.left, targetSum, result, currentsum, copy.deepcopy(path))
        self.helper(root.right, targetSum, result, currentsum, copy.deepcopy(path))
        return result
        
            
        
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
        '''Time Complexity: O(n^2) --- Because of the deep copy ot n*h avg
        Space Complexity: O(n^2) ---- Because of the creation of the new list
        '''
        if not root:
            return []
        
        result=[]
        return self.helper(root, targetSum, result, 0, [])
        
