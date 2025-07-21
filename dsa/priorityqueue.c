#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    int priority;
    struct Node* next;
};

struct PriorityQueue {
    struct Node* front;
};

// Function to create a new node
struct Node* createNode(int data, int priority) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->priority = priority;
    newNode->next = NULL;
    return newNode;
}

// Function to insert an element into the priority queue
void insert(struct PriorityQueue* pq, int data, int priority) {
    struct Node* newNode = createNode(data, priority);

    if (pq->front == NULL || priority > pq->front->priority) {
        newNode->next = pq->front;
        pq->front = newNode;
    } else {
        struct Node* current = pq->front;
        while (current->next != NULL && priority <= current->next->priority) {
            current = current->next;
        }
        newNode->next = current->next;
        current->next = newNode;
    }
}

// Function to extract the element with the highest priority
int extractMax(struct PriorityQueue* pq) {
    if (pq->front == NULL) {
        printf("Priority Queue is empty\n");
        return -1;
    }

    int data = pq->front->data;
    struct Node* temp = pq->front;
    pq->front = pq->front->next;
    free(temp);

    return data;
}

// Function to print the elements of the priority