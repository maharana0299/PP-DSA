import java.io.*;
import java.util.*;

public class Tree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {
        };

        Node(int data) {
            this.data = -1;
        }
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

    public static int size(Node node) {
        int ts = 0;

        for (int i = 0; i < node.children.size(); i++) {
            Node child = node.children.get(i);
            int cfs = size(child);
            ts += cfs;
        }
        return ts + 1;
    }

    public static int height(Node node) {

        int ht = 0;

        for (Node child : node.children) {
            int ch = height(child);

            if (ch > ht) {
                ht = ch;
            }
        }
        return node.children.size() == 0 ? ht : ht + 1;
    }

    public static void traversals(Node node) {

        System.out.println("Node Pre " + node.data);

        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);

    }

    public static int max(Node node) {

        int omax = node.data;

        for (Node child : node.children) {
            int cm = max(child);

            if (cm > omax) {
                omax = cm;
            }
        }

        return omax;
    }

    public static void levelOrder(Node node) {

        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();

        q.offer(node);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node rm = q.poll();
                sb.append(rm.data + " ");

                for (Node c : rm.children) {
                    q.offer(c);
                }
            }

        }
        sb.append(".");
        System.out.println(sb.toString());
    }

    public static void levelOrder2(Node node) {

        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        mq.add(node);

        while (mq.size() > 0) {

            Node rem = mq.remove();

            sb.append(rem.data + " ");
            for (Node child : rem.children) {
                cq.add(child);
            }

            if (mq.isEmpty()) {

                sb.append("\n");
                mq = cq;
                cq = new ArrayDeque<>();
            }
        }

        System.out.println(sb.toString());

    }

    public static void levelOrder3(Node node) {

        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1));

        while (!q.isEmpty()) {

            Node rem = q.poll();

            if (rem.data == -1) {
                System.out.println();

                if (q.size() == 0) {
                    break;
                }

                q.add(rem);
                continue;
            }

            System.out.print(rem.data + " ");

            for (Node child : rem.children) {
                q.offer(child);
            }
        }
    }

    // LinearZigzag
    public static void levelOrderLinewiseZZ(Node node) {

        Stack<Node> st = new Stack<>();
        Stack<Node> cst = new Stack<>();
        st.push(node);
        int level = 0;

        // if 0 -> left to right
        // if 1 -> right to left
        while (!st.isEmpty()) {

            Node rm = st.pop();

            System.out.print(rm.data + " ");

            if (level == 0) {
                for (Node child : rm.children) {
                    cst.add(child);
                }
            } else {
                for (int i = rm.children.size() - 1; i >= 0; i--) {
                    cst.add(rm.children.get(i));
                }
            }

            if (st.isEmpty()) {

                level = (level + 1) % 2;
                System.out.println();
                st = cst;
                cst = new Stack<>();
            }
        }
    }

    public static void mirror(Node node) {

        for (Node child : node.children) {
            mirror(child);
        }

        int n = node.children.size();
        for (int i = 0; i < node.children.size() / 2; i++) {

            Node lo = node.children.get(i);
            Node hi = node.children.get(n - i - 1);

            node.children.set(i, hi);
            node.children.set(n - i - 1, lo);
        }
    }

    public static void removeLeaves(Node node) {

        for (int i = node.children.size() - 1; i >= 0; i--) {

            if (node.children.get(i).children.size() == 0) {
                node.children.remove(i);
            }
        }

        for (Node c : node.children) {
            removeLeaves(c);
        }
    }

    public static void linearize(Node node) {

        for (Node child : node.children) {
            linearize(child);
        }

        while (node.children.size() > 1) {
            Node l = node.children.remove(node.children.size() - 1);
            Node sl = node.children.get(node.children.size() - 1);
            Node tl = getTail(sl);
            tl.children.add(l);
        }
    }

    public static Node getTail(Node node) {
        if (node.children.size() == 0)
            return node;

        return getTail(node.children.get(0));
    }

    // linearize -> faith (linearize and return tail as well)
    public static void linearizeEff(Node node) {
        // write your code here
        linearize_helper(node);
    }

    public static Node linearize_helper(Node node) {
        if (node.children.size() == 0) {
            return node;
        }

        Node lc = node.children.get(node.children.size() - 1);
        Node otail = linearize_helper(lc); // overall tail

        while (node.children.size() > 1) {
            Node slc = node.children.get(node.children.size() - 2);
            Node slct = linearize_helper(slc);

            // connections
            node.children.remove(node.children.size() - 1);
            slct.children.add(lc);

            lc = slc;
        }

        return otail;
    }

    public static boolean find(Node node, int data) {

        if (node.data == data) {
            return true;
        }

        for (Node child : node.children) {
            if (find(child, data))
                return true;
        }
        return false;
    }

    // Method 1
    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {

        ArrayList<Integer> ls = new ArrayList<>();

        ntrphelper(node, data, ls);
        return ls;
    }

    private static void ntrphelper(Node node, int data, ArrayList<Integer> ls) {

        if (node.data == data) {
            ls.add(node.data);
            return;
        }

        if (ls.size() > 0) {
            ls.add(node.data);
        }

        for (Node c : node.children) {
            ntrphelper(c, data, ls);
            if (ls.size() > 0) {
                ls.add(node.data);
                return;
            }
        }
    }

    public static ArrayList<Integer> nodeToRootPath2(Node node, int data) {
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath2(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> pt1 = nodeToRootPath(node, d1);
        ArrayList<Integer> pt2 = nodeToRootPath(node, d2);

        int i = pt1.size() - 1;
        int j = pt2.size() - 1;

        while (i >= 0 && j >= 0) {
            if (pt1.get(i) != pt2.get(j)) {
                return pt1.get(i + 1);
            }
            i--;
            j--;
        }

        return pt1.get(i + 1);
    }

    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }

        return i + j + 2;
    }

    public static boolean areSimilar(Node n1, Node n2) {

        if (n1.children.size() != n2.children.size()) {
            return false;
        }

        for (int i = 0; i < n1.children.size(); i++) {
            if (!areSimilar(n1.children.get(i), n2.children.get(i)))
                return false;
        }

        return true;
    }

    public static boolean areMirror(Node n1, Node n2) {
      
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        
        int size = n1.children.size();
        
        for(int i = 0; i < size; i++){
            
            if(!areMirror(n1.children.get(i),n2.children.get(size-i-1)))
              return false;
        }
        
        return true;
    }
  
    public static boolean IsSymmetric(Node node) {
      
        int size = node.children.size();
        
        for(int i = 0; i < size/2; i++ ){
            if(!areMirror(node.children.get(i),node.children.get(size-i-1))){
                return false;
            }
        }
        
        return true;
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
        int sz = size(root);
        System.out.println(sz);
        // display(root);
    }

}