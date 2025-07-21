#include <iostream>
using namespace std;
struct employee
{
	char name[20];
	int age;
	int salary;
};
	void main()
	{
		employee  S1,S2;
		
		cout<<"Enter your name : ";
		cin>>S1.name;
		cout<<"Enter your age : ";
		cin>>S1.age;
		cout<<"Enter your salary : ";
		cin>>S1.salary;
		cout<<"Enter your name : ";
		cin>>S2.name;
		cout<<"Enter your age : ";
		cin>>S2.age;
		cout<<"Enter you salary : ";
		cin>>S2.salary;
		cout<<"Your details are : "<<endl; cout<<"1.emp name = " <<S1.name<<endl;
cout<<"emp age = "<<S1.age<<endl;cout<<"emp salary = "<<S1.salary<<endl;	
cout<<"2.emp name = "<<S2.name<<endl;
cout<<"emp age = "<<S2.age<<endl;
cout<<"emp salary = "<<S2.salary<<endl;

}
