#include <iostream>

int main() {
    int* p = new int;  //Allocating memory dynamically

    *p = 10;
      //assigning value to the allocated memory

    std::cout << "Value in the dynamically allocated memory: " << *p << std::endl;

    delete p;  
    //Deallocating the memory

    return 0;
}