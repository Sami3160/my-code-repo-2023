#include<iostream>
using namespace std;
class a{
  public:
  virtual void display()=0;
};

class b:public a{
  public:
  void display(){
    cout<<"using virtual function";
  };
};


int main(){
	int n=8;
  for (int i = 5; i <= n; i++) {
    for (int j = i; j <= n; j++) {
      cout << j;
    }
    cout << endl;
  }

  return 0;
}
