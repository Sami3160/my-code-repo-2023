#include <iostream>
#include <stdexcept>

void foo() {
    try {
        // Attempting an operation that may throw an exception
        throw std::runtime_error("Exception in foo()");
    } catch (const std::exception& e) {
        // Catching the exception and providing information
        std::cerr << "Caught exception in foo(): " << e.what() << std::endl;
        // Rethrowing the caught exception to the calling function
        throw;
    }
}

int main() {
    try {
        // Calling a function that may throw an exception
        foo();
    } catch (const std::exception& e) {
        // Catching the exception thrown by the called function
        std::cerr << "Caught exception in main(): " << e.what() << std::endl;
    }

    return 0;
}
