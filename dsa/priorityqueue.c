#include<stdio.h>
#include<stdlib.h>
struct Node
{
    int data;
    int priority;
    struct Node* next; 
};

struct priorityQueue{
    struct Node* front;
};

struct Node* createNode(int data,int priority ){
    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
    newNode->data=data;
    newNode->priority=priority;
    newNode->next=NULL;
    return newNode;

};

void insertItem(struct priorityQueue* pq,int data,int priority){
    struct Node* newNode=createNode(data,priority);
    if(pq->front==NULL || priority>pq->front->priority){
        newNode->next=pq->front;
        pq->front=newNode;
    }else{
        struct Node* ptr=pq->front;
        while (ptr->next!=NULL && priority<=ptr->priority)
        {
            ptr=ptr->next;
        }
        newNode->next=ptr->next;
        ptr->next=newNode;
    }
}
void extract(struct priorityQueue* pq){
    struct Node* node=pq->front;
    if(pq->front==NULL){
        printf("\nQueue is empty");
        return;
    }
    pq->front=node->next;
    free(node);
}
void display(struct priorityQueue* pq){
    struct Node* ptr=pq->front;
    while (ptr!=NULL)
    {
        printf("%d | ",ptr->data);
        ptr=ptr->next;
    }
    
}
void main(){
    struct priorityQueue pq={NULL};
    insertItem(&pq,20,5);  
    insertItem(&pq,10,3);   
    insertItem(&pq,90,10);   
    extract(&pq);
    display(&pq);
}