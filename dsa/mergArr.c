#include<stdio.h>
void main()
{
	int i,n1,n2;
	int a[10],b[10],c[10];
	int ptr1=0,ptr2=0,ptr3=0;
	printf("enter the size of 1st list:");
	scanf("%d",&n1);
	printf("enter the size of 2nd list:");
	scanf("%d",&n2);
	printf("enter the elements of 1st list:\n");
	for(i=0;i<n1;i++)
	{
		scanf("%d",&a[i]);
	}   
	printf("enter the elements of 2nd list:\n");
	for(i=0;i<n2;i++)
	{
		scanf("%d",&b[i]);
	}
	printf("Elements of 1st list are:\n");
	for(i=0;i<n1;i++)
	{
		printf("%d ",a[i]);
	}
	printf("\nElements of 2nd list are:\n");
	for(i=0;i<n2;i++)
	{
		printf("%d ",b[i]);
	}
	while(ptr1<n1)
	{
		c[ptr3]=a[ptr1];
		ptr1++;
		ptr3++;
	}
	while(ptr2<n2)	
	{
		c[ptr3]=b[ptr2];
		ptr2++;
		ptr3++;
	}
	printf("\nElements after merging:\n");
	for(i=0;i<(n1+n2);i++){
		printf("%d ",c[i]);
	}
}


