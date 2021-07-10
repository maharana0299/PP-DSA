import java.io.*;
import java.util.*;

public class Diametre {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int helperDia(Node node) {

        int bcht = -1;
        int sbcht = -1;

        for (Node child : node.children) {

            int cht = helperDia(child);
            if (cht > bcht) {
                sbcht = bcht;
                bcht = cht;
            } else if (cht > sbcht) {
                sbcht = cht;
            }
        }

        dia = Math.max(dia, bcht + sbcht + 2);
        return bcht + 1;
    }

    static int dia;

    public static int findDiametre(Node node) {

        dia = 0;

        helperDia(node);

        return dia;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);

        int d = findDiametre(root);
        System.out.println(d);
    }

}