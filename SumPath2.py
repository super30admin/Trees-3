# Time Complexity : O(n), n is no of nodes in the tree (we are not considering copying elements to a new list, because we are doing that for  limited no of leaf nodes only)
# Space Complexity : O(h), where h is the height of the tree, since its a recursive solution, it uses stack implementation under the hood, and the no of elements in a stach at any time will at max be equal to the height of the tree (left subtree or right subtree)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA 

# Your code here along with comments explaining your approach:
# using backtracking technique
# traverse through the tree, add every node's value to a sum variable
# and maintain a path list adding every node to the path list
# if we reach a leaf node, and the sum is same as the target, then we create a copy of the path list
# and store it in the result list
# if we are not on a leaf node, we keep traversing left and then right
# if the path sum was not equal to the given target, we pop the leaf node element's value from the path list
# because it did not give us the target, so we can delete the last node from the list, while maintaing all the previous nodes


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# using backtracking solution

class Solution(object):
    
    # gobal variable that we are supposed to return
    def __init__(self):
        self.result = []

    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: List[List[int]]
        """
        
        path = []
        if root is None:
            return []
        # recursive call
        self.dfs(root, 0, path, targetSum)
        # reurning the result list
        return self.result

    def dfs(self, root, currsum, path, targetsum):
        # base case
        if root is None:
            return

        # action, adding the value of every node to a current path sum variable
        currsum = currsum + root.val
        # maintaing the path list as we go
        path.append(root.val)

        # checking for leaf node
        if root.left is None and root.right is None:
            # checking if the path sum is equal to target sum
            if currsum == targetsum:
                # if so, then we create a copy of the path list and then add our path list to the new list
                # because if we used path itself, we will get an empty list
                # reason in short - no return statement for leaf nodes, we will traverse further
                # and end up deleting all elements in the path list
                # so better to create a copy
                newpath = path[:]
                # and we append this path to result list
                self.result.append(newpath)
        
        # recursion

        # left traversal
        self.dfs(root.left, currsum, path, targetsum)
        # right traversal
        self.dfs(root.right, currsum, path, targetsum)

        # reaction, popping the element from the back of the list because it is not a part of the solution
        # if it is, then also we have already traversed through it and stored the path
        # this is called backtracking technique, undoing the action we have taken before recursion
        path.pop(len(path) - 1)



        