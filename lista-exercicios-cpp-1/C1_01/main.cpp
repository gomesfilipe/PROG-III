#include <stdio.h>
#include <iostream>
using namespace std;
#include "point.h"
#include "triangle.h"

int main() {
    double x1, y1; 
    double x2, y2; 
    double x3, y3;

    cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;

    Triangle t(x1, y1, x2, y2, x3, y3);

    printf("%.5f\n", t.perimeter());

    return 0;
};