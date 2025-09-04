#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 100

int adjecencyMatrix[MAX_SIZE][MAX_SIZE];
int visited[MAX_SIZE];
int queue[MAX_SIZE];
int front,rear=-1;
int isEmpty(){
    return front==-1;
}
void enqueue(int no){
    if(rear==MAX_SIZE-1)return;
    if (front==-1)
    {
        front=0;
    }
    rear++;
    queue[rear]=no;
    
}

int dequeue(){
    int vertex;
    if (isEmpty())
    {
        return -1;
    }
    vertex=queue[front];
    if (front==rear)
    {
        front=rear=-1;
    }else{
    front++;
    }
    return vertex;    
}

void bfs(int start,int size){
    int i,processed;
    front = rear = -1;
    for (i = 0; i <size; i++)
    {
        visited[i]=0;
    }
    visited[start]=1;
    enqueue(start);
    while (!isEmpty())
    {
        processed=dequeue();
        printf("%d\t",processed);
        for ( i = 0; i < size; i++)
        {
            if (adjecencyMatrix[processed][i] && !visited[i])
            {
                visited[i]=1;
                enqueue(i);
            }
            
        }
        
        
    }
    
}

void main(){
    int size,i,j,start;
    printf("\nEnter the number of vertices... : ");
    scanf("%d",&size);
    printf("\nEnter the graph edges through matrix(1/0) : ");
    for(i=0;i<size;i++){
        for(j=0;j<size;j++){
            printf("(%d,%d)",i,j);           
            scanf("%d",&adjecencyMatrix[i][j]);
        }
        printf("\n");
    }
    
    printf("\nEnter the node from traversing should start... : ");
    scanf("%d",&start);
    bfs(start,size);
    
}
