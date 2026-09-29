'''
101 Symmetric Tree
https://leetcode.com/problems/symmetric-tree/description/

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?

Let N = number of nodes, H = height of tree

Solution:
1. Recursion and stack: Traverse the left subtree using inorder traversal. For each node encountered during traversal of left subtree, push element into  a stack. Now, traverse the right subtree using inorder traversal. For each node encountered during traversal, pop element from stack and compare if the node value is equal to the popped element. If not equal, then it is not symmetric.
Space is O(N+H) because stack stores N/2 elements and there are H recursive calls which creates a stack of size H to maintain recursion states.
Time: O(N), Space: O(N + H) = O(N)

2. Recusrion w/o stack: For a given root node, recursively check if the left subtree and right subtree are symmetrical.
                    1
            2               2
        3       4       4       3

The check is performed on the two pairs of children:
a) left.left child == right.right child
b) left.right child == right.left child

Base case: If both left and right subtrees are empty, return True
           If either left or right subtrees are empty, return False
           If both left and right subtree exist but the left root val does not match with right root val, return False
https://youtu.be/m-nRJLGD96k?t=259
Time: O(N), Space: O(H) (space is due to recursion stack)


3. Iterative using queue: Perform a level order traversal. For each level, check if the node values satify the palindrome property.
https://youtu.be/m-nRJLGD96k?t=1713
Time: O(N), Space: O(D) (D = diameter of the tree)
'''
from binary_tree import *

def inorder_push(root, stack):
    if not root:
        return
    inorder_push(root.left, stack)
    stack.append(root.val)
    inorder_push(root.right, stack)
    return


def inorder_pop(root, stack):
    if not root:
        return True

    soln = 2
    # Either solution works - #1 is more
    # descriptive, #2 is more compact

    if soln == 1:
        flag = inorder_pop(root.left, stack)

        if flag == True:
            flag = (stack.pop() == root.val)
        else:
            return False

        if flag == True:
            flag = inorder_pop(root.right, stack)
        else:
            return False
        return True
    elif soln == 2:
        return inorder_pop(root.left, stack) and \
               (stack.pop() == root.val) and \
               inorder_pop(root.right, stack)


def is_symmetric_v1(root):
    '''T: O(N), S: O(N) '''
    if not root:
        return True
    elif not root.left and root.right:
        return False
    elif root.left and not root.right:
        return False

    # At this stage, both left sub-tree and right
    # sub-tree exist
    stack = []
    inorder_push(root.left, stack)
    flag = inorder_pop(root.right, stack)
    return flag


def is_symmetric_v2(root):
    ''' T: O(N), S: O(H) '''
    def dfs(left, right):
        if not left and not right: # no left and right subtree
            return True
        if not left or not right:
            return False
        if left.val != right.val:
            return False
        case1 = dfs(left.left, right.right)
        case2 = dfs(left.right, right.left)
        return case1 and case2
    if not root:
        return True
    return dfs(root.left, root.right)


def is_symmetric_v3(root):
    ''' T: O(N), S: O(Diameter) '''
    if not root:
        return True
    q = deque()
    q.append(root.left)
    q.append(root.right)
    while q:
        left = q.popleft()
        right = q.popleft()
        if not left and not right: # both None
            continue
        if not left or not right: # one of them is None
            return False
        # At this point, both left and right are not None
        if left.val != right.val:
            return False
        q.append(left.left)
        q.append(right.right)
        q.append(left.right)
        q.append(right.left)
    return True

def is_symmetric(root, method=2):
    if method == 1:
        is_sym = is_symmetric_v1(root)
    elif method == 2:
        is_sym = is_symmetric_v2(root)
    elif method == 3:
        is_sym = is_symmetric_v3(root)
    return is_sym

def run_tests():
    tests = [([1,2,2,3,4,4,3], True),
             ([1,2,2,None,3,None,3], False),
             ([1,2], False),
             ([1,2,3], False),
             ([1, None, 2], False),
             ([1], True),
             ([], True)
    ]
    for test in tests:
        root, ans = test[0], test[1]
        tree=build_tree_level_order(root)
        if tree: tree.display()
        print(f"root={root}")
        for method in [1,2,3]:
            res = is_symmetric(tree, method)
            print(f"Method {method}: symmetric tree = {res}")
            passed = (ans == res)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")

run_tests()