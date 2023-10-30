# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        """
        Time Complexity: O(n)
        Space Complexity: O(h)
        The approach: 
            - Recursion Stack (Did preorder here)
            - create global variable result and target 
            - create local variable path, currSum and root
            - In the helper function
                - if root is None return 
                - root.val will be added to currSum at each step
                - root.val will be added to path at each step
                - if currSum == target 
                    - create a copy of the path and append it to the result list
        Things to take care of:
            - Passing path as list can be tricky. As path is a list, it is a pointer.
            So when we pass it as a local variable, we tend to think that the list 
            will be same as the one we passed to the list. But, since it is a pointer
            it will be updated at every node. So, in order to overcome this challenge, 
            we need to do stack.pop() at the end of the function. 
            - We also need to make sure that we pass the copy of the path list in the 
            result. if we pass the path itself, we will be passing empty list. As, at 
            the end of the traversal, the path list will be empty because of the pop
        """
        self.result = []
        self.target = targetSum
        path = []
        currSum = 0
        self.helper(root, currSum, path)
        return self.result

    def helper(self, root, currSum, path):
        # Base
        if root == None:
            return
        # Logic
        currSum += root.val
        path.append(root.val)
        if root.left == None and root.right == None:
            if currSum == self.target:
                new_lst = path.copy()
                self.result.append(new_lst)        
        self.helper(root.left, currSum, path)
        self.helper(root.right, currSum, path)
        path.pop()