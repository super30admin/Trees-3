# APPROACH 1 - ITERATIVE WAY
# Time Complexity : O(n^2), n: number of nodes of the tree
# Space Complexity : O(nh), h: height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Do inorder traversal. As you keep adding nodes to the stack, also add the current sum found till now and also copy of array that has elements visited till now to reach this node
# 2. When you pop, If it's a leaf node, compare the current sum with the target. If equal, add the path to the result

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        if root is None:
            return None
        
        stack, curr_sum, isFirst, curr_path, result, target = [], 0, True, [], [], sum
        
        while root is not None or(len(stack) > 0 or isFirst):
            isFirst = False
            
            while root is not None:
                curr_sum += root.val
                curr_path.append(root.val)
                list_add = copy.deepcopy(curr_path)
                stack.append((root, curr_sum, list_add))
                root = root.left
                
            curr_node = stack.pop(-1)
            root, curr_sum, curr_path = curr_node[0], curr_node[1], curr_node[2]
            
            if root.left is None and root.right is None and curr_sum == target:
                result.append(curr_path)
                
            root = root.right
            
        return result






# APPROACH 2: RECURSIVE WAY
# Time Complexity : O(n^2), n: number of nodes of the tree
# Space Complexity : O(nh), h: height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Same as above but in a recursive way
# 2. Have to maintain current sum and path locally.
# 3. Each time I send path to the next node, create a deepcopy and not just send (as arrays get passed by pointer which becomes the same scenario as if we are maintaining it as
#    global variable).
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.result = []
        
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        if root is None:
            return None
        
        target = sum
        return self.helper(root, 0, [], target)
    
    def helper(self, root, curr_sum, curr_path, target):
        
        if root is None:
            return
        
        curr_sum += root.val
        curr_path.append(root.val)
        if root.left == None and root.right is None and curr_sum == target:
            self.result.append(curr_path)
            
        self.helper(root.left, curr_sum, copy.deepcopy(curr_path), target)
        self.helper(root.right, curr_sum, copy.deepcopy(curr_path), target)
        
        return self.result
