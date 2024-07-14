#// Time Complexity : O(n) 
# // Space Complexity : O(n)   
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Yes i was getting all the nodes in the path when i was adding it to the resule.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []

        def helper(root, currsum , path):
            if root == None:
                return
            temp = copy.deepcopy(path)
            currsum += root.val
            temp.append(root.val)
            if root.left == None and root.right == None:
                if currsum == targetSum:
                    result.append(temp)
            

            helper(root.left,currsum,temp)
            helper(root.right,currsum,temp)
        
        helper(root,0,[])

        return result

# Approach:
# 1. We will use a helper function to traverse the tree and check if the current node is a
# leaf node and if the sum of the current path is equal to the target sum. If both the
# conditions are true, we will add the current path to the result list.

