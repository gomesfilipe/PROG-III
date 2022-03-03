#ifndef PERSON_H_
#define PERSON_H_

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

    int age_at(const string& date) const;

    friend ostream& operator<<(ostream& out, const Person& person);
};

#endif
