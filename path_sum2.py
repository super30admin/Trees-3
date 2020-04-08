"""
// Time Complexity : O(d2) //d is depth of the tree (Unsure)
    Tried to reason, what can be worst case leaf nodes, sum of d elements are to be computed for each leaf node
// Space Complexity : O(d) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Ambiguity about complexity
// Your code here along with comments explaining your approach
Algorithm explanation
DFS: Configuration A = [](holds list of all paths in the form of string), P = [](holds current path in form of string)
    1) We append the root
    2) If we approach the leaf then
        - Check if the sum of P is equal to target sum 
            - Append P to A
    3) Else
        recurse root.left
        recurse root.right
    4) P.pop() -> Bactracking to caller node to consider all paths
Main fn
1) Call dfs function
2) return A

Think it's not optimal
For optimal, maybe somehow keep track of the values in another variable(decrement from current value)
passed to function and at leaf if the value is 0, add the path
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def pathSum(self, root: TreeNode, sm: int) -> List[List[int]]:
        P = []
        A = []
        
        def helper(root):
            if not root:
                return
            P.append(root.val)
            if not root.left and not root.right:
                if sum(P) == sm:
                    A.append(P[::])
            else:
                helper(root.left)
                helper(root.right)
            P.pop()
        helper(root)
        return A