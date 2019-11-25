package barryflash.superheroes.capabilities;

import net.minecraft.util.math.BlockPos;

public class DoctorStrangeLinkedList {

	public BlockPos pos;
	public float yaw;
	public float pitch;
	public DoctorStrangeLinkedList next;
	
	public DoctorStrangeLinkedList(BlockPos pos, float yaw, float pitch) {
		this.pos = pos;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public void display() {
		System.out.println(pos + "," + yaw + "," + pitch);
	}
	
	
	public BlockPos toBlockPos() {
		return pos;
	}
}
class LinkList {
	public DoctorStrangeLinkedList firstLink;
	
	LinkList() {
		firstLink = null;
	}
	public boolean isEmpty(){
		return(firstLink == null);
	}
	
	public void insertFirstLink(BlockPos pos, float yaw, float pitch) {
		DoctorStrangeLinkedList newLink = new DoctorStrangeLinkedList(pos, yaw, pitch);
			if (isEmpty()) {
		newLink.next = firstLink;
		
		firstLink = newLink;
			} else {
				newLink.next = firstLink.next;
				firstLink.next = newLink.next;
			}
	}
	
	public DoctorStrangeLinkedList removeFirst() {
		DoctorStrangeLinkedList linkReference = firstLink;
		if(!isEmpty()) {
			firstLink= firstLink.next;
			
		} else {
			System.out.println("Empty Link");
		}
		return linkReference;
	}
	
	public void display() {
		DoctorStrangeLinkedList theLink = firstLink;
		while(theLink != null) {
			theLink.display();
			System.out.println("Next Link: " + theLink.next);
			
			theLink = theLink.next;
			
			System.out.println();
		}
	}
	public DoctorStrangeLinkedList find(BlockPos pos) {
		DoctorStrangeLinkedList theLink = firstLink;
		if(!isEmpty()) {
			while(theLink.pos != pos) {
				if(theLink.next == null) {
					return null;
				} else {
					theLink = theLink.next;
				}
			}
		} else {
			System.out.println("Empty LinkedList");
		}
		return theLink;
	}
}