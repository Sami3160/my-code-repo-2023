#include<stdio.h>
#include<stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

// Inserting Nodes
void addAtBeginning(struct Node* head, int val) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = val;
    newNode->next = head->next;
    head->next = newNode;
}

void addAtLocation(struct Node* head, int val, int location) {
    struct Node* current = head;
    struct Node* previous = NULL;

    if (location < 1) {
        printf("Invalid location");
        return;
    }

    for (register int i = 0; i < location; i++) {
        if (i == location - 1) {
            previous = current;
        }
        current = current->next;
        if (current == NULL) {
            break;
        }
    }

    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = val;
    newNode->next = current;
    previous->next = newNode;
}

void addAtEnd(struct Node* head, int val) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = val;
    newNode->next = head; // Point to head to make it circular

    struct Node* ptr = head;
    while (ptr->next != head) {
        ptr = ptr->next;
    }

    ptr->next = newNode;
}

// Deleting from the linked list
void deleteAtBeginning(struct Node* head) {
    struct Node* ptr = head->next;
    head->next = ptr->next;
    free(ptr);
}

void deleteAtLocation(struct Node* head, int location) {
    if (location < 1) {
        printf("Invalid Location\n");
        return;
    }

    struct Node* ptr = head;
    struct Node* before;
    for (register int i = 0; i < location; i++) {
        before = ptr;
        ptr = ptr->next;
        if (ptr == head) {
            printf("Location out of bounds!\n");
            return;
        }
    }

    before->next = ptr->next;
    free(ptr);
}

void deleteAtEnd(struct Node* head) {
    struct Node* ptr = head;
    struct Node* previous;
    while (ptr->next != head) {
        previous = ptr;
        ptr = ptr->next;
    }
    previous->next = head;
    free(ptr);
}

// Displaying the linked list
void display(struct Node* head) {
    struct Node* current = head;
    printf("Circular Linked List: ");
    do {
        printf("{%p}(%d)[%p] -> ", current, current->data, current->next);
        current = current->next;
    } while (current != head);
    printf("Head\n");
}

int main() {
    struct Node* head = (struct Node*)malloc(sizeof(struct Node));
    head->data = 0;
    head->next = head;  // Point to itself to make it circular

    addAtBeginning(head, 10);
    addAtBeginning(head, 20);
    addAtBeginning(head, 30);
    addAtBeginning(head, 40);
    addAtBeginning(head, 50);
    display(head);

    addAtEnd(head, 60);
    addAtEnd(head, 70);
    display(head);

    deleteAtBeginning(head);
    display(head);

    deleteAtEnd(head);
    display(head);

    return 0;
}
