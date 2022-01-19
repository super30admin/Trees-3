"""
// Time Complexity : O(n)
// Space Complexity : O(h) worst case this will be O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
We maintain the sum at each stack frame. We want the currsum before making the recursive calls. We will have a local variable CurrSum
to update at each call. This is local to our recursion. If the root is none we return None. At each Recursion state before making the recursive call
we calculate the current sum and add the root value to the local path list. We recruse on the left. If we reach a leaf node we check if our currsum equals to our target sum, if yes
we add our path list to the global list and recurse on the right. after recursion on the right we have to pop the last added element of our local path list so that we don't keep adding to the same list in our
next recursion call.

"""
class Solution(object):
    def pathSum(self, root, targetSum):
        self.globalSum = targetSum
        self.listOfNodes = []
        currlevel  = []
        self.helper(root, currlevel, 0)
        return self.listOfNodes
    def helper(self, root, currlevel, currSum):
        if root == None:
            return None
        currSum += root.val
        currlevel.append(root.val)
        # recurse
        self.helper(root.left, currlevel, currSum)
        if root.left == None and root.right == None:
            if currSum == self.globalSum:
                self.listOfNodes.append(list(currlevel))
        self.helper(root.right, currlevel, currSum)
        currlevel.pop()