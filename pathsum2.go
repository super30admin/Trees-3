// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if root is nil return empty
or recursively call root, address of result, path array, sum

in recursive function
if node is leaf and sum == r.val append node to path and append path to result return
if node.Left exists recursively call(left, res, copy of path, sum-nodeval)
if node.Right exists recursively call(right, res, copy of path, sum-nodeval)
return
*/
package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}
func pathSum(root *TreeNode, sum int) [][]int {
	res := [][]int{}
	if root == nil {
		return res
	}
	h(root, &res, []int {}, sum)
	return res
}

func h(r *TreeNode, res *[][]int, path []int, sum int) {
	if r.Left == nil && r.Right == nil {
		if sum == r.Val {
			*res = append(*res, append(path, r.Val))
		}
		return
	}

	if r.Left != nil {
		h(r.Left, res, append(append([]int{}, path...), r.Val), sum - r.Val)
	}
	if r.Right != nil {
		h(r.Right, res, append(append([]int{}, path...), r.Val), sum - r.Val)
	}
}

func MainPath2Sum() {
	left := &TreeNode{Val: 4}
	right := &TreeNode{Val: 8}
	root := &TreeNode{Val: 5, Left: left, Right: right}
	fmt.Println(pathSum(root, 9)) //expected [[5,4]]
}
