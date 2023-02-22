#All TC on leetcode passed


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:

        #Here we traverse till leaf nodes and see if the sum is equal to targetSum. If yes we store that path. 
        #Time complexity: - O(n) - where n is no. of nodes in tree
        #Space complexity - O(h) - where h is the height of the tree


        #recurrsive no extra space backtrack approach

        self.res = []

        def helper(root, curSum, path):

            curSum += root.val
            path.append(root.val)

            if not root.left and not root.right and curSum==targetSum:
                self.res.append(path.copy())

            if root.left:
                helper(root.left, curSum, path)
            
            if root.right:
                helper(root.right, curSum, path)

            path.pop()

        helper(root, 0 , [])
        return self.res


#--------------------------------------OR-----------------------------------------------

        #Here we traverse till leaf nodes and see if the sum is equal to targetSum. If yes we store that path. 
        #Time complexity: - O(n*h) - where n is no. of nodes in tree and h is the height of the tree. For each node we have to copy the nodes into new path list
        #Space complexity - O(n*h) - For each node we have to copy the nodes into new path list 
        #recurrsive extra space approach
        self.res = []

        def helper(root, path, curSum):

            if not root:
                return 
                
            curSum += root.val
            path.append(root.val)
            if not root.left and not root.right and curSum==targetSum:
                self.res.append(path)
            
            if root.left:
                helper(root.left, path.copy(), curSum)

            if root.right:
                pr = path.copy()
                helper(root.right, path.copy(), curSum)


        helper(root, [], 0)
        return self.res


#--------------------------------------OR-----------------------------------------------

        #iterative approach
        if not root:
            return []

        stack = []
        stack.append([root, 0, []])
        res = []

        while stack:
            root, curSum, path = stack.pop()

            curSum += root.val
            path.append(root.val)
            if not root.left and not root.right and curSum==targetSum:
                res.append(path)

            if root.left:
                stack.append([root.left, curSum, path.copy()])

            if root.right:
                stack.append([root.right, curSum, path.copy()])

        return res
        