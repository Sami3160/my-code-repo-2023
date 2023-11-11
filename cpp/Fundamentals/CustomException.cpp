#include <iostream>
#include <stdexcept>

// Custom exception class derived from std::exception
class CustomException : public std::exception {
public:
    const char* what() const noexcept override {
        return "This is a custom exception!";
    }
};

// Function that throws a custom exception
void functionWithCustomException() {
    throw CustomException();
}

int main() {
    try {
        // Try block to catch exceptions
        functionWithCustomException();
    } catch (const std::exception& e) {
        // Catch block for std::exception and its derived classes
        std::cerr << "Exception caught: " << e.what() << std::endl;
    }

    // Custom Exception Example End

           return 0;
}
