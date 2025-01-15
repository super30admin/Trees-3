# TC: O(n)
# SC: O(h)


def pathSum(root, targetSum):
    paths = []
    def helper(root, target, inter_path, paths):
        if not root: return

        inter_path.append(root.val)
        if target - root.val == 0 and not root.left and not root.right:
            # Leaf reached and target reach - add it to result array 
            # nonlocal paths 
            paths.append(list(inter_path))
        
        helper(root.left, target - root.val, inter_path, paths)
        helper(root.right, target - root.val, inter_path, paths)
        inter_path.pop()
    
    inter_path = []
    helper(root, targetSum, inter_path, paths)
    return paths

