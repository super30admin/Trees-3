"""
Use a helper to compare two nodes.
Check if their values match, and their subtrees are mirrors.
Apply recursion: left with right, and right with left.
"""
"""
Time Complexity: O(N) — All nodes visited once
Space Complexity: O(H) — Height of the tree (recursion stack)
"""


from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class symmetricTree:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        def isMirror(r1, r2):
            if not r1 and not r2:
                return True
            if not r1 or not r2:
                return False
            return (r1.val == r2.val and 
                    isMirror(r1.left, r2.right) and 
                    isMirror(r1.right, r2.left))
        
        return isMirror(root.left, root.right) if root else True


if __name__ == "__main__":
    
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(4)
    root.right.right = TreeNode(3)

    obj = symmetricTree()
    print(obj.isSymmetric(root))  
