'''
Time complexity: O(N)
Space complexity: O(H)
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
   
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        self.res = []
        self.dfs(root,0,targetSum, list())
        return self.res
    
    #OPTIMIZED APPROACH 
    def dfs(self, root, currSum, targetSum, path):
        if root is None:
            return 
        currSum += root.val
        # action
        path.append(root.val)
        
        if root.left is None and root.right is None:
            if currSum == targetSum:
                new_path = path[:]
                self.res.append(new_path)
        # recurse part 
        self.dfs(root.left, currSum, targetSum, path)
        self.dfs(root.right, currSum, targetSum, path)
        # removal part
        path.pop(len(path)-1)

        '''
    This approach will result in 
    Time complexity: O(NH) where H is the number of nodes to be copied into new list 
    Space complexity: O(NH)
    def dfs(self, root, currSum, targetSum, path):
        if root is None:
            return
        currSum = currSum + root.val
        new_path = path[:]
        new_path.append(root.val)
        print(new_path)
        if root.left is None and root.right is None:
            print('yes leaf node',root.val)
            if currSum == targetSum:
                self.res.append(new_path)
                print(self.res)
                return
        self.dfs(root.left, currSum, targetSum, new_path)
        
        self.dfs(root.right, currSum, targetSum, new_path)
    '''