#include<iostream>
using namespace std;
int main(){
	char str[]="sami";
	int count=0;
	cout<<str;
	for(int i=0;i<10;i++){
		if(str[i]!=NULL){
			count++;
		}else{
			break;
		}
	}
	cout<<"\n"<<count;
	return 0;
}

