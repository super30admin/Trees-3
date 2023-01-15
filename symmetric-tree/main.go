package main

// Time : O(n) : n are the nodes in the tree and we are traversing all of them
// Space : O(w) : size of the queue would be width of the tree at any given moment
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return false
	}
	if root.Left == nil || root.Right == nil {
		if root.Left == nil && root.Right == nil {
			return true
		}
		return false
	}
	symTree := true
	q := []*TreeNode{root.Left, root.Right}

	for len(q) != 0 {
		qSize := len(q)
		for qSize != 0 {
			dq0 := q[0]
			dq1 := q[1]
			q = q[2:]

			if dq0.Val != dq1.Val {
				symTree = false
				break
			}

			if dq0.Left != nil {
				if dq1.Right == nil {
					symTree = false
					break
				}
				q = append(q, dq0.Left)
				q = append(q, dq1.Right)
			} else {
				if dq1.Right != nil {
					symTree = false
					break
				}
			}

			if dq0.Right != nil {
				if dq1.Left == nil {
					symTree = false
					break
				}
				q = append(q, dq0.Right)
				q = append(q, dq1.Left)
			} else {
				if dq1.Left != nil {
					symTree = false
					break
				}
			}

			qSize--
			qSize--
		}
	}

	return symTree
}
