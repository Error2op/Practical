class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key

def inorder_traversal(root):
    if root:
        inorder_traversal(root.left)
        print(root.val, end=' ')
        inorder_traversal(root.right)

def postorder_traversal(root):
    if root:
        postorder_traversal(root.left)
        postorder_traversal(root.right)
        print(root.val, end=' ')

def preorder_traversal(root):
    if root:
        print(root.val, end=' ')
        preorder_traversal(root.left)
        preorder_traversal(root.right)
        
root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)


print("Preorder traversal:", end=' ')
preorder_traversal(root)

print("\nInorder traversal: ", end=' ')
inorder_traversal(root)

print("\nPostorder traversal:", end=' ')
postorder_traversal(root)
