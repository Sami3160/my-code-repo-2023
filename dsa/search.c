#include <stdio.h>
int main()
{
	int arr1[]={11,7,63,1,8,22,19,32,11,0};
	int size=sizeof(arr1)/4;
	int target,index,i;
int flag=0;
	printf("Displaying array : ");
	for(i=0;i<size;i++){
		printf("%d, ",arr1[i]);			
	}
	printf("\nEnter any element to be searched : ");
	scanf("%d",&target);

	for(i=0;i<size;i++){
		if(target==arr1[i]){
		flag=1;
		index=i;
		break;
		}
	}
	if(flag==1){
		printf("\nItem found at index {%d}",index);
	}else{
		printf("\nItem not found...");	
	}

    return 0;
}
