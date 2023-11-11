#include <iostream>
using namespace std;
int main() {
    int a=10,b=2;
    try {
        // Call the function with different inputs, including division by zero
        cout<<"\n"<<a/b;   // Valid division
        //denominator value intentionally changed
        b=0;
        cout<<"\n"<<(a/b);// Division by zero, will throw an exception
        b=5;
        cout<<"\n"<<(a/b);// Another valid division
    } catch (const exception& e) {
        // Catch the exception and print the error message
        cerr << "Exception caught: " << e.what() << "\n";
        //program will terminate after this
    }

    return 0;
}
//note cerr<< is basically used to show error