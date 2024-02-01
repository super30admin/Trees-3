# Time Complexity: O(N)
# Space Complexity: O(N)
class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
      # level order traversal
      # for each level:
      # check if lenth is even / check if symmetric using 2 pointer
      
     
      q = collections.deque()
      q.append((root, 0))
      levels = []
      while q:
        n, level = q.popleft()
        node = n.val if n else None
        if len(levels) <= level:
          levels.append([node])
        else:
          levels[level].append(node)
        if n:
          q.append((n.left, level + 1))
          q.append((n.right, level + 1))
      for i in range(1, len(levels)):
        nodes = levels[i]
        if len(nodes) % 2 != 0:
          return False
        i, j = 0, len(nodes) - 1
        while i <= j:
          if nodes[i] != nodes[j]:
            return False
          i += 1
          j -= 1
      
      return True

      # Time Complexity: O(N)
      # def check(a, b):
      #   if not a and not b:
      #     return True
      #   if (not a and b) or (not b and a):
      #     return False
        
      #   return a.val == b.val and \
      #     check(a.left, b.right) and \
      #     check(a.right, b.left)
      
      # return check(root.left, root.right)
        

