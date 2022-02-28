#ifndef WORKER_H
#define WORKER_H

#include <stdio.h>
#include <iostream>
#include <string>
using namespace std;

class Department;

class Worker {
    string name;
    double salary;
    string admission;
    Department* department;

public:
    Worker(const string& name, double salary, const string& date);

    const string& get_name() const;
    double get_salary() const;
    const string& get_admission() const;
    void set_department(Department* department);
    void up_salary(double percent);
    void print() const; 
};

#endif
