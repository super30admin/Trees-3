
#Approach: Summing up path till we find leaf and backtrack to track current path
#as the pointer to list will be updating every time we will add final result into new array 
#Time Complexity O(N) for all N nodes
#Space Complexity O(H) height of tree, Because we are using list for path
#It successfully runs on the leetcode

class Solution:
    def pathSum(self, root: Optional[TreeNode], target: int) -> List[List[int]]:
        self.result=[]
        self.helper(root,target,0,[])
        return self.result
    
    def helper(self,root,target,cursum,path):
            if not root: return
            cursum+=root.val
            path.append(root.val)
            self.helper(root.left,target,cursum,(path))
            if root.left== None and root.right==None:
                if cursum==target:
                    self.result.append(list(path))
            self.helper(root.right,target,cursum,(path))
            path.pop()