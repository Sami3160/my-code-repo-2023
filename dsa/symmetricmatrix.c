#include<stdio.h>
int main()
{
	int m,n,i,j;
	int arr[m][n];
	printf("Enter the dimensions of matric (m * n) : \nm : ");
	scanf("%d",m);
	printf("\nn : ");
	scanf("%d",n);
	printf("\nNow enter the matrix elements : \n");
	
	for(i=0;i<m;i++){
		for(j=0;j<n;j++){
			printf("[%d][%d]",i,j);
			scanf("%d",arr[i][j]);
		}
	}
}
