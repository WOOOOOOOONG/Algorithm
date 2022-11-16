package Learning.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    public static class Node {
        public Node(int data) {
            this.data = data;
        }

        public int data;
        public ArrayList<Node> children = new ArrayList<>();
    }

    public static void main(String[] args) {
        /*
        *     1
        *   2   3
        *  4 5 6 7
        *
        * */
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.children.add(n2);
        n1.children.add(n3);
        n2.children.add(n4);
        n2.children.add(n5);
        n3.children.add(n6);
        n3.children.add(n7);

        dfs(n1);
    }

    public static void dfs(Node node) {
        Stack<Node> stack = new Stack<>();

        stack.push(node);

        while(!stack.empty()) {
            Node pop = stack.pop();

            System.out.println(pop.data);

            for (Node next : pop.children) {
                stack.push(next);
            }
        }
    }

    public static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()) {
            Node pop = queue.remove();

            System.out.println(pop.data);

            for (Node next : pop.children) {
                queue.add(next);
            }
        }
    }
}
