#TC O(nh) SC O(nh)  - maintaining list of n elements at every height
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return []
        self.result = []
        self.dfs(root, 0 , [], targetSum)
        return self.result

    def dfs(self, root: Optional[TreeNode], currSum: int, path: List[int], targetSum: int) -> None:
        #base case
        if root == None:
            return

        #main logic
        path.append(root.val)
        currSum = currSum + root.val
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append(path)
            return
        #[i for i in path] creates separate list otherwise if path is passed in recursive call then it is actually passed by reference
        self.dfs(root.left, currSum, [i for i in path], targetSum)
        self.dfs(root.right, currSum, [i for i in path], targetSum)




#Bactracking -> action -> recurse functions - > backtrack
#TC O(n) SC O(h)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root == None:
            return []
        self.result = []
        self.dfs(root, 0 , [], targetSum)
        return self.result

    def dfs(self, root: Optional[TreeNode], currSum: int, path: List[int], targetSum: int) -> None:
        #base case
        if root == None:
            return

        #main logic - action
        path.append(root.val)
        currSum = currSum + root.val
        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append([i for i in path])
            #return
        #recurse
        #[i for i in path] creates separate list otherwise if path is passed in recursive call then it is actually passed by reference
        self.dfs(root.left, currSum, path, targetSum)
        self.dfs(root.right, currSum, path, targetSum)

        #backtrack 
        path.pop()
