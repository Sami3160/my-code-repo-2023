#include <iostream.h>
#include <conio.h>
class demo
{
	public:
    void area(int x)
    {
    	float r,a;
    	r=x;
    	a=3.14*r*r;
    	cout<<"\nArea of circle :"<<a;
    }
    void area(int x,int y)
    {
    	int a,b,area;
    	a=x;
    	b=y;
    	area=a*b;
    	cout<<"\nArea of rectangle :"<<area;
    }
};
void main()
{
    demo d;
    d.area(5);
    d.area(10,15);
    getch();
}
    
	