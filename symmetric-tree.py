# tc O(n), sc O(n).
queue = deque()
queue.append(root.left)
queue.append(root.right)

while queue:
    node1 = queue.popleft()
    node2 = queue.popleft()

    if not node1 and not node2:
        continue
    
    if not node1 or not node2:
        return False
    
    if node1.val != node2.val:
        return False
    
    queue.append(node1.left)
    queue.append(node2.right)
    queue.append(node1.right)
    queue.append(node2.left)

return True