class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pathSum(self, root, targetSum):
        if not root:
            return []
        # dfs function to find path from root to leaf
        def dfs(root,path):
            # to check if node is leaf
            if not root.left and not root.right:
                # if leaf then check if path sum matches target sum
                if targetSum==sum(path+[root.val]):
                    # if yes then add path to result array
                    return res.append(path+[root.val])
            # recursively cal for left and right nodes till leaf node
            if root.left:
                dfs(root.left,path+[root.val])
            if root.right:
                dfs(root.right,path+[root.val])
        # create a result array
        res=[]
        # call the function for root
        dfs(root,[])
        return res
        
if __name__ == "__main__":
    s = Solution()
    root = [5,4,8,11,None,13,4,7,2,None,None,5,1]
    targetSum = 22
    print(s.pathSum(root, targetSum))