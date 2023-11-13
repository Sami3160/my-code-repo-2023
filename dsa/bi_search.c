#include <stdio.h>
int main()
{
	int arr1[]={11,17,23,31,48,49,59,62,71,80};
	int size=sizeof(arr1)/4;
	int target,index,i,beg,end,mid;
int flag=0;
	printf("Displaying array : ");
	for(i=0;i<size;i++){
		printf("%d, ",arr1[i]);			
	}
	printf("\nEnter any element to be searched : ");
	scanf("%d",&target);
	end=size-1;
	mid=(beg+end)/2;
	beg=0;
	while(beg<=end){
		if(target<arr1[mid]){
			end=mid-1;
			mid=(beg+end);
		}else if(target==arr1[mid]){
			printf("\nElement found at index {%d}",mid);
			break;
		}
		else{
			beg=mid+1;
			mid=(beg+end);
		}
	}
	if(beg>end){
		printf("\nElemet not found");
	}

    return 0;
}
