package ds.linkedlist;

import org.junit.jupiter.api.Test;

class TestLinkedList {

	@Test
	void simpleTraverse() {
		LinkedListOperation operation = new LinkedListOperation();
		operation.addNext(1);
		operation.addNext(2);
		operation.addNext(3);
		operation.traverse();
	}

}
