#include <iostream>

// Function that throws an exception
void divide(int numerator, int denominator) {
    //check if denominator is zero
    if (denominator == 0) {
        //throw exception explicitly before exception occure at line:12
        throw std::runtime_error("Error: Division by zero is not allowed");
    }

    int result = numerator / denominator;
    std::cout << "Result of division: " << result << std::endl;
}

int main() {
    try {
        // Call the function with different inputs, including division by zero
        divide(10, 2);   // Valid division
        divide(8, 0);    // Division by zero, will throw an exception
        divide(15, 3);   // Another valid division
    } catch (const std::exception& e) {
        // Catch the exception and print the error message
        std::cerr << "Exception caught: " << e.what() << std::endl;
        //program will terminate after this
    }

    return 0;
}
//note cerr<< is basically used to show error