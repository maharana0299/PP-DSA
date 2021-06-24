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

    public void reverseDI() {

        Node tl = head;
        Node n = head;
        Node p = null;
        Node nxt = null;
        while (n != null) {
            nxt = n.next;
            n.next = p;
            p = n;
            n = nxt;
        }

        head = p;
        tail = tl;
    }

    private class Node {
        int data;
        Node next;
    }
}
