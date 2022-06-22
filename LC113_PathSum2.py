"""
LC113- Path Sum 2

Whenever we pass a list to the stack, it gets passed by reference whereas the sum is passed by vaalue
DATA STRUCTURE IN A DATA STRUCTURE IS ALWAYS AS REFERENCE --- LIST IN STACK, HASHMAP IN STACK etc etc

So we can create a new list every time a new element is encountered
It will also have a copy of elements that were added till that point
Brute Force
TC = O(n*n) as we are creating a copy of the list at each and every node
SC = O(n*n)

OPTIMIZATION : 

Backtracking - We use Recursion in Backtracking, But all Backtracking problems are not recursion problems, but can be solved using Brute force recursion
Also in recursion, we have to traverse all the paths, whereas thats not the case in Backtracking
//action
//recurse
//backtrack

Time Complexity = O(n)
SC = O(n)
We are using the same reference and removing elements from that


"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
M1 - Brute force recursion - Explore all the paths and check if the sum of path is equal to target sum, store the path.
"""

class Solution:
    # defining result as private to this class
    result = []

    def pathSum(self, root, targetSum):
        if root is None:
            return []
        self.helper(root, 0, [], targetSum)
        return self.result


    # TC - O(N^2) - each node * deep copy of path, O(N) - maintaining path
    def helper(self, root, curSum, path, targetSum):
        if root is None:
            return None

        curSum += root.val
        path.append(root.val)
        # check if we reached leaf node and have path sum desired.
        if curSum == targetSum and root.left is None and root.right is None:
            self.result.append(path)

        #  deep copy path - so each instance of node has its own path and not shared by reference
        self.helper(root.left, curSum, path[:], targetSum)
        self.helper(root.right, curSum, path[:], targetSum)


"""
M2 - Backtracking - Instead of passing fresh references of path for each recursive call, we reset our state of variable
    to be back to how they were. Doing so will let us use the same path instance instead of making individual references
    for each node. (reducing the TC of deep copy from O(N^2) to O(N))
    
"""

class Solution:
    # defining result as private to this class
    result = []

    def pathSum(self, root, targetSum):
        if root is None:
            return []
        self.helper(root, 0, [], targetSum)
        return self.result
        
    # TC - omg(N) - considering average case, deep copy is only numbered to desired outcome, SC- O(N) - maintaining path
    def helper(self, root, curSum, path, targetSum):
        if root is None:
            return None

        curSum += root.val
        path.append(root.val)
        # check if we reached leaf node and have path sum desired.
        if curSum == targetSum and root.left is None and root.right is None:
            # deep copy of path is stored in our result since we are using the same reference of path and will lose this
            # state later.
            self.result.append(path[:])

        #  deep copy path - so each instance of node has its own path and not shared by reference
        self.helper(root.left, curSum, path[:], targetSum)
        self.helper(root.right, curSum, path[:], targetSum)

        #backtrack
        path.pop()
