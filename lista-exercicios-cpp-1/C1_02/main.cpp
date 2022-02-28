#include <stdio.h>
#include <string>
#include <iostream>
using namespace std;
#include "Worker.h"
#include "Department.h"
#include "Company.h"

Worker* read_worker();
Department* read_department();
Company* read_company();

int main() {
    Company* c = read_company();

    c->print_departments_costs();

    c->up_salary(0, 10);
    c->transfer(0, 0, 1);
    c->print_departments_costs();

    delete c;
    return 0;
}

Worker* read_worker() {
    string worker_name, admission;
    double salary;
    cin >> worker_name >> salary >> admission;

    Worker* w = new Worker(worker_name, salary, admission);
    return w;
}

Department* read_department() {
    string department_name;
    int workers_quantity;

    cin >> department_name >> workers_quantity;
        
    Department* d = new Department(department_name);

    for(int i = 0; i < workers_quantity; i++) {
        Worker* w = read_worker();
        d->add(w);
    }

    return d;
}

Company* read_company() {
    string company_name, cnpj;
    int departments_quantity;

    cin >> company_name >> cnpj >> departments_quantity;

    Company* c = new Company(company_name, cnpj);

    for(int i = 0; i < departments_quantity; i++) {
        Department* d = read_department();
        c->add(d);

    }

    return c;
}
