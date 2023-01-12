# Time Complexity :
# O(N)  - Size of the Tree

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We go through the tree in a  pre order manner. Whenever we hit a leaf node, we check if the path until then 
#sums to the target sum. If it does, we add the path to the set of results


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.lists = []

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.targetSum = targetSum
        self.traverse(root,0,[])
        return self.lists

    def traverse(self,root,currSum,curr_history):
        if root == None :
            return
        
        currSum = currSum + root.val
        curr_history.append(root.val)
        if root.left == None and root.right == None :
            if currSum == self.targetSum:
                self.lists.append(curr_history[:])

        self.traverse(root.left,currSum,curr_history)
        self.traverse(root.right,currSum,curr_history)
        curr_history.pop()
