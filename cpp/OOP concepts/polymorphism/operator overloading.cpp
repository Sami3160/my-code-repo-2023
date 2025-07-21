#include <iostream.h>
#include <conio.h>
class test
{
	public:
	int num;
	test()
	{
		num=1;
	}
	void operator ++()
	{
		num=num+5;
	}
	void print()
	{
		cout<<"Value :"<<num;
	}
};
void main()
{
	test t;
	++t;
	t.print();
	getch();
}