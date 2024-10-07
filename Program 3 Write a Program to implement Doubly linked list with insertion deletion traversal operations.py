class Node:
    def __init__(self, data):
        self.item = data
        self.next = None
        self.prev = None

class DoublyLinkedList:
    def __init__(self):
        self.start_node = None

    def insert_to_empty_list(self, data):
        if self.start_node is None:
            self.start_node = Node(data)
        else:
            print("The list is not empty")

    def insert_to_end(self, data):
        new_node = Node(data)
        if self.start_node is None:
            self.start_node = new_node
            return

        n = self.start_node
        while n.next is not None:
            n = n.next
        n.next = new_node
        new_node.prev = n

    def delete_at_start(self):
        if self.start_node is None:
            print("The list is empty, no element to delete")
            return
        if self.start_node.next is None:
            self.start_node = None
            return
        self.start_node = self.start_node.next
        self.start_node.prev = None

    def delete_at_end(self):
        if self.start_node is None:
            print("The linked list is empty, no element to delete")
            return
        if self.start_node.next is None:
            self.start_node = None
            return
        n = self.start_node
        while n.next is not None:
            n = n.next
        n.prev.next = None

    def display(self):
        if self.start_node is None:
            print("The list is empty")
            return
        n = self.start_node
        while n is not None:
            print("Element is:", n.item)
            n = n.next
        print("\n")

# Example usage
new_doubly_linked_list = DoublyLinkedList()
new_doubly_linked_list.insert_to_empty_list(10)

new_doubly_linked_list.insert_to_end(20)
new_doubly_linked_list.insert_to_end(30)
new_doubly_linked_list.insert_to_end(40)
new_doubly_linked_list.insert_to_end(50)
new_doubly_linked_list.insert_to_end(60)

new_doubly_linked_list.display()

new_doubly_linked_list.delete_at_start()
new_doubly_linked_list.delete_at_end()
new_doubly_linked_list.display()
