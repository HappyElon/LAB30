package ru.mirea.goncharov.part2.task1;

public class BinarySearchTree {
    static TreeNode root;

    public static void main(String[] args) {
        createBinarySearchTree();

        System.out.println("Содержимое дерева до удаления:");
        printInOrder(root);

        int nodeToDelete = 6;
        deleteNode(nodeToDelete);

        System.out.println("\nСодержимое дерева после удаления узла " + nodeToDelete + ":");
        printInOrder(root);

        root = null;
        System.out.println("\nДерево полностью удалено.");
    }

    static void createBinarySearchTree() {
        root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(15);
    }

    static void deleteNode(int key) {
        root = deleteNode(root, key);
    }

    static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.val = minValue(root.right);

            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    static int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }

    static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
        }
    }
}

