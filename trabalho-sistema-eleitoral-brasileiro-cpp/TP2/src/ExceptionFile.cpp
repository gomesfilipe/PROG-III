#include "../include/ExceptionFile.h"

ExceptionFile::ExceptionFile(const string& reason): Exception(reason) {}

void file_not_found_exception() {
    throw ExceptionFile("File not found.");
}
