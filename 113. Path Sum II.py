#can use deep copy library


# optimized --> backtracking
# TC - O(n)
# SC - O(n)

class Solution:   
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def helper(root, curSum, targetSum):
            #base
            if not root:
                return []
            #logic
            curSum += root.val
            #action
            path.append(root.val)
            if root.left is None and root.right is None and curSum == targetSum:
                res.append([*path])
            #recurse
            helper(root.left, curSum, targetSum)
            helper(root.right, curSum, targetSum)
            #backtrack
            path.pop()

        res = []
        path = []
        helper(root, 0, targetSum)
        return res
    
# optimized --> backtracking
# TC - O(n)
# SC - O(n)

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def helper(root, temp, currentSum, targetSum):
            if root.left is None and root.right is None and currentSum == targetSum:
                final.append(temp)
            if root.left is not None:
                helper(root.left, temp + [root.left.val], currentSum + root.left.val, targetSum)
            if root.right is not None:
                helper(root.right, temp + [root.right.val], currentSum + root.right.val, targetSum)
        
        if not root:
            return []
        final = []
        helper(root, [root.val], root.val, targetSum)
        return final
    

# brute force
# TC - O(n^2)
# SC - O(n^2)

class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:    
        def helper(root,curSum,path,target):
            #base
            if root == None:
                return []

            #logic
            curSum += root.val
            #temp += path 
            if root.left == None and root.right == None:
                if curSum == target:
                    #print(path)
                    res.append([*path,root.val])
            path.append(root.val)

            helper(root.left,curSum,path,target)
            helper(root.right,curSum,path,target)
            curSum -= root.val
            path.pop()
        res = []
        path = []
        helper(root,0,[],targetSum)
        return res   