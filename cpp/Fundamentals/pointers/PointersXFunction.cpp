#include <iostream>

void displayMessage() {
    std::cout << "Hello from the function!" << std::endl;
}

int main() {
    void (*p)();  
    // declaring a function pointer

    p = &displayMessage;
      //assigning address of the function to the pointer

    (*p)(); //Calling the function using the pointer

    return 0;
}