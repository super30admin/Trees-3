"""

    Student : Shahreen Shahjahan Psyche
    Time Complexity : O(N) [It is touching every node once]
    Space Complexity : O(H+N) [Height of the tree and the array which I am tracking to add in result]

    Although I am getting the values correct but there is one problem which I 
    was not able to debug. 

    Suppose, this is the test case - 

    [5,4,8,11,null,13,4,7,2,null,null,5,1]
    Target = 22

    The result should be  : [[5,4,11,2],[5,8,4,5]]

    But I am getting : [[5,4,11,2],[5,4,11,2],[5,8,4,5],[5,8,4,5]]

    Why this duplicates are coming I am not able to trace back. But the 
    returning paths are correct!

"""
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        res = []
        curr = []
        
        if root is None:
            return res
        
        def helper(root, sum, curr_val):
            
            if root is None:
                # print(curr_val)
                if curr_val == sum:
                    res.append(list(curr)) # copying the current list and saving it in the resultant list
                return
            
            curr_val = curr_val + root.val
            curr.append(root.val)
            
            helper(root.left, sum, curr_val)
            helper(root.right, sum, curr_val)
            
            curr.pop()
            
            return
        
        helper(root, sum, 0)
        return res
            
            
                
                    
        