#include <stdio.h>
int main()
{
    int size=5;
    int arr[5]={16,24,3,24,95};
	int i=0;
printf("\nItems : ");	
	for(i=0;i<size;i++){
	printf("%d, ",arr[i]);

}
printf("\nIndex : ");
	for(i=0;i<size;i++){
	printf("%d, ",i);

}

	int index;
	printf("\nEnter a index item to be deleted in array : \n");
	scanf("%d",&index);
	
	if(index>=size){
	printf("Deletion not possible\n");
}else{
	for(i=index;i<size;i++){
	arr[i]=arr[i+1];

}
}
	
	printf("\nNew array will be : \n");
	
	for(i=0;i<size-1;i++){
	printf("%d, ",arr[i]);
}
	printf("\n");
    return 0;
}
