package Week4;

public class LinkedList {
    Node head;
    int count = 0;

    private class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addHead(int data) {
        Node newNode = new Node(data, head);
        head = newNode;
        count++;
    }

    public void addTail(int data) {
        if(head == null) {
            head = new Node(data, null);
            count++;
        } else {
            Node current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = new Node(data, null);
            count++;
        }
    }

    public void printElement() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void addAtPosition(int data, int pos) {
        if(pos == 0) {
            addHead(data);
        } else if(pos == count) {
            addTail(data);
        } else {
            Node tmp = head;
            for(int i = 0;i < pos - 1;i++) {
                tmp = tmp.next;
            }
            tmp.next = new Node(data, tmp.next);
        }
    }

    public void deleteNode(int pos) {
        if(head == null) {
            return;
        }
        if(pos == 0) {
            Node tmp = head;
            head = tmp.next;
        } else if(pos == count - 1) {
            Node tmp = head;
            for(int i = 0;i < pos - 1;i++) {
                tmp = tmp.next;
            }
            tmp.next = null;
        } else {
            Node tmp = head;
            for(int i = 0;i < pos - 1;i++) {
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
        }
    }

    public void printReverse(Node head) {
        if(head == null)
            return;
        else {
            printReverse(head.next);
            System.out.print(head.data + " ");
        }
    }

    public int getNodeValue(int pos) {
        Node cur1 = head;
        Node cur2 = head;
        for(int i = 0;i < pos;i++)
            cur1 = cur1.next;
        while(cur1.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur2.data;
    }

    public int compareTwoLinkedList(Node head1, Node head2) {
        if(head1 == null && head2 == null)
            return 1;
        else if((head1 == null && head2 != null) || (head2 == null && head1 != null))
            return 0;
        else if(head1.data == head2.data)
            return compareTwoLinkedList(head1.next, head2.next);
        else return 0;
    }

    public void deleteDuplicateValue() {
        Node p = head;
        while(p.next != null) {
            if(p.data == p.next.data) {
                p.next = p.next.next;
            }
            else p = p.next;
        }
    }

    public static Node mergeTwoLinkedList(Node head1, Node head2) {
        if(head1 == null && head2 == null)
            return null;
        else if(head1 != null && head2 == null)
            return head1;
        else if(head1 == null && head2 != null)
            return head2;
        else if(head1.data <= head2.data)
            head1.next = mergeTwoLinkedList(head1.next, head2);
        else if(head1.data > head2.data)
        {
            Node tmp = head2;
            head2 = head2.next;
            tmp.next = head1;
            head1 = tmp;
            head1.next = mergeTwoLinkedList(head1.next, head2);
        }

        return head1;
    }

}
