#include<stdio.h>
int size=10;
int queue[10];
int front=-1;
int rear=-1;
void enQueue(int item){
    if(rear==size-1){
        printf("\nStack is full...");
    }else{
        if(front==-1){front++;}
        rear++;
        queue[rear]=item;
    }
}

void deQueue(){
    if(front==-1){
        printf("The queue is empty...");
    }else{
        printf("\nElement '%d' removed.",queue[front]);
        front++;
    }
}

void display(){
    int i;

    for(i=front;i<=rear;i++){
        printf("___");
        
    }
    printf("\n");
    for(i=front;i<=rear;i++){
     
        printf("|%d ",queue[i]);
        
    }
    printf("|\n");
    for(i=front;i<=rear;i++){

        printf("|__");
    }
    printf("|\n");

}
void main(){
    enQueue(5);
    enQueue(9);
    enQueue(4);
    enQueue(2);
    display();
}