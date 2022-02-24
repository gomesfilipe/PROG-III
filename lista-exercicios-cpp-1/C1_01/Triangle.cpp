#include "Triangle.h"

Triangle:: Triangle(double x1, double y1, double x2, double y2, double x3, double y3): p1(x1, y1), p2(x2, y2), p3(x3, y3){}

void Triangle::print() const {
    this->p1.print();
    this->p2.print();
    this->p3.print();
}

double Triangle::perimeter() const {
    return this->p1.distance(this->p2) + this->p2.distance(this->p3) + this->p3.distance(this->p1);
}