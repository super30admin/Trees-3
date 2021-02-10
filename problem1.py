// Time Complexity : O(all leaf nodes)*n)
// Space Complexity : O(n(max depth)+(all leaf nodes)*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        output=[]   //global output list passed as a parameter to recursive function
        path=[]     //global path list used to store the paths is also passed as a parameter
        self.recurr(root,targetSum,0,output,path)
        return output
    
    def recurr(self,root,target,currsum,output,path):
        if not root:    //if root is null return
            return
        
        currsum+=root.val                 //add root value to currentsum
        #print("------------------")
        #print(currsum)
        path.append(root.val)           //append the current value in path list 
        #print(path)
        
        if (not root.left and not root.right):    //if root has no left and right child
            #print("no more nodes")
            if target==currsum:                 //if currsum is equal to target path list will be added to output list 
                temp=list(path)
                output.append(temp)       
                #print("output:"+str(output))
            path.pop()        //remove the last element from the path list
            #print(path)
            return
            
        #print("call again")    
        
        self.recurr(root.left,target,currsum,output,path) //traverse towards left of root node
        self.recurr(root.right,target,currsum,output,path)  //traverse towards right of root node
        
        path.pop() //remove the last element from the path list
