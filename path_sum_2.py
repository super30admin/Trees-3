# Time Complexity : Add - O(n)
# Space Complexity :O(h)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
1. I have used a global list variable to keep track of path
2. Since list is mutable DS I am using backtracking to resume the state of each node
3. I calculating cumulative sum at each node and checking it againsr the target sum
'''

class Solution:
    
    def __init__(self):
        self.global_list = []
        
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        self._helper(root, sum, 0, [])
        return self.global_list
    
    
    def _helper(self, root, sum_, curr_sum, curr_list):
        
        if root is None:
            return
        
        curr_sum += root.val
        curr_list.append(root.val)
    
        self._helper(root.left, sum_, curr_sum, curr_list)
        
        print (curr_sum, curr_list)
        if root.left is None and root.right is None:
            if curr_sum == sum_:
                self.global_list.append(curr_list[:])
        self._helper(root.right, sum_, curr_sum, curr_list)  
        curr_list.pop()
        