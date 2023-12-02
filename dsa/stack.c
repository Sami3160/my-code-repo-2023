#include<stdio.h>
int size=5;
int top=-1;
void push(int arr[],int item){
    if(top==size-1){
        printf("stacl overflow");
        return;
    }else{
        top++;
        arr[top]=item;
        printf("\n element '%d' added in stack...",item);
    }

}
void display(int arr[]){
    int i;
    printf("\n|__|\n");

    for(i=top;i>=0;i--){
        printf("|%d |\n|__|\n",arr[i]);
    }
}
void pop(int arr[]){
    if(top==-1){
        printf("Stack underflows");
    }else{
        top--;
    }
}
void main(){
    int stack[size];
    push(stack,1);
    push(stack,2);
    push(stack,3);
    pop(stack);
    display(stack);


    push(stack,9);
    push(stack,8);
    display(stack);    
}

