# Time Complexity: O(N)
# Space Complexity: O(H) 
# Compiled on leetcode?: Yes

class Solution:
    def pathSum(self, root: TreeNode, target: int) -> List[List[int]]:
        paths = []
        if root is None:
            return paths
        stack = [(root, list())]

        while stack:
            currentNode = stack.pop()
            if currentNode[0].left is None and currentNode[0].right is None:
                listToAppend = list()
                listToAppend.extend(currentNode[1])
                listToAppend.append(currentNode[0].val)
                if sum(listToAppend) == target:
                    paths.append(listToAppend)
            if currentNode[0].left:
                listToAppend = list()
                listToAppend.extend(currentNode[1])
                listToAppend.append(currentNode[0].val)
                stack.append((currentNode[0].left, listToAppend))
            if currentNode[0].right:
                listToAppend = list()
                listToAppend.extend(currentNode[1])
                listToAppend.append(currentNode[0].val)
                stack.append((currentNode[0].right, listToAppend))
        return paths
