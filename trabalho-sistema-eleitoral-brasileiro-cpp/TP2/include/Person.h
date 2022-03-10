#ifndef PERSON_H_
#define PERSON_H_

#include <algorithm>
#include <vector>
#include <ctime>
#include <string>
#include <iostream>
// #include "Tokenizer.h"
#include "DateUtils.h"
using namespace std;
using namespace cpp_util;

class Person {
    string name;
    char gender;
    time_t birth;

public:
    Person(const string& name, char gender, const string& birth);

    const string& get_name() const;
    char get_gender() const;
    time_t get_birth() const;

    /**
     * @brief Calculates the person's age at a specific date.
     * @param date time_t which represents a specific date.
     * @return Person's age in years. 
     */
    int age_at(const time_t& date) const;
    
    /**
     * @brief Calculates the person's age at a specific date.
     * @param date String which represents a specific date.
     * @return Person's age in years. 
     */
    int age_at(const string& date) const;

    friend ostream& operator<<(ostream& out, const Person& person);
};

#endif
