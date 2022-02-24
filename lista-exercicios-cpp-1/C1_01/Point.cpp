#include "Point.h"

Point::Point(double x, double y) {
    this->x = x;
    this->y = y;
}

void Point::print() const {
    cout << "(" << this->x << ", " << this->y << ")\n";
}

double Point::distance(const Point& point) const {
    return sqrt((this->x - point.x) * (this->x - point.x) + (this->y - point.y) * (this->y - point.y));
}
