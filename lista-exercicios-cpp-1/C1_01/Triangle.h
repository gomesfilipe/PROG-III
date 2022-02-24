#ifndef TRIANGLE_H
#define TRIANGLE_H

#include <stdio.h>
#include "point.h"
#include <iostream>
using namespace std;

class Triangle {
    Point p1;
    Point p2;
    Point p3;

    public:
        Triangle(double x1, double y1, double x2, double y2, double x3, double y3);

        void print() const;

        double perimeter() const;
};

#endif
