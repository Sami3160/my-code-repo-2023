#include <stdio.h>
int main()
{
	int arr[]={91,62,33,4,3};
	int i,j,n,temp,min_index;
	n=sizeof(arr)/4;
	printf("\nUnsorted array is : ");
	for(i=0;i<n;i++){
		printf("%d, ",arr[i]);
	}
	for(i=0;i<n-1;i++){
		min_index=i;
		for(j=i+1;j<n;j++){
			if(arr[min_index]>arr[j]){
				min_index=j;
			}
		}
		temp=arr[min_index];
		arr[min_index]=arr[i];
		arr[i]=temp;
	}
	printf("\nSorted array is : ");
    for(i=0;i<n;i++){
		printf("%d, ",arr[i]);
	}
    return 0;
}
