#ifndef POINT_H
#define POINT_H

#include <stdio.h>
#include <math.h>
#include <iostream>
using namespace std;

class Point {
    double x;
    double y;

    public:
        // Point(double x = 0, double y = 0); // Construtor default.
        Point(double x, double y); // Construtor com parâmetros.

        void print() const; // Argumento f é default.

        double distance(const Point& point) const; // Passagem por referência e const pois não pode mudar o objeto.
};

#endif
