#include<stdio.h>
#include<stdlib.h>
struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
};
struct Node *getNewNode(int data){
    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node*));
    newNode->data=data;
    newNode->left=NULL;
    newNode->right=NULL;
    return newNode;
}
void inorder(struct Node* root){
    if(root==NULL)return;
    inorder(root->left);
    printf("%d->",root->data);
    inorder(root->right);
}
void preorder(struct Node* root){
    if(root==NULL)return;
    printf("%d",root->data);
    preorder(root->left);
    preorder(root->right);
}
void postorder(struct Node* root){
    if(root==NULL)return;
    postorder(root->left);
    postorder(root->right);
    printf("%d",root->data);
}

struct Node *insert(struct Node* root,int data){
    if(root==NULL)return getNewNode(data);
    
    if (data<root->data)
    {
        root->left=insert(root->left,data);
    }else
    {
        root->right=insert(root->right,data);
    }
        return root;
}
int Search(struct Node* root,int data){
    if(root==NULL)return 0;
    else if (root->data==data)return 1;
    else if (data<root->data)return Search(root->left,data);
    else return Search(root->right,data);
    
}



void main(){
    struct Node* root=NULL;
    
    root=insert(root,10);
    root=insert(root,30);
    root=insert(root,5);
    root=insert(root,9);
    inorder(root);
    // printf("%d, ",Search(root,5));
}
