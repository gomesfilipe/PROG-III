#include "../include/ExceptionDate.h"

ExceptionDate::ExceptionDate(const string& reason): Exception(reason) {}

void invalid_date_exception() {
    throw ExceptionDate("Invalid Date.");
}
