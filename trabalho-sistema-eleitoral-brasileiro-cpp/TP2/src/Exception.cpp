#include "../include/Exception.h"

Exception::Exception(const string& reason) {
    this->reason = reason;
}

ostream& operator<<(ostream& out, const Exception& exception) {
    return out << exception.reason;
}
