#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        self.result=[]
        if root==None:
            return self.result
        self.helper(root,0,[],targetSum)
        return self.result

    def helper(self,node,currsum,path,target):
        if node==None:
            return 
        currsum+=node.val
        path.append(node.val)
        if currsum==target and node.left==None and node.right==None:
                self.result.append(path[:])
        self.helper(node.left, currsum, path, target)
        self.helper(node.right, currsum, path, target)
        path.pop()
