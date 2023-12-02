#include <stdio.h>
void sort(int arr[],int n){
	int i,j,key;
	for(i=0;i<n;i++){
		key=arr[i];
		j=i-1;
		while(j>=0 && arr[j]>arr[i])
		{
			arr[j]=arr[j+1];
			j--;
		}
		arr[j]=key;
	}
}
int main()
{
	int arr[]={91,62,33,4,3};
	int i,j,n,temp,key;
	n=sizeof(arr)/4;
	printf("\nUnsorted array is : ");
	for(i=0;i<n;i++){
		printf("%d, ",arr[i]);
	}
	for(i=0;i<n;i++){
		key=arr[i];
		j=i-1;
		while(j>=0 && arr[j]>key){
			arr[j+1]=arr[j];
			j=j-1;
		}
		arr[j+1]=key;
	}
	printf("\nSorted array is : ");
    for(i=0;i<n;i++){
		printf("%d, ",arr[i]);
	}
    return 0;
}
