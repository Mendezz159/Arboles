/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arboles;

import java.util.Scanner;

/**
 *
 * @author HP PORTATIL
 */
public class Arboles {

    public static class Node {
        String data;
        Node left;
        Node right;

        public Node(String data) {
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

        public void IniciarInterfaz(){
            Scanner in = new Scanner(System.in);
            System.out.println("Nombra la tarea Base");
            System.out.print("-- ");
            
            root = new Node(in.nextLine());
            root = InterfazNodo(root,"");
        }
        
        private Node InterfazNodo(Node node,String Ruta){
            Scanner in = new Scanner(System.in);
            String ThisRuta;
            
            var i = true;
            System.out.println("--------------------------------------------------------------------------");
            while(i){
                ThisRuta = Ruta+"/"+node.data;
                System.out.println("Ruta: "+ThisRuta);
                System.out.println("\nTarea: "+node.data);
                
                if(!(node.right == null && node.left == null)){
                    System.out.println("Subtareas:");
                    if(!(node.right == null)){
                        System.out.println("\t- "+node.right.data);
                    }
                    if(!(node.left == null)){
                        System.out.println("\t- "+node.left.data);
                    }
                }
                
                System.out.println("\nSelecciona alguna de las opcciones ingresando un numero");
                System.out.println("1. Modificar Esta tarea");
                System.out.println("2. Ingresar a una subtarea");
                System.out.println("3. Volver a la macro tarea");
                if(node.right == null || node.left == null){
                    System.out.println("4. Añadir nueva subtarea");
                }
                System.out.print("-- ");
                int Selection = in.nextInt();
                System.out.println("\n");
                in.nextLine();
                switch(Selection){
                    case (1):
                        System.out.println("Ingresa el nuevo nombre de la tarea");
                        System.out.print("-- ");
                        node.data = in.nextLine();
                        break;
                    case (2):
                        if(node.right == null && node.left == null){
                            System.out.println("*No hay subtareas*");
                        }else{
                            int numerador = 1;
                            if(!(node.right == null)){
                                System.out.println(numerador+". "+node.right.data);
                                numerador++;
                            }
                            if(!(node.left == null)){
                                System.out.println(numerador+". "+node.left.data);
                            }
                            
                            System.out.println("-- ");
                            int Select = in.nextInt();
                            switch(Select){
                                case(1):
                                    node.right = InterfazNodo(node.right,ThisRuta);
                                    break;
                                case(2):
                                    if(numerador == 2){
                                        node.left = InterfazNodo(node.left,ThisRuta);
                                    }else{
                                        System.out.println("Valor No valido");
                                    }
                                    break;
                                default:
                                    System.out.println("Valor No valido");
                                    break;
                            }
                        }
                        break;
                    case (3):
                        i = false;
                        break;
                    case(4):
                        if(node.right == null || node.left == null){
                            System.out.println("Ingresa el nombre de la nueva tarea");
                            System.out.print("-- ");
                            String nombre = in.nextLine();
                            
                            if(!(node.right == null)){
                                node.left = new Node(nombre);
                            }else
                                node.right = new Node(nombre);
                        }else{
                            System.out.println("Valor No valido");
                        }
                        break;
                    default:
                        System.out.println("Valor No valido");
                        break;
                }
            }
            System.out.println("--------------------------------------------------------------------------");
            return node;
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
            binaryTree.IniciarInterfaz();

            System.out.println("Inorder traversal:");
            binaryTree.inorderTraversal();

            System.out.println("\nPreorder traversal:");
            binaryTree.preorderTraversal();

            System.out.println("\nPostorder traversal:");
            binaryTree.postorderTraversal();
        }
}
