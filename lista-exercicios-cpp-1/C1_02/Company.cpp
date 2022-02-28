#include "Company.h"

Company::Company(const string& name, const string& cnpj) {
    this->name = name;   
    this->cnpj = cnpj;   
}

void Company::add(Department* department) {
    this->departments.push_back(department);
}

void Company::up_salary(const int index, const double percent) {
    this->departments[index]->up_salary(percent);
}

void Company::transfer(const int from, const int worker_id, const int to) {
    Worker* worker = this->departments[from]->get_worker(worker_id);
    this->departments[to]->add(worker);
    this->departments[from]->remove(worker_id);
}

void Company::print() const {
    cout << this->name << " ";
    cout << this->cnpj << "\n";
    
    for(auto d : this->departments) {
        d->print();
    }
}

Company::~Company() {
    for(auto d : this->departments) {
        delete d;
    }
}

void Company::print_departments_costs() const {
    for(auto d : this->departments) {
        cout << d->get_name() << " " << d->cost() << "\n";
    }
}