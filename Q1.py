############# Path sum II

# Time Complexity :  O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# perform bfs and keep track of the current sum and the path

def path_sum(root,targetSum):
        if not root:
            return []
        
        result = []
        queue = [(root,root.val,[root.val])]
        while queue:
            node, curr_sum, path = queue.pop(0)
            if node.left:
                queue.append((node.left,curr_sum+node.left.val,path+[node.left.val]))
            if node.right:
                queue.append((node.right,curr_sum+node.right.val,path+[node.right.val]))
            if not node.left and not node.right:
                if curr_sum == targetSum:
                    result.append(path)
        return result
