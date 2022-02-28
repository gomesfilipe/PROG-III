#ifndef COMPANY_H
#define COMPANY_H

#include <string>
#include <vector>
#include "Department.h"

class Company {
    string name;
    string cnpj;
    vector<Department*> departments;

public:
    Company(const string& name, const string& cnpj);
    void add(Department* department);
    void up_salary(const int index, const double percent);
    void transfer(const int from, const int worker_id, const int to);
    void print() const;
    ~Company();
    void print_departments_costs() const;
};

#endif
