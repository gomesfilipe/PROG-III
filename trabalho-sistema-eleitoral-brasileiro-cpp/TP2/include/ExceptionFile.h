#ifndef EXCEPTIONFILE_H_
#define EXCEPTIONFILE_H_

#include "Exception.h"
#include <exception>
#include <iostream>
#include <string>
using namespace std;

class ExceptionFile: public Exception {

public:
    ExceptionFile(const string& reason);
};

void file_not_found_exception();

#endif