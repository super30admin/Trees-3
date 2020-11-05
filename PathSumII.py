#Recursive Solution


def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
    
    output = []
    def helper(node, curr, path):
        nonlocal output
        if node:
            curr+= node.val
            path.append(node.val)
            helper(node.left,curr,path.copy())
            helper(node.right, curr, path[:])
            if not node.left and not node.right:
                if curr == sum:
                    output.append(path)
            return output
    return helper(root, 0, [])

#Backtracking Solution
def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        output = []
        def helper(node, curr, path):
            nonlocal output
            if node:
                curr+= node.val
                path.append(node.val)
                helper(node.left,curr,path)
                helper(node.right, curr, path)
                if not node.left and not node.right:
                    if curr == sum:
                        output.append(path[:])
                path.pop()
                return output
        return helper(root, 0, [])
#Time: O(n)
#Space : O(n)