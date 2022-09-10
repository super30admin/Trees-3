'''
113. Path Sum II

APPROACH 1: Using stack variables 
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(H) H = height of the tree
LEETCODE: yes
DIFFICULTIES: yes, but I could solve it.

APPROACH 2: using only global variables
TIME COMPLEXITY: O(n)
SPACE COMPLEXITY: O(1)
LEETCODE: yes
DIFFICULTIES: a bit

'''


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        global res, path, path_sum
        res, path, path_sum = [], [], 0
        
        if root == None:
            return res
        
        def approach1(root, temp_arr, curr_sem):
            global res
            # base
            if root.left == None and root.right == None:
                if root.val + curr_sem == targetSum:
                    tt = temp_arr.copy()
                    tt.append(root.val)
                    res.append(tt)
                return None
            
            # logic
            temp = temp_arr.copy()
            curr_sem += root.val
            temp.append(root.val)
            if root.left != None:
                approach1(root.left, temp, curr_sem)
            if root.right != None:
                approach1(root.right, temp, curr_sem)
            
        def approach2(root):
            global res, path, path_sum
            # base
            if root.left == None and root.right == None:
                if path_sum + root.val == targetSum:
                    res.append(path + [root.val])
                return None
            
            # logic
            path.append(root.val)
            path_sum += root.val
            if root.left != None:
                approach2(root.left)
            if root.right != None:
                approach2(root.right)
            path.pop()
            path_sum -= root.val
            
        
        # approach1(root, [], 0)
        approach2(root)
        
        return res
        
