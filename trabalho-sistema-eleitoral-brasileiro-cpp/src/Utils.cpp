#include "../include/Utils.h"

namespace cpp_util {

double percent(double value, double total) {
    if(total == 0) return -1;
    return value / total * 100.0;
}

}
