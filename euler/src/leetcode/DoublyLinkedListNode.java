package leetcode;

public class DoublyLinkedListNode {
	int data;
	DoublyLinkedListNode prev;
	DoublyLinkedListNode next;

	public DoublyLinkedListNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "DoublyLinkedListNode [data=" + data + ", next=" + next + "]";
	}
}
