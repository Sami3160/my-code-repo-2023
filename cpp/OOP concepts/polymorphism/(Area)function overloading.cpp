#include <iostream.h>
#include <conio.h>
class shapes
{
	public:
	void area(int a)
	{
		cout<<"\nArea of square :"<<a*a;
	}
	void area(int b, int c)
	{
		cout<<"\nArea of rectangle :"<<b*c;
	}
	void area(float d,float e)
	{
		cout<<"\nArea of triangle :"<<0.5*d*e;
	}
	void area(float r)
	{
		cout<<"\nArea of circle :"<<3.14*r*r;
	}
};
void main()
{
	int a,b,c;
	float d,e,r;
	cout<<"\nEnter the Side :";
	cin>>a;
	cout<<"Enter the breadth and height :";
	cin>>b>>c;
	cout<<"Enter the height and width :";
	cin>>d>>e;
	cout<<"Enter the radius :";
	cin>>r;
	shapes s;
	cout<<"\n--------------------(AREA)---------------------"<<endl;
	s.area(a);
	s.area(b,c);
	s.area(d,e);
	s.area(r);
	getch();
}