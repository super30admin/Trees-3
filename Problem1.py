# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def pathSum(self, root, req_sum):
		# Have a queue to keep track of all the values visited till that node, node you are present at that time, sum till that node from the root
		res = []
		if root == None:
			return None
		queue = []
		queue.append((root, root.val, [root.val, ]))
		while len(queue) != 0:
			temp = queue[0]
			del queue[0]
			if temp[0].left == None and temp[0].right == None:
				if temp[1] == req_sum:
					res.append(temp[2])
			else:
				if temp[0].left != None:
					t1 = temp[2][:]
					t1.append(temp[0].left.val)
					queue.append((temp[0].left, temp[1] + temp[0].left.val, t1))
				if temp[0].right != None:
					t2 = temp[2][:]
					t2.append(temp[0].right.val)
					queue.append((temp[0].right, temp[1] + temp[0].right.val, t2))
		return res

	def pathSum(self, root, req_sum):
		# Have a queue to keep track of all the values visited till that node, node you are present at that time, sum till that node from the root
		res = []
		if root == None:
			return None
		queue = []
		queue.append((root, root.val, [root.val, ]))
		while len(queue) != 0:
			temp = queue.pop()
			if temp[0].left == None and temp[0].right == None:
				if temp[1] == req_sum:
					res.append(temp[2])
			else:
				if temp[0].left != None:
					t1 = temp[2][:]
					t1.append(temp[0].left.val)
					queue.append((temp[0].left, temp[1] + temp[0].left.val, t1))
				if temp[0].right != None:
					t2 = temp[2][:]
					t2.append(temp[0].right.val)
					queue.append((temp[0].right, temp[1] + temp[0].right.val, t2))
		return res