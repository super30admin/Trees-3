# TC: O(n)
# SC: O(h)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        
        path=[]
        result=[]
        count=0
        
        def helper(root, path, count):
            # base
            if root==None:
                return
            
            #logic
            path.append(root.val)
            count+=root.val
            
            if root.left == None and root.right== None:
                if count==targetSum:
                    result.append(path.copy())
                path.pop()
                return
            
            helper(root.left, path, count)
            helper(root.right, path, count)
            
            #backtrack
            path.pop()
            return

        helper(root, path, count)
        return result


