class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root is None:
            return None
        self.invertTree(root.left)
        self.invertTree(root.right)
        left = root.left
        right = root.right
        root.right = left
        root.left = right
        return root
