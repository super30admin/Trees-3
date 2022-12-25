# // Time Complexity : O(N^2)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

## we need to find all paths leading to a sum. we need to recursively go through every node until we reach the 
## leaf node and see if it is our sum or not. if it is we deepcopy the path and put it in result because
## ds in a ds is a pointer. and then we pop out the element from our path.

class solution:

    def pathsum(self, root, target):
        self.result = []
        self.helper(root, 0, [], target)
        return self.result
    
    def helper(self, root, currSum, path, targetSum):

        ##base
        if root == None:
            return
        ##logic
        path.append(root.val)

        curSum+= root.val

        self.helper(root.left, currSum, path, targetSum)

        if root.left == None and root.right == None:
            if currSum == targetSum:
                self.result.append(copy.deepcopy(path))

        self.helper(root.right, currSum, path, targetSum)

        path.pop()
