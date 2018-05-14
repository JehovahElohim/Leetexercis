package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CopyListwithRandomPointer {
	/*
	 * 链表进行三次扫描，第一次扫描对每个结点进行复制，然后把复制出来的新节点接在原结点的next，也就是让链表变成一个重复链表，就是新旧更替；
	 * 第二次扫描中我们把旧结点的随机指针赋给新节点的随机指针，因为新结点都跟在旧结点的下一个，所以赋值比较简单，就是node.next.random =
	 * node
	 * .random.next，其中node.next就是新结点，因为第一次扫描我们就是把新结点接在旧结点后面。现在我们把结点的随机指针都接好了，
	 * 最后一次扫描我们把链表拆成两个，第一个还原原链表，而第二个就是我们要求的复制链表。
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		 if(head == null)  
		        return head;  
		    RandomListNode node = head;  
		    //copy+merge
		    while(node!=null)  
		    {  
		        RandomListNode newNode = new RandomListNode(node.label);  
		        newNode.next = node.next;  
		        node.next = newNode;  
		        node = newNode.next;  
		    }  
		    node = head;  
		    //copy random
		    while(node!=null)  
		    {  
		        if(node.random != null)  
		            node.next.random = node.random.next;  
		        node = node.next.next;  
		    }  
		    RandomListNode newHead = head.next;  
		    node = head;  
		    //split
		    while(node != null)  
		    {  
		        RandomListNode newNode = node.next;  
		        node.next = newNode.next;  
		        if(newNode.next!=null)  
		            newNode.next = newNode.next.next;  
		        node = node.next;  
		    }  
		    return newHead;  
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};