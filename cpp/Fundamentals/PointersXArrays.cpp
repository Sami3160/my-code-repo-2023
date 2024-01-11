#include <iostream>

int main() {
    int numbers[5] = {1, 2, 3, 4, 5};
    int* p;

      // pointing to the start of the array
    p = numbers;

    for(int i = 0; i < 5; i++) {
        std::cout << "Address: " << p << ", Value: " << *p << std::endl;
        p++; //incrementing the pointer to point to next element
    }

    return 0;
}