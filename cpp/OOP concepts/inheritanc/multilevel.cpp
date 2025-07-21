#include <iostream.h>
#include <conio.h>
class animal
{
	public:
	void eat()
	{
		cout<<"I am eating "<<endl;
	}
	void sleep()
	{
		cout<<"I am sleepling "<<endl;
	}
};
class dog:public animal
{
	public:
	void bark()
	{
		cout<<"I am barking "<<endl;
	}
};
class babydog:public dog
{
	public:
	void weeping()
	{
		cout<<"I am weeping "<<endl;
	}
};
void main()
{
	animal a;
	dog d;
	babydog b;
	a.eat();
	a.sleep();
	d.eat();
	d.sleep();
	d.bark();
	b.eat();
	b.sleep();
	b.bark();
	b.weeping();	
	getch();
}