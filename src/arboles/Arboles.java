/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

/**
 *
 * @author HP PORTATIL
 */
public class Arboles {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        public void insert(int data) {
            root = insertRecursive(root, data);
        }

        private Node insertRecursive(Node current, int data) {
            if (current == null) {
                return new Node(data);
            }
            if (data < current.data) {
                current.left = insertRecursive(current.left, data);
            } else if (data > current.data) {
                current.right = insertRecursive(current.right, data);
            }
            return current;
        }

        public void inorderTraversal() {
            inorderRecursive(root);
        }

        private void inorderRecursive(Node node) {
            if (node != null) {
                inorderRecursive(node.left);
                System.out.print(node.data + " ");
                inorderRecursive(node.right);
            }
        }

        public void preorderTraversal() {
            preorderRecursive(root);
        }

        private void preorderRecursive(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preorderRecursive(node.left);
                preorderRecursive(node.right);
            }
        }

        public void postorderTraversal() {
            postorderRecursive(root);
        }

        private void postorderRecursive(Node node) {
            if (node != null) {
                postorderRecursive(node.left);
                postorderRecursive(node.right);
                System.out.print(node.data + " ");
            }
        }
    }

    public static void main(String[] args) {
            BinaryTree binaryTree = new BinaryTree();
            binaryTree.insert(8);
            binaryTree.insert(3);
            binaryTree.insert(1);
            binaryTree.insert(6);
            binaryTree.insert(4);
            binaryTree.insert(7);
            binaryTree.insert(10);
            binaryTree.insert(14);
            binaryTree.insert(13);

            System.out.println("Inorder traversal:");
            binaryTree.inorderTraversal();

            System.out.println("\nPreorder traversal:");
            binaryTree.preorderTraversal();

            System.out.println("\nPostorder traversal:");
            binaryTree.postorderTraversal();
        }
}
