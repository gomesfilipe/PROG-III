#ifndef EXCEPTIONDATE_H_
#define EXCEPTIONDATE_H_

#include "Exception.h"
#include <iostream>
#include <string>
#include <exception>

class ExceptionDate: public Exception {
    
public:
    ExceptionDate(const string& reason);
};

void invalid_date_exception();

#endif
