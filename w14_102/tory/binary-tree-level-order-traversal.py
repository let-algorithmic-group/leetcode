class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        arr = []
        if not root:
            return arr

        def toDoSomeThing(root: TreeNode, heigh: int):
            if len(arr) == heigh:
                arr.append([])
            arr[heigh].append(root.val)
            if root.left:
                toDoSomeThing(root.left, heigh + 1)
            if root.right:
                toDoSomeThing(root.right, heigh + 1)

        toDoSomeThing(root, 0)
        return arr