#113-PathSum II
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result = []
        
        def helper(root, path, sums):
            sums += root.val
            temp = path + [root.val]
    
            if root.left:
                helper(root.left, temp, sums)
            if root.right:
                helper(root.right, temp, sums)
            if root.left == None and root.right == None:
                if sums == targetSum:
                    self.result.append(temp)
                
        if root == None: return self.result        
        helper(root, [], 0)
        return self.result
    
# T.C=>O(n)
# S.C=>O(n) => Recursion uses Stack in baground
# Approach=> If there is root left or right just call the helper function and add the root val and alsi append the path in it. If the sum is equal targetSum then just append that temp path.
# Recurse the solution continuouslt till all the leaf node are explored