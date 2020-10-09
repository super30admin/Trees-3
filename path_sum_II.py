# O(N) TIME AND O(d) space where n is no.of nodes and d is space

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        paths= []
        self.findPaths(root,0,[],paths,sum)
        return paths
    
    def findPaths(self,node,running_sum,current_path,paths,sum):
        if node is None:
            return
        current_path.append(node.val)
        running_sum += node.val
        if node.left is None and node.right is None and running_sum == sum:
            paths.append(current_path[:])

        self.findPaths(node.left,running_sum,current_path,paths,sum)
        self.findPaths(node.right,running_sum,current_path,paths,sum)
        current_path.pop()
            
            


        