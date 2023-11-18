#include <iostream.h>
#include <conio.h>
class A
{
	public:
	int a=10,b=20;
	void display()
	{
		cout<<"value of a&b are : "<<a<<","<< b<<endl;
	}
};
class B:public A
{
	int c=30,d=40;
	public:
	void show()
	{
		cout<<"\nvalue of c&d are : "<<c<<","<< d<<endl;
	}
};
	void main()
	{
		A obj;
		B obj1;
		obj.display();
		//obj.show();
		obj1.display();
		obj1.show();
		getch();
	}
		