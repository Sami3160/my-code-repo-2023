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

// Function to print the elements of the priority queue
void printQueue(struct PriorityQueue* pq) {
    printf("Priority Queue: ");
    struct Node* current = pq->front;
    while (current != NULL) {
        printf("(%d, %d) ", current->data, current->priority);
        current = current->next;
    }
    printf("\n");
}

int main() {
    struct PriorityQueue pq = { NULL };

    insert(&pq, 3, 1);
    insert(&pq, 8, 3);
    insert(&pq, 2, 2);
    insert(&pq, 5, 4);

    printQueue(&pq);

    printf("Max element: %d\n", extractMax(&pq));

    printQueue(&pq);

    return 0;
}
