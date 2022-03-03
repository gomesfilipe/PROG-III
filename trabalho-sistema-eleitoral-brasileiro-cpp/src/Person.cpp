#include "../include/Person.h"

Person::Person(const string& name, char gender, const string& birth) {
    this->name = name;
    this->gender = gender;
    this->birth = birth;
}

const string& Person::get_name() const {
    return this->name;
}

char Person::get_gender() const {
    return this->gender;
}

const string& Person::get_birth() const {
    return this->birth;
}

int Person::age() const {
    return 0;
}

ostream& operator<<(ostream& out, const Person& person) {
    out << person.name << endl;
    out << person.gender << endl;
    out << person.birth << endl;
    return out;
}