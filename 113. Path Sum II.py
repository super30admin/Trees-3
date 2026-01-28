# Time: O(n * h) n for going through all the elements and h is to create a deep copy
# Space: O(h * n) h is the recursive stack space and n is for the array 

# Q => Find the path where addition of nodes is == target at the leaf node

# so keep the sum until the current node to check if the sum == target
# create a deep copy of the list so that it is not passed by reference 
# At pre-order check if the left and right node are None and if the sum == target
# If yes then just add the list to the result

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        sub_arr = []
        s = 0
        self.helper(root,targetSum, s, sub_arr)
        return self.res
    def helper(self,root, target, s, sub_arr):
        # Base cases
        if root == None:
            return
        # Logic
        s += root.val
        new = list(sub_arr)
        new.append(root.val)
        if root.left == None and root.right == None:
            if s == target:
                self.res.append(new)
        self.helper(root.left, target, s, new)
        self.helper(root.right, target, s, new)


# Time: O(n)
# Space: O(h)
# Instead of creating a deep copy at each node we just create a deep copy when we have to append the list to the resultant array
# Other times we just keep the same array and pop the element out when we go back from the root

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.res = []
        sub_arr = []
        s = 0
        self.helper(root,targetSum, s, sub_arr)
        return self.res
    def helper(self,root, target, s, sub_arr):
        # Base cases
        if root == None:
            return
        # Logic
        s += root.val
        sub_arr.append(root.val)
        if root.left == None and root.right == None:
            if s == target:
                self.res.append(list(sub_arr))
        self.helper(root.left, target, s, sub_arr)
        self.helper(root.right, target, s, sub_arr)
        sub_arr.pop()