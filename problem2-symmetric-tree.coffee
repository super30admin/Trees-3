# https://leetcode.com/problems/symmetric-tree/
# runtime: O(n) n is number of elements
# space: O(maxdepth of tree) which is the stack size
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# none pretty straightforward
#
#// Your code here along with comments explaining your approach
#
# recurse left and right at each step, compare values at that step
#   if both null return true
#   if only 1 is null return false
#   if values aren't equal return false
#   else recurse left, right

treeNode = (val, left = null, right = null) -> Object.assign(
  Object.create(treeNode::),
  val: val
  left: left
  right: right
)

isSymmetric = (root) ->
  recurse = (p1left, p2right) ->
    return true if p1left is null and p2right is null

    return false if p1left is null or p2right is null or p1left.val isnt p2right.val

    recurse(p1left.left, p2right.right) and recurse(p1left.right, p2right.left)

  return true if root is null
  recurse(root.left, root.right)

isSymmetric(treeNode(1,
  treeNode(2, treeNode(3), treeNode(4)),
  treeNode(2, treeNode(4), treeNode(3))))
