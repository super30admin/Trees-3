def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
    self.result=[]
    self.helper(root,targetSum,0,[])
    return self.result

def helper(self, root, targetSum,curr,path):
    if root is None:
        return
    curr+=root.val
    path.append(root.val)
    if root.left is None and root.right is None:
        if curr==targetSum:
            self.result.append(list(path))
    self.helper(root.left, targetSum,curr,path)
    self.helper(root.right, targetSum,curr,path)

    path.pop()