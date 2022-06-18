#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(n) i.e. using list as path for putting the nodes
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=JW2KxAHFqv8&ab_channel=%7BS30%7D
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        #creating the instance of the class
        self.result=[]
        #null condition
        if root == None:
            return self.result
        #calling the recursion function by passing the parameters like root, currentsum, the path and the targetsum for checking the sum of the path
        self.helper(root, 0, [], targetSum)
        return self.result
    def helper(self, root : TreeNode, currentSum :int, path : List[int], targetSum :int):
        #base condition
        if root == None:
            return
        #logic
        #adding the value of the root in each recursion
        currentSum += root.val
        #print("CurrentSum", currentSum)
        #appending the root in path at each recursion
        path.append(root.val)
        #print("Appended path" , path)
        #calling recursion for the left subtree and right subtree
        self.helper(root.left, currentSum, path, targetSum)
        #print("UP",root)
        self.helper(root.right, currentSum, path, targetSum)
        #print("Down",root)
        #if the pathsum is equal to the target at the leaf then whole path in form of list is added to the list
        if root.left == None and root.right == None and targetSum == currentSum:
            self.result.append(list(path))
            #print("result", self.result)
        #backtracking removing the last element from the path everytime at the end of recursion so that no new list is created
        path.pop(len(path)-1)
        #print("Backtrack path", path)
