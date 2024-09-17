# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
#LC: 113, yes
#problems: NA, I dont think I would have come up to create a deep copy of list , 
#that it is getting passed by reference, 
#and a data structure in a data structure is a pointer. 
#TC: O(n) , n is no of nodes in tree, O(n^2) in worst case for deep copy
#SC: O(N) , n is no of nodes in the tree, used by path array
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        answer = []
        path = []
        
        def helper(root, Sum, path):
            
            #base
            if root is None: 
                return
            
            #logic
            path.append(root.val)
            Sum += root.val
            
            if(root.left is None and root.right is None):
                if(Sum == targetSum):
                    answer.append(path[:])
            helper(root.left, Sum , path)
            helper(root.right, Sum , path)
            
            path.pop()
            print(path)
        helper(root, 0, path)
        return answer

            