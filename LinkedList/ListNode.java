public class ListNode {

    Node head;
    Node tail;
    int size;

    void addLast(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = null;

        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }

        size++;
    }

    public int size() {
        return size;
    }

    public void display() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    public int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
    }

    public int getLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return tail.data;
    }

    public int getAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else if (idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
        } else if (idx == 0) {
            return getFirst();
        } else if (idx == size - 1) {
            return getLast();
        }

        Node t = head;
        for (int i = 0; i < idx; i++) {
            t = t.next;
        }
        return t.data;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            size--;
            head = null;
            tail = null;
        } else {
            Node t = head;
            while (t.next.next != null) {
                t = t.next;
            }

            t.next = null;
            tail = t;
            size--;
        }
    }

    private Node getNode(int i) {
        Node t = head;
        while (i-- > 0) {
            t = t.next;
        }
        return t;
    }

    public void removeAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return;
        }

        if (idx == 0) {
            removeFirst();
            return;
        } else if (idx == size - 1) {
            removeLast();
            return;
        }
        Node n = getNode(idx - 1);
        n.next = n.next.next;
        size--;
    }

    // reverse data iterative
    public void reverseDI() {
        int li = 0;
        int ri = size - 1;

        Node ln = head;

        while (li < ri) {
            Node rn = getNode(ri);

            // swap data of left node and right node
            int temp = ln.data;
            ln.data = rn.data;
            rn.data = temp;

            ln = ln.next;
            li++;
            ri--;
        }
    }

    // reverse pointer iterative
    public void reversePI() {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            // backup
            Node next = curr.next;
            // reverse link
            curr.next = prev;
            // move
            prev = curr;
            curr = next;
        }

        // swap head,tail
        Node temp = head;
        head = tail;
        tail = temp;
    }

    public void reverseDR() {
        reverseDR(head, 1);
    }

    private Node reverseDR(Node hi, int lev) {

        if (hi == null) {
            return head;
        }
        Node lo = reverseDR(hi.next, lev + 1);

        if (lev > size / 2) {
            // swap
            int temp = lo.data;
            lo.data = hi.data;
            hi.data = temp;
        }

        return lo.next;
    }

    private void reversePRHelper(Node node) {
        if (node == tail) {
            return;
        }
        reversePRHelper(node.next);
        node.next.next = node;
    }

    public void reversePR() {

        reversePRHelper(head);
        head.next = null;
        Node t = head;
        head = tail;
        tail = t;
    }

    public int mid() {

        if (size() == 0) {
            return -1;
        }
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    private class Node {
        int data;
        Node next;
    }
}
