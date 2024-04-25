//* head [ NULL, 0 , &first ] → first [ NULL , 0 , &second ] → second [ &first , 0 , &third ] → third [ &second,  0 , NULL ]

#include<stdio.h>
#include<stdlib.h>

struct Node{
    struct Node * prev;
    int data;
    struct Node * next;
};

// * Inserting Nodes
void addAtBeginning(struct Node * head,int val){
    struct Node * newNode;
    newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode -> data = val;
    newNode -> prev = NULL;
    if(head -> next == NULL){
        newNode -> next = NULL;
        head -> next = newNode;
    }else{
        newNode -> next = head -> next;
        (head -> next) -> prev = newNode;
        head -> next = newNode;
    }
    head -> next = newNode;
}

void addAtEnd(struct Node * head,int val){
    struct Node * newNode;
    newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode -> data = val;
    newNode -> next = NULL; // * Assigning NULL to next field of newNode
    struct Node * ptr = head;
    if(head -> next == NULL){
        addAtBeginning(head,val);
        return;
    }else{
        while (ptr -> next != NULL) {
            ptr = ptr -> next;
        }
        ptr -> next = newNode;
        newNode -> prev = ptr;
    }
}

void addAtLocation(struct Node * head,int val, int location){
    struct Node * current = head;
    if(location < 1) {
        printf("Invalid location\n");
        return;
    }else if (location == 1 || head -> next == NULL) {
        addAtBeginning(head,val);
        return;
    }
    for(register int i = 0 ; i < location && current != NULL ; i++){
        current = current -> next;
    }
    if (current == NULL) {
        addAtEnd(head,val);
        return;
    }
    struct Node * newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode -> data = val;
    newNode -> next = current;
    (current -> prev) -> next = newNode;
    newNode -> prev = current -> prev;
    current -> prev = newNode;
}


// * Deleting from the linked list
void deleteAtBeginning(struct Node * head){
    struct Node * ptr = head -> next;
    (ptr -> next) -> prev = NULL;
    head -> next = ptr -> next;
    free(ptr);
}

void deleteAtLocation(struct Node * head, int location){
    if(location < 1){
        printf("Invalid Location\n");
        return;
    }
    struct Node * ptr = head;
    for(register int i = 0 ; i < location ; i++){
        ptr = ptr -> next;
        if(ptr == NULL){
            printf("Location out of bounds!\n");
            return;
        }
    }

    (ptr -> prev) -> next = ptr -> next;
    (ptr -> next) -> prev = ptr -> prev;
    free(ptr);
}

void deleteAtEnd(struct Node * head){
    struct Node * ptr = head;
    while(ptr -> next != NULL){
        ptr = ptr -> next;
    }
    (ptr -> prev) -> next = NULL;
    free(ptr);
}

// * Displaying the linked list
void display(struct Node * head){
    struct Node* current = head;
    printf("Linked List: ");
    current = head -> next; 
    while (current != NULL) {
        printf("[%p](%d)[%p] -> ", current -> prev, current -> data , current -> next);
        current = current -> next;
    }
    printf("NULL\n");
}

int main(){
    struct Node* head = (struct Node*)malloc(sizeof(struct Node)); 
    head->data = 0;
    head->next = NULL;

    int opt_1,opt_2,val,loc;
    // while(1){
    //     printf("Enter Option: 1. Insert 2. Delete 3. Display - ");
    //     scanf("%d",&opt_1);
    //     switch(opt_1){
    //         case 1:
    //             printf("Enter Option: 1. At Beginning 2. At Location 3. At End - ");
    //             scanf("%d",&opt_2);
    //             switch (opt_2)
    //             {
    //                 case 1:
    //                     printf("Enter value to be added at start: ");
    //                     scanf("%d",&val);
    //                     addAtBeginning(head,val);
    //                     break;
    //                 case 2:
    //                     printf("Enter value & location: ");
    //                     scanf("%d%d",&val,&loc);
    //                     addAtLocation(head,val,loc);
    //                     break;
    //                 case 3:
    //                     printf("Enter value to be added at end: ");
    //                     scanf("%d",&val);
    //                     addAtEnd(head,val);
    //                     break;
    //                 default:
    //                 printf("Invalid Option!\n");
    //                     break;
    //             }
    //             break;

    //         case 2:
    //             printf("Enter Option: 1. From Beginning 2. From Location 3. From End - ");
    //             scanf("%d",&opt_2);
    //             switch (opt_2)
    //             {
    //                 case 1:
    //                     deleteAtBeginning(head);
    //                     printf("Value has been deleted from start of linked list!\n");
    //                     break;
    //                 case 2:
    //                     printf("Enter location from which value is to be deleted: ");
    //                     scanf("%d",&loc);
    //                     deleteAtLocation(head,loc);
    //                     break;
    //                 case 3:
    //                     deleteAtEnd(head);
    //                     printf("Value has been deleted from end of linked list!\n");
    //                     break;
    //                 default:
    //                     printf("Invalid Option!\n");
    //                     break;
    //             }
    //             break;

    //         case 3:
    //             display(head);
    //             break;
    //         default:
    //             printf("Invalid Option!\n");
    //             break;
    //     }
    // }

    addAtBeginning(head,10);
    addAtBeginning(head,20);

    display(head);
    
    addAtEnd(head,50);
    addAtEnd(head,60);
    addAtEnd(head,70);
    display(head);

    addAtLocation(head,100,8);
    display(head);

    deleteAtBeginning(head);
    display(head);
    
    deleteAtEnd(head);
    display(head);

    deleteAtLocation(head,3);
    display(head);

    return 0;
}