#include "Department.h"

Department::Department(const string& name) {
    this->name = name;
}
        
const string& Department::get_name() const {
    return this->name;
}

Worker* Department::get_worker(int index) const {
    return this->workers[index];
}

void Department::add(Worker* worker) {
    worker->set_department(this);
    // worker->department = this;
    this->workers.push_back(worker);
}

void Department::up_salary(double percent) {
    for(auto w : this->workers) {
        w->up_salary(percent);
    }
}

void Department::remove(int index) {
    this->workers.erase(begin(this->workers) + index);
}

double Department::cost() const {
    double total = 0.0;
    for(auto w : this->workers) {
        total += w->get_salary();
    }

    return total;
}

void Department::print() const {
    cout << this->name << "\n";

    for(auto w : this->workers) {
        w->print();
    }
}

Department::~Department() {
    for(auto w : this->workers) {
        delete w;
    }
}
