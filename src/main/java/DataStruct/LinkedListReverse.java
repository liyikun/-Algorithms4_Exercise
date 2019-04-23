package DataStruct;

public class LinkedListReverse {
    public LinkedListReverse next;
    public String item;
    public static LinkedListReverse reverse(LinkedListReverse head) {
        if(head.next == null) return head;

        LinkedListReverse newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        LinkedListReverse linkedListReverse1 = new LinkedListReverse();
        LinkedListReverse linkedListReverse2 = new LinkedListReverse();
        LinkedListReverse linkedListReverse3 = new LinkedListReverse();

        linkedListReverse1.item = "a";
        linkedListReverse2.item = "b";
        linkedListReverse3.item = "c";
        linkedListReverse1.next = linkedListReverse2;
        linkedListReverse2.next = linkedListReverse3;
        linkedListReverse3.next = null;

        LinkedListReverse newHead = LinkedListReverse.reverse(linkedListReverse1);
        System.out.println(newHead.item);
        System.out.println(newHead.next.item);
        System.out.println(newHead.next.next.item);
    }
}
