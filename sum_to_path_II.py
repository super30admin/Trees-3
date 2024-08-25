# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # with append Time/ Space complexity = O(n). and O(h) 
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        def helper(root, cursum, path):
            nonlocal result
            if root:
                cursum += root.val
                path.append(root.val) 
                if not root.left and not root.right:
                    if cursum == targetSum:
                        result.append(list(path))
                helper(root.left, cursum, path)
                helper(root.right, cursum, path)
                path.pop()
        helper(root, 0, [])
        return result

# dont use path.append(root.val) or path+=[root.val] it functions as append, if u do then use path.pop() at the end of the function and when adding to the result use a new list as the path would be pased by reference and would be empty after popping
# Instead use path = path + [root.val] it automatically pops out the elements as it is creating a new path object at each stack level



        
    # Time/ Space complexity = O(n*h) as we are creating a new list at each node
        # def leafSum(root, cursum, path):
        #     nonlocal result
        #     if root:
        #         # logic
        #         cursum += root.val
        #         path = path + [root.val]

        #         if not root.left and not root.right:
        #             if cursum == targetSum:
        #                 result.append(path)

        #         leafSum(root.left, cursum, path)
        #         leafSum(root.right, cursum, path)

        # result = []
        # leafSum(root, 0, [])
        # return result
