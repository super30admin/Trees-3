# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    '''Time Compplexity: O(n) approx
    Space Complexity: O(n)'''
    
    def helper(self, root, targetSum, result, currentsum, path):
        
        if not root:
            return
        currentsum+=root.val

        #Action
        path.append(root.val)
        if currentsum==targetSum and root.left is None and root.right is None: 
            #We are not creating a new list at each and every node.
            result.append(copy.deepcopy(path))
        
        #Recurse
        self.helper(root.left, targetSum, result, currentsum, path)
        self.helper(root.right, targetSum, result, currentsum, path)
        
        #Backtrack
        
        #Use .pop() instead of .remove()...the later does not deletes the last element, it deletes the first occurance
        path.pop()
        return result
        
            
        
    def pathSum(self, root, targetSum):
        """
        :type root: TreeNode
        :type targetSum: int
        :rtype: List[List[int]]
        """
       
        if not root:
            return []
        
        result=[]
        return self.helper(root, targetSum, result, 0, [])
        
        
