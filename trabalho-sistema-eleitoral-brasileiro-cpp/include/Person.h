#ifndef PERSON_H_
#define PERSON_H_

#include <ctime>
#include <string>
#include <iostream>
using namespace std;

class Person {
    string name;
    char gender;
    // data de nascimento (pesquisar)

public:
    Person(string name, char gender, string date);

    const string& get_name() const;
    char get_gender() const;
    // get_birth() const;

};

#endif
