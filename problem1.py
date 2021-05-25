class Solution:
    def __init__(self):
        self.finallist = [ ]
    def pathSum(self, root: TreeNode, targetSum: int, listl = [ ], suml = 0) -> List[List[int]]:
        if root == None:
            return
        suml = suml + root.val
        listl.append(root.val)
        if suml == targetSum and root.left==None and root.right==None:
            self.finallist.append(list(listl))
        self.pathSum(root.left,targetSum,listl,suml)
        self.pathSum(root.right,targetSum,listl,suml)
        listl.pop()
        return self.finallist  
