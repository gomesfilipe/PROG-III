#include "Worker.h"
#include "Department.h"

Worker::Worker(const string& name, double salary, const string& admission) {
    this->name = name;
    this->salary = salary;
    this->admission = admission;
    this->department = NULL;
}

const string& Worker::get_name() const {
    return this->name;
}

double Worker::get_salary() const {
    return this->salary;
}

const string& Worker::get_admission() const {
    return this->admission;
}

void Worker::set_department(Department* department) {
    this->department = department;
}

void Worker::up_salary(double percent) {
    this->salary += this->salary * percent / 100.00;
}

void Worker::print() const {
    cout << this->name << " ";
    cout << this->salary << " ";
    cout << this->admission << "\n";
} 
