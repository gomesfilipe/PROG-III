#ifndef UTILS_H_
#define UTILS_H_

#include <string>
#include <iostream>
using namespace std;

namespace cpp_util {

/**
 * @brief Calculates the percentage of a value in relation to a total.
 * @param value Value which will be calculated the percentage.
 * @param total Total value.
 * @return Percentage.
 */
double percent(double value, double total);

}

#endif
