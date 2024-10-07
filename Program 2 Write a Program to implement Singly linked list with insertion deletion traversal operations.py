class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    # Insert at the beginning
    def insertAtBeginning(self, new_data):
        new_node = Node(new_data)
        new_node.next = self.head
        self.head = new_node

    # Insert after a node
    def insertAfter(self, prev_node, new_data):
        if prev_node is None:
            print("The given previous node must be in LinkedList!")
            return
        new_node = Node(new_data)
        new_node.next = prev_node.next
        prev_node.next = new_node

    # Insert at the end
    def insertAtEnd(self, new_data):
        new_node = Node(new_data)
        if self.head is None:
            self.head = new_node
            return

        last = self.head
        while last.next:
            last = last.next
        last.next = new_node

    # Deleting a node
    def deleteNode(self, position):
        if self.head is None:
            return

        temp = self.head

        if position == 0:
            self.head = temp.next
            temp = None
            return

        prev = None
        for _ in range(position):
            prev = temp
            temp = temp.next
            if temp is None:
                return

        prev.next = temp.next
        temp = None

    # Search for a node
    def search(self, key):
        current = self.head
        while current:
            if current.data == key:
                return True
            current = current.next
        return False

    # Sort the linked list
    def sortLinkedList(self):
        if self.head is None:
            return

        sorted_list = []
        current = self.head
        while current:
            sorted_list.append(current.data)
            current = current.next

        sorted_list.sort()
        current = self.head
        for data in sorted_list:
            current.data = data
            current = current.next

    # Print the list
    def printList(self):
        temp = self.head
        while temp:
            print(temp.data, end=" ")
            temp = temp.next
        print()

# Main function
if __name__ == "__main__":
    ll = LinkedList()
    ll.insertAtEnd(1)
    ll.insertAtBeginning(2)
    ll.insertAtBeginning(3)
    ll.insertAtEnd(4)
    ll.insertAfter(ll.head.next, 5)

    print("Linked list:")
    ll.printList()

    print("After deleting an element:")
    ll.deleteNode(3)
    ll.printList()

    item_to_find = 3
    print(f"{item_to_find} is found" if ll.search(item_to_find) else f"{item_to_find} is not found")

    ll.sortLinkedList()
    print("Sorted list:")
    ll.printList()
