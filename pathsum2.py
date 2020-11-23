# Recursive solution -- backtrack
# Time complexity - O(n^2) # O(n) for traversing a tree and O(n) for copying the nodes to the tree
# Space complexity - O(h)
# did this solution run on leetcode? - yes
class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.all_paths = []
        
        def backtrack(node: TreeNode, path: List[int], nodeSum: int) -> None:
            if not node:
                return 
            
            # append to the path
            path.append(node.val)
            
            # add the current node value to the current path sum
            nodeSum += node.val
            
            # append the current path to all paths.
            if nodeSum == sum and not node.left and not node.right:
                print(path)
                self.all_paths.append(list(path))
            else:
                backtrack(node.left, path, nodeSum)
                backtrack(node.right, path, nodeSum)
            
            # backtrack to the previous node
            path.pop()
            
        backtrack(root, [], 0)
        return self.all_paths
        