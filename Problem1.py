# Time Complexity : O(n2) 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Node:
    def __init__(self,x):
        self.val = x 
        self.left = None 
        self.right = None 

class Solution:
    def pathSum(self,root,target):
        if not root:
            return []
        result = []
        return self.helper(root,target,0,[],result)
    
    def helper(self,root,target,currSum,path,result):
        # Base case 
        if not root:
            return 
        # Logic 
        currSum += root.val 
        path.append(root.val)
        if not root.left and not root.right: # Leaf Node 
            if currSum == target:
                result.append(path[:])
        self.helper(root.left,target,currSum,path,result)
        self.helper(root.right,target,currSum,path,result)
        
        # BackTracking 
        path.pop()
        return result
            

if __name__ == "__main__":
    s = Solution()
    n = Node(5)
    n.left = Node(4)
    n.right = Node(8)
    n.left.left = Node(11)
    n.left.left.left = Node(7)
    n.left.left.right = Node(2)
    n.right.left = Node(13)
    n.right.right = Node(4)
    n.right.right.left = Node(5)
    n.right.right.right = Node(1)
    res = s.pathSum(n,22)
    print(res)

    