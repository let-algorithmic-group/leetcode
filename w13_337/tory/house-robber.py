class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def rob(self, root: TreeNode) -> int:
        return max(self.getRob(root))

    def getRob(self, root: TreeNode) -> List[int]:
        if not root:
            return [0, 0]
        l = self.getRob(root.left)
        r = self.getRob(root.right)
        return [max(l) + max(r), root.val + l[0] + r[0]]