#include <stdio.h>
#include <stdlib.h>
  
 struct node
 {
     int a;
     struct node *next;
 };

 void generate(struct node **);
 int length(struct node*);
 void delete(struct node **);
  
 int main()
 {
     struct node *head = NULL;
     int count;
  
     generate(&head);
     count = length(head);
     printf("The number of nodes are: %d", count);
     delete(&head);
     return 0;
 }
  
 void generate(struct node **head)
 {
     /* for unknown number of nodes use num = rand() % 20; */
     int num = 10, i;
     struct node *temp;
  
     for (i = 0; i < num; i++)

     {
         temp = (struct node *)malloc(sizeof(struct node));
         temp->a = i;
         if (*head == NULL)
         {
             *head = temp;
             (*head)->next = NULL;
         }
         else
         {
             temp->next = *head;
             *head = temp;
         }
     }
 }
  
 int length(struct node *head)
 {
     if (head->next == NULL)
     {
         return 1;
     }
     return (1 + length(head->next));
 }
  
 void delete(struct node **head)
 {
     struct node *temp;
     while (*head != NULL)
     {
         temp = *head;
         *head = (*head)->next;
         free(temp);
     }
 }
 
