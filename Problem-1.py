 class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:

        result=[]

        self.findPath(root,sum,[],result)
        return result

    def findPath(self,node,reqSum,path,result):
        if node is None:
            return
        path.append(node.val)

        if node.val == reqSum and node.left is None and node.right is None:
            result.append(list(path))


        else:
            self.findPath(node.left,reqSum-node.val,path,result)

            self.findPath(node.right,reqSum-node.val,path,result)

        del path[-1]
