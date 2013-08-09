package Question2_4;

import CtCILibrary.LinkedListNode;

public class QuestionB {

	/**
	 * time: O(n), constant space. tricky to handle pointer correctly, 
	 * don't need to move previous node if appending to tail  
	 */
    public static LinkedListNode ylPartition(LinkedListNode node, int x) {
        if (node==null) return null;
        LinkedListNode tail = node;        
        while(tail.next != null)
            tail = tail.next;
        LinkedListNode pivot = tail;
        LinkedListNode head = node;
        LinkedListNode previous = node;
        while(node != pivot) {
            LinkedListNode next = node.next;
            if (node.data >= x) {
                if (node == head) {
                   node.next=null;
                } else {
                    previous.next = node.next;
                }
                tail.next = node;
                tail = tail.next;
                tail.next = null;
            } else {
                previous = node;//don't move previous if current node appended to tail
            }
            node = next;
        }
        return head;
    }
    
    /** 
	 * create two list to store less and greater elements and then merge them together
	 * time O(n), space O(n)
	 * @param node
	 * @param x
	 * @return
	 */
    public static LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode beforeStart = null;
		LinkedListNode afterStart = null;
		
		/* Partition list */
		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				/* Insert node into start of before list */
				node.next = beforeStart;
				beforeStart = node;	//keep beforeStart as the head of 1st half of list
			} else {
				/* Insert node into front of after list */
				node.next = afterStart;
				afterStart = node;
			}	
			node = next;
		}
		
		/* Merge before list and after list */
		if (beforeStart == null) {
			return afterStart;
		}
		
		LinkedListNode head = beforeStart;
		while (beforeStart.next != null) {
			beforeStart = beforeStart.next;
		}
		beforeStart.next = afterStart;
		return head;
	}
	
	public static void main(String[] args) {
		int length = 20;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		
		LinkedListNode h = partition(head, 7);
		System.out.println(h.printForward());
		
		LinkedListNode t = ylPartition(h, 7);
        System.out.println(t.printForward());
		
	}

}
