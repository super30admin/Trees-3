// Time Complexity : O(V+E)
// Space Complexity : O(no. of nodes)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        
        def recurr(root,path,ret,currSum): #do dfs
            if root is None:
                return 
            if root.left is None and root.right is None:
                print(root.val,path)
                if currSum+root.val==sum: #if current sum along with leaf is sum, then add to output
                    temp=path[:] #copy array to temp, so that previous path is not modified
                    
                    temp.append(root.val)
                    ret.append(temp) #final ouput
                return
            path.append(root.val)
            recurr(root.left,path,ret,currSum+root.val) #add current sum along with root.val for left subtree
            recurr(root.right,path,ret,currSum+root.val) #add current sum along with root.val for left subtree
            path.pop()
        
        ret=[]
        path=[]
        recurr(root,path,ret,0)
        return ret #return final output
            
            