#include <stdio.h>



void addMatrix(int arr1[3][3],int arr2[3][3])         
{
    printf("Displaying matrix after addition : \n");
	int i,j;	
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d ",arr1[i][j]+arr2[i][j]);
		}
		printf("\n");
	}
}

void subMatrix(int arr1[3][3],int arr2[3][3])         
{
    printf("Displaying matrix after sbstraction : \n");
	int i,j;	
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d ",arr1[i][j]-arr2[i][j]);
		}
		printf("\n");
	}
}

void multMatrix(int arr1[3][3],int arr2[3][3])         
{
    printf("Displaying matrix after multiplication : \n");
	int i,j,k;	
	int res[3][3];
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			for(k=0;k<3;k++){
				res[i][j]+=arr1[i][k]*arr2[k][j];
			}
		printf("%d ",res[i],j);
		}
		printf("\n");
	}
}
int main(){

	int arr1[3][3]={2,2,2,3,3,3,4,4,4};
	int arr2[3][3]={1,1,1,2,2,2,3,3,3};
	printf("Displaying matrix : \n");
	printf("Matrix1\t Matrix2 \n");
	int i,j;	
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d ",arr1[i][j]);
		}
		printf("\t");
		for(j=0;j<3;j++){
			printf("%d ",arr2[i][j]);
		
		}
		printf("\n");
	}
	printf("Select operation on matrix : \n(1.Addtion,2.Substraction,3.Multiplication)\n");
	int option;
	scanf("%d",&option);
	switch(option){
	case 1:
		addMatrix(arr1,arr2);
	break;
	case 2:
		subMatrix(arr1,arr2);
	break;
	case 3:
		multMatrix(arr1,arr2);
	break;
	default:
		printf("\nWrong option entered!!!\n");
}
	return 0;
}


