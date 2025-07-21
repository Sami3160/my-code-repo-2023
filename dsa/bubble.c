#include <stdio.h>
int main()
{
	int arr[]={91,62,33,4,3};
	int i,j,n,temp;
	n=sizeof(arr)/4;
	printf("\nUnsorted array is : ");
	for(i=0;i<n;i++){
		printf("%d, ",arr[i]);
	}
	for(i=0;i<n-1;i++){
		for(j=0;j<n-i-1;j++){
			if(arr[j]>arr[j+1]){
				temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
		}
	}
	printf("\nSorted array is : ");
    for(i=0;i<n;i++){
		printf("%d, ",arr[i]);
	}
    return 0;
}
