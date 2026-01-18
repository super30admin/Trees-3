#--------Solition 1 : ---------
''' Time Complexity : O(n*h) ; n^2 in worst case where tree is skewed
    Space Complexity : O(n*h) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Brute Force : Creating new List each time we append the root to path

'''
class Solution:

    def __init__(self):
        self.result = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        def helper(root, currSum, path):
            if root is None :
                return 
                
            currSum += root.val
            path.append(root.val)
            helper(root.left,currSum, list(path))

            if root.left is None and root.right is None:
                if currSum == targetSum:
                    self.result.append(list(path))

            helper(root.right,currSum, list(path))

        helper(root, 0, [])
        return self.result


#--------Solition 2 : Optimized---------
''' Time Complexity : O(n) 
    Space Complexity : O(h) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : Backtracking after left and right call : poping the last added element. 
              Creating new list only at time of appending path to result
              
'''
class Solution:

    def __init__(self):
        self.result = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        def helper(root, currSum, path):
            if root is None :
                return 

            currSum += root.val
            path.append(root.val)
            
            if root.left is None and root.right is None:
                if currSum == targetSum:
                    self.result.append(list(path))

            helper(root.left,currSum, path)
            helper(root.right,currSum, path)

            path.pop()

        helper(root, 0, [])
        return self.result