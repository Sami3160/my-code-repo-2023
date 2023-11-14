#include <stdio.h>

void checkUpper(int arr1[3][3])         
{
    printf("Displaying matrix after addition : \n");
	int i,j;	
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d ",arr1[i][j]);
		}
		printf("\n");
	}
}
int main(){

	int arr1[3][3]={2,2,2,3,3,3,4,4,4};
	printf("Displaying matrix : \n");
	printf("Matrix1\n");
	int i,j;	
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d ",arr1[i][j]);
		}

		printf("\n");
	}
	checkUpper(arr1);
	return 0;
}


