'''
Problem: https://leetcode.com/problems/path-sum-ii/ 

Approach: 
1. Use a recursive function to traverse the tree.
2. Maintain a temporary list to store the current path and a sum variable to track the current path sum.
3. When a leaf node is reached, check if the path sum equals the target sum.
4. If it does, append the current path to the output list.
5. Pop the last element from the path list to remove the current node from the path ( backtracking).

Time Complexity: O(N^2) ( In case where every path gives target sum), Average O(N) where N is the number of nodes in the tree. 
Space Complexity: O(H) where H is the height of the tree due to recursion stack.
'''

# Approach Doing Only Recursion, Time Complexity: O(N^2)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        output = []

        def solve(node, path, sum):
            if not node:
                return
            temp = deepcopy(path)
            temp.append(node.val)
            sum += node.val

            if not node.left and not node.right:
                if sum == targetSum and len(temp) > 0:
                    output.append(temp)

            solve(node.left, temp, sum)
            solve(node.right, temp, sum)

        solve(root, [], 0)

        return output


# Approach Doing Backtracking, Average Time Complexity: O(N), Space Complexity: O(H)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        output = []

        def solve(node, temp, sum):
            if not node:
                return
            # temp = deepcopy(path)
            # temp.append(node.val)
            temp.append(node.val)
            sum += node.val

            if not node.left and not node.right:
                if sum == targetSum and len(temp) > 0:
                    output.append(list(temp))

            solve(node.left, temp, sum)
            solve(node.right, temp, sum)

            if len(temp)>0:
                temp.pop()

        solve(root, [], 0)

        return output
