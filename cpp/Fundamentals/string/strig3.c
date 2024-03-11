#include<stdio.h>
int main(){
	int i;
	char str[]="om boi";
	for(i=strlen(str);i>=0;i--){
		printf("%c\n",str[i]);
	}
	return 0;
}
