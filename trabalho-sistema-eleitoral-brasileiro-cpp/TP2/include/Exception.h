#ifndef EXCEPTION_H_
#define EXCEPTION_H_

#include <exception>
#include <iostream>
#include <string>
using namespace std;

class Exception {
    string reason;

public:
    Exception(const string& reason);

    friend ostream& operator<<(ostream& out, const Exception& exception);
};

#endif
