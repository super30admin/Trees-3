# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def checkSum(self,root,nodes_path,list_paths,sum_remaining):
        if root == None:
            return 
        nodes_path.append(root.val)
        if root.val == sum_remaining and root.left == None and root.right == None:
            list_paths.append(list(nodes_path))
        else:
            self.checkSum(root.left,nodes_path,list_paths,sum_remaining-root.val)
            self.checkSum(root.right,nodes_path,list_paths,sum_remaining-root.val)
        nodes_path.pop()
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        list_paths = []
        self.checkSum(root,[],list_paths,targetSum)
        return list_paths
