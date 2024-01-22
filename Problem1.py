'''
Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach
Performing DFS recursively from root to leaf node. Passing three arguments node, recurring sum and recurring list from
root till leaf and then compare the target sum with recurring sum whenever leaf node is reached. If they're equal then the
recurring list is returned
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        def pathsum(node,sum,curlist):
            nonlocal res

            if node:
                curlist.append(node.val)
                sum += node.val

                if node.left is None and node.right is None:
                    if sum == targetSum:
                        res.append(list(curlist))
                    curlist.pop()
                    return

                pathsum(node.left,sum,curlist)
                pathsum(node.right,sum,curlist)
                curlist.pop()

        res = []
        pathsum(root,0,[])
        return res