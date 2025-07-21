#include <iostream.h>
#include <conio.h>
class employee
{
	public:
	char name[20];
	int age;
	void get()
	{
		cout<<"Name employee  : "<<endl;
		cin>>name;
		cout<<"Enter your age : "<<endl;
		cin>>age;
	}
	void show()
	{
		cout<<"Employee Name "<<name<<endl;
		cout<<"Age "<<age<<endl;
	}
};
class jr_employee:public employee
{
		public:
	char name1[20];
	int age1;
	void provide()
	{
		cout<<"Jr.employee name : "<<endl;
		cin>>name1;
		cout<<"Enter your age : "<<endl;
		cin>>age1;
	}
	void display()
	{
		cout<<"Jr.employee Name : "<<name1<<endl;
		cout<<"Age : "<<age1<<endl;
	}
};
void main()
{
	employee obj;
	jr_employee obj1;
	obj.get();
	obj1.get();
	obj1.provide();
	obj.show();
	obj1.show();
	obj1.display();
	getch();
}
	