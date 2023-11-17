#include <iostream.h>
#include <conio.h>
class space
{
	int x,y,z;
	public:
	space()
	{
		x=10;
		y=26;
		z=30;
	}
	void operator ++()
	{
		x++;
		y++;
		z++;
	}
	void show()
	{
		cout<<"\nx ="<<x;
		cout<<"\ny ="<<y;
		cout<<"\nz ="<<z;
	}
};
void main()
{
	space s;
	++s;
	s.show();
	getch();
}
