// Time Complexity : O(n)
// Space Complexity :O(2h) -> O(h) height of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Need to compare the left subtree and right subtree. Use recursive approach to compare left and right subtree buy using two recursive call

class Solution {
    func isSymmetric(_ root: TreeNode?) -> Bool {
        return helper(root?.left, root?.right)
    }
    
    func helper(_ left: TreeNode?, _ right: TreeNode?) -> Bool {
        //base
        if left == nil && right == nil {
            return true
        }
        
        if left == nil || right == nil || left!.val != right!.val {
            return false
        }
        
        return helper(left?.left, right?.right) && helper(left?.right, right?.left)
    }
    
}

//Iterative approach


class Solution {
    func isSymmetric(_ root: TreeNode?) -> Bool {
        return isMirror(root)
    }
    
  func isMirror(_ root: TreeNode?) -> Bool {
      var stack: [TreeNode?] = [TreeNode?]()
      guard let rootNode = root, rootNode != nil else {
          return true
      }
      stack.append(rootNode.left)
      stack.append(rootNode.right)
      
      while !stack.isEmpty {
          let leftNode = stack.popLast()
          let rightNode = stack.popLast()
          if leftNode! == nil && rightNode! == nil {
              continue
          }

          guard let left = leftNode, let right = rightNode, left != nil && right != nil && left?.val == right?.val else {
             return false
          }
          stack.append(left?.left)
          stack.append(right?.right)
          stack.append(left?.right)
          stack.append(right?.left)
      }
      
      return true
  }

    
}