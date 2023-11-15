#include<stdio.h>
int main()
{
	int m,n,i,j;
	int arr[m][n];
	
	for(i=0;i<m;i++){
		for(j=0;j<n;j++){
			printf("[%d][%d]",i,j);
			scanf("%d",arr[i][j]);
		}
	}
}
