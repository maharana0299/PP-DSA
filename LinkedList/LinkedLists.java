class LinkedLists {

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

    public void addFirst(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = head;
        head = temp;
  
        if (size == 0) {
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

    public static LinkedLists mergeTwoSortedLists(LinkedLists l1, LinkedLists l2) {
        LinkedLists ml = new LinkedLists();

        Node one = l1.head;
        Node two = l2.head;
        while (one != null && two != null) {
            if (one.data < two.data) {
                ml.addLast(one.data);
                one = one.next;
            } else {
                ml.addLast(two.data);
                two = two.next;
            }
        }

        while (one != null) {
            ml.addLast(one.data);
            one = one.next;
        }

        while (two != null) {
            ml.addLast(two.data);
            two = two.next;
        }

        return ml;
    }

    private static Node midNode(Node head, Node tail) {
        Node slow = head;
        Node fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static LinkedLists mergeSort(Node head, Node tail) {
        if (head == tail) {
            LinkedLists br = new LinkedLists();
            br.addLast(head.data);
            return br;
        }

        Node mid = midNode(head, tail);

        LinkedLists left = mergeSort(head, mid);
        LinkedLists right = mergeSort(mid.next, tail);

        LinkedLists mslist = mergeTwoSortedLists(left, right);

        return mslist;
    }

    public int kthFromLast(int k){
        
        Node slow = head;
        Node fast = head;
        
        while(k-->0 && fast != null){
            fast = fast.next;
        }
        
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow.data;
    }

    public void removeDuplicates(){
        
        LinkedLists ans = new LinkedLists();
        
        while(this.size()>0){
            
            int data = this.head.data;
            this.removeFirst();
            
            if(ans.size == 0 || ans.tail.data != data){
                ans.addLast(data);
            }
        }
        
        this.head = ans.head;
        this.tail = ans.tail;
        this.size = ans.size;
    }

    public void oddEven(){
        
        LinkedLists ol = new LinkedLists();
        LinkedLists el = new LinkedLists();
        
        while(size > 0) {
            int data = this.head.data;
            removeFirst();
            
            if(data % 2 == 0){
                el.addLast(data);
            } else {
                ol.addLast(data);
            }
        }
        
        if(ol.size != 0 && el.size != 0) {
            this.head = ol.head;
            ol.tail.next = el.head;
            this.tail = el.tail;
        } else if(ol.size != 0) {
            this.head = ol.head;
            this.tail = ol.tail;
        } else if(el.size != 0) {
            this.head = el.head;
            this.tail = el.tail;
        }
        
        this.size = ol.size + el.size;
    }

    public void kReverse(int k) {
        LinkedLists ans = new LinkedLists();

        if (k > this.size) {
            return;
        }

        while (this.size >= k) {
            //reverse k nodes
            LinkedLists curr = new LinkedLists();

            for (int i = 0; i < k; i++) {
                int val = this.getFirst();
                // remove
                this.removeFirst();

                // add 
                curr.addFirst(val); // basically reversing 
            }

            if (ans.size == 0) {
                // if empty
                ans = curr;
            } else {
                // else update tail and size
                ans.tail.next = curr.head;
                ans.tail = curr.tail;
                ans.size += curr.size;
            }
        }

        //settle remaining nodes in this
        if (this.size > 0) {
            ans.tail.next = this.head;
            ans.tail = this.tail;
            ans.size += this.size;
        }

        this.head = ans.head;
        this.tail = ans.tail;
        this.size = ans.size;
    }

    // fold with recursion
    Node lo;
    public void fold() {
        
        lo = this.head;
        foldHelper(head,1);
    }
    
    public void foldHelper(Node hi, int lev){
        
        if(hi == null){
            return;
        }
        foldHelper(hi.next,lev+1);
        
        // manage this condition
        int factor = size/2 + 1; // calculating the middle's next
        if(lev > factor){
            
            Node lon = lo.next;
            lo.next = hi;
            hi.next = lon;
            lo = lon;
        } else if( lev == factor){
            // set tail
            hi.next = null;
            this.tail = hi;
        }
    }


     // this is method 1
     public static LinkedLists addTwoListsWithReversing(LinkedLists one, LinkedLists two) {
      
        LinkedLists add = new LinkedLists();
        
        Node heada = reverseLinkedList(one.head);
        Node headb = reverseLinkedList(two.head);
        
        Node a = heada;
        Node b = headb;
        // add two 
        int c = 0;
        while(a != null || b != null) {
            
            int x = a != null ? a.data : 0;
            int y = b != null ? b.data : 0;
            
            int sum = x + y + c;
            c = sum/10;
            
            add.addFirst(sum%10);
            
            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }
        
        if(c != 0){
            add.addFirst(c);
        }
        
        reverseLinkedList(heada);
        reverseLinkedList(headb);
        return add;
      }
      
      public static Node reverseLinkedList(Node head){
          
          Node prev = null;
          Node curr = head;
          
          while(curr != null){
              Node next = curr.next;
              
              curr.next = prev;
              prev = curr;
              curr = next;
          }
          curr = prev;
          return curr;
      }
    }


    // method 2 with recursion and place values
    public static LinkedLists addTwoLists(LinkedLists one, LinkedLists two) {
        
        LinkedLists ls = new LinkedLists();
        
        int c = addTwoLists(one.head,two.head,one.size,two.size,ls);
        
        if(c != 0) {
            ls.addFirst(c);
        }
        
        return ls;
    }
    
    // p -> placevalue
    static int addTwoLists(Node h1, Node h2,int p1, int p2, LinkedLists ls){
        
        if(p1 == 0 && p2 == 0) {
            return 0;
        }
        
        int sum = 0;
        if(p1 > p2){
            int c = addTwoLists(h1.next,h2,p1-1,p2,ls);
            sum = c + h1.data;
        } else if(p1 < p2){
            int c = addTwoLists(h1,h2.next,p1,p2-1,ls);
            sum = c + h2.data;
        } else {
            int c = addTwoLists(h1.next,h2.next,p1-1,p2-1,ls);
            sum = h1.data + h2.data + c;
        }
            
        ls.addFirst(sum%10);
        return sum/10;
    }


    public static int findIntersection(LinkedLists one, LinkedLists two) {
        Node head1 = one.head;
        Node head2 = two.head;

        int gap = Math.abs(one.size - two.size);

        //cover extra gap
        if (one.size > two.size) {
            for (int i = 0; i < gap; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0; i < gap; i++) {
                head2 = head2.next;
            }
        }

        while (head1 != null && head2 != null && head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }

        if (head1 == null || head2 == null) {
            //no intersection point
            return -1;
        }

        return head1.data;
    }

    class Node {
        int data;
        Node next;
    }
}
