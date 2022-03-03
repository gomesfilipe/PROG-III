#ifndef PERSON_H_
#define PERSON_H_

#include <ctime>
#include <string>
#include <iostream>
// #include "Tokenizer.h"
// #include "DateUtils.h"
using namespace std;

class Person {
    string name;
    char gender;
    // struct dm birth;// data de nascimento (pesquisar)
    string birth;// data de nascimento (pesquisar)

public:
    Person(const string& name, char gender, const string& birth);

    const string& get_name() const;
    char get_gender() const;
    // struct dm get_birth() const;
    const string& get_birth() const;

    int age() const;

    friend ostream& operator<<(ostream& out, const Person& person);
};

#endif
