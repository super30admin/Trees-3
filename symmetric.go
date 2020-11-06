// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if root is nil return true
or recursively call root.left, root.right

in recursive function
if node is leaf return true
if either left or right is nil or value of left and right are not same return false
return recursive(l.Left, r.Right) && recursive(l.Right, r.Left)
*/
package main

import "fmt"

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return h1(root.Left, root.Right)
}

func h1(l, r *TreeNode) bool {
	if r == nil && l == nil {
		return true
	}
	if r == nil || l == nil || r.Val !=l.Val {
		return false
	}
	return h1(l.Left, r.Right) && h1(l.Right, r.Left)
}

func MainSymmetric() {
	root := &TreeNode{
		Val:1,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{Val:3},
			Right: &TreeNode{Val:4},
		},
		Right: &TreeNode{
			Val: 2,
			Left: &TreeNode{Val:4},
			Right: &TreeNode{Val:3},
		},
	}

	fmt.Println(isSymmetric(root))
}
