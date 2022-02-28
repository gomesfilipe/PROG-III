#ifndef DEPARTMENT_H
#define DEPARTMENT_H

#include <string>
#include <vector>
#include "Worker.h"
#include <iostream>
using namespace std;

class Department {
    string name;
    vector<Worker*> workers;

public:
    Department(const string& name);
    const string& get_name() const;
    Worker* get_worker(int index) const; // Cuidado ao retorna como ponteiro.
    void add(Worker* worker);
    void up_salary(double percent);
    void remove(int index);
    double cost() const;
    void print() const;
    ~Department();
};

#endif
