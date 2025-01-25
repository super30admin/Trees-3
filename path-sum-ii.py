# tc O(n * log n), sc O(n * log n including recursive stack and output space).
def rec(node, sumn):
    if not node:
        return
    if not node.left and not node.right:
        if sumn + node.val == targetSum:
            path.append(node.val)
            res.append(path[:])
            path.pop()
        return
    
    path.append(node.val)
    rec(node.left, sumn + node.val)

    rec(node.right, sumn + node.val)
    path.pop()

res = []
path = []
rec(root, 0)
return res