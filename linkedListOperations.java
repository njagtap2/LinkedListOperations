
/**
 * @author NEHA JAGTAP
 *
 */
public class linkedListOperations {
	public Node Head;
	public void addNewNodeAtBegining(Node Head, int Data)
	{
		if(Head==null)
		{
			return;
		}
		Node nodeToAdd = new Node(Data);
		nodeToAdd.next =Head;
		Head= nodeToAdd;
		display(Head);
	}
	public void addNewNodeAtEnd(Node Head, int Data)
	{  if(Head==null)
	return;
		Node current = Head;//Works like a iterator
		Node newNode = new Node(Data);
		newNode.next = null;
		while(current.next!=null)
		{current = current.next;}
		current.next =newNode;
		display(Head);
	}
	public void InsertNewNode(Node Head, int Data, int position)
	{	
		int size = getlength(Head);
		if(Head==null)
			return;
		if(position>(getlength(Head)+1)|| position<1)
		{
			System.out.println("Invalid position");
		return;
	    }
		if(position==1)
		{
			addNewNodeAtBegining(Head, Data);
			return;
		}
		Node previous = Head;
		int count =1;
		while(count!=position-1)
		{
		   previous =previous.next;
           count++;
		}
		Node current = previous.next;
		Node nodeToInsert = new Node(Data);
		nodeToInsert.next=current;
		previous.next = nodeToInsert;
		display(Head);
	}
	public void ReverseList(Node Head)
	{
		if(Head== null)
		{
			return;
		}
		Node Next= null;
		Node previous= null;
		Node current = Head;
		while(current!= null)
		{
			Next = current.next;
			current.next =previous;
			previous =current;
			current = Next;
		}
		Head =previous;
		display(Head);
	}
	public void DeleteNodeAtGivenPosition(Node Head, int position)
	{
		Node previous = Head;
		int count =0;
		while(count<position-1)
		{   count++;
			previous= previous.next;
		}
		Node current = previous.next;
		previous.next =current.next;
		current.next =null;
		display(Head);
	}
	public linkedListOperations.Node ReverseLinkedListRecursion (Node current, Node previous)
	{ 
		if(current== null)
		{
			System.out.println("No value in Linkedlist");
			return current;
			
		}
		if(current.next==null)
		{
			
			current.next = previous;
			Head= current;
			display(Head);
		}
		else
		{
			Node next = current.next;
			current.next = previous;
			ReverseLinkedListRecursion(next,current);
		}
		return Head;
		
	}
	public void swapPairwise(Node Head)
	{
		Node current = Head;
		if(Head== null)
		{
			return;
		}
		else
		{
			while(current.next!=null)
			{ 
				int tempcurrenttData = current.data;
				current.data =current.next.data;
				current.next.data = tempcurrenttData;
				if(current.next.next!=null)
				current = current.next.next;
				else
					break;
			}
		}
		display(Head);
		
	}
	//Calculate length of LinkedList
	public int getlength (Node Head)
	{
		if(Head== null)
		{
			return 0;
		}
		int count=0;
		Node current = Head;
		while(current!=null)
		{
			count++;
		current = current.next;	
		}
		return count;
	}
	//Displays LinkedList
	public void display(Node Head)
	{
		//No elements in LinkedList
		if (Head == null)
		{return;}
		//Node Current is pointing to Node Head
		Node current = Head;
		while(current!=null)
		{
			System.out.print(current.data+"--->");
			current = current.next;
		}
		System.out.println(current);
	}
private static class Node
{
	int data;
	Node next;
	public Node(int Data)
	{
		this.data = Data;
		this.next= null;
	}
	}
	public static void main(String[] args) {
//Created a head node		
Node Head = new Node(1);
//can create a new node by giving it name
Node firstNode = new Node(2);
//Linked head node to to the first Node
Head.next =firstNode;
firstNode.next=new Node(3);
firstNode.next.next= new Node(4);
firstNode.next.next.next=new Node(5);
firstNode.next.next.next.next=new Node(6);
 //Various LinkedList Operations
linkedListOperations LinkedListOperation = new linkedListOperations();
System.out.println("Display Linkedlist");
LinkedListOperation.display(Head);
System.out.println("Adding node at the start of the Linkedlist");
LinkedListOperation.addNewNodeAtBegining(Head,15);
System.out.println("Adding node at the end of Linkedlist");
LinkedListOperation.addNewNodeAtEnd(Head, 10);
System.out.println("Adding node at position 3 of Linkedlist");
LinkedListOperation.InsertNewNode(Head, 100,3);
System.out.println("Deleting node at position 4 of Linkedlist");
LinkedListOperation.DeleteNodeAtGivenPosition(Head,4);
System.out.println("Swapping two nodes");
LinkedListOperation.swapPairwise(Head);
System.out.println("Reversing the linkedlist by recursion");
Head=LinkedListOperation.ReverseLinkedListRecursion(Head, null);
System.out.println("Reversing the linkedlist");
LinkedListOperation.ReverseList(Head);

	}

}
