# Iterative solution with deep copying the paths
# We deep copy the paths in order to maintain it with respect to the node we are at
# Without deep copying, we will end up populating the paths will all values
# Output: Return list of list
# Time : O(N^2)
# Space: O(N^2)

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:

        result = []

        if root is None:
            return result

        stack = []
        path = []
        currentSum = 0

        while root != None or stack != []:

            while root != None:

                currentSum += root.val
                path.append(root.val)
                stack.append((root, currentSum, path.copy()))
                root = root.left

            root, currentSum, path = stack.pop()

            if root.left is None and root.right is None and currentSum == sum:
                result.append(path)

            root = root.right

        return result





# Recursive approach with deep copying

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:

        self.result = []

        # base case
        if root == None:
            return self.result

        currentSum = 0
        self.target = sum
        path = []

        self.helper(root, currentSum, path)
        return self.result


    def helper(self, root, currentSum, path):

        #base case

        if root == None:
            return


        # logic

        currentSum += root.val
        path.append(root.val)

        if root.left is None and root.right is None and currentSum == self.target:
            self.result.append(path)

        self.helper(root.left, currentSum, path.copy())
        self.helper(root.right, currentSum, path.copy())
