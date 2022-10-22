class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        #recursive solution
        def preorder(root,curr_sum, arr):
            nonlocal result
            #Passing the current sum, the current array to keep track of sum and the path
            
            if not root:
                return
            
            arr.append(root.val)
            curr_sum += root.val
            
            if not root.right and not root.left:
                if curr_sum == targetSum:
                    result.append(arr)
            
            # Passing .copy() because we want a new list at each node
            # Otherwise the reference will be the same in memory for the list and in the end it will return a list with all the nodes
            preorder(root.left, curr_sum, arr.copy())
            preorder(root.right, curr_sum, arr.copy())
            
            
        result = []
        preorder(root,0, [])
        return result
    
# Time Complexity: O(n^2) in the worst case because we have to copy the list at every node
# Space Complexity: O(n) if we don't consider the input and output array at each point