package leetcode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortedInsert {

	/*static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode dataNode = new DoublyLinkedListNode();
		dataNode.data = data;
        if(head ==  null){
            return dataNode;
        }
        else if (data <= head.data) {
        	dataNode.next = head;
            head.prev = dataNode;
            return dataNode;
        }
        else {
        	DoublyLinkedListNode rest = sortedInsert(head.next, data);
            head.next = rest;
            rest.prev = head;
            return head;
        }
	}*/
	
	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		Comparator<DoublyLinkedListNode> dataComparator = (o1, o2) -> o1.data - o2.data;
        PriorityQueue<DoublyLinkedListNode> minHeap = new PriorityQueue<>(dataComparator);

        DoublyLinkedListNode temp = head;
        while(temp != null){
            minHeap.add(temp);
            temp = temp.next;
        }
        DoublyLinkedListNode dataNode = new DoublyLinkedListNode(data);
        minHeap.add(dataNode);

        DoublyLinkedListNode newHead = minHeap.remove();
        DoublyLinkedListNode tempNew = newHead;
        while(!minHeap.isEmpty()){
        	tempNew.next = minHeap.remove();
        	tempNew = tempNew.next;
        }
        return newHead;
	}
	
	public static void main(String[] args) {
		DoublyLinkedListNode node1 = new DoublyLinkedListNode(1);
		DoublyLinkedListNode node3 = new DoublyLinkedListNode(3);
		node1.next = node3;
		node3.prev = node1;
		DoublyLinkedListNode resultNode = sortedInsert(node1, 2);
		System.out.println(resultNode);
	}
	
}
