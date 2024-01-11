#include <iostream>

int main() {
    int x = 10;  //normal integer variable
    int* p;// a pointer variable that can point to type int

    p = &x; // assigning the address of x to p

    std::cout << "Value of x: " << x << std::endl;
    std::cout << "Address of x: " << &x << std::endl;
    std::cout << "Value of p: " << p << std::endl;
    std::cout << "Value pointed by p: " << *p << std::endl;

    return 0;
}