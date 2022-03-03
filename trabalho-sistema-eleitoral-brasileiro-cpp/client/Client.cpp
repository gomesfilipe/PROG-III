#include <string>
#include <iostream>
using namespace std;
// using namespace cpp_util;
// #include "../include/Candidate.h"
// #include "../include/Election.h"
#include "../include/Person.h"
// #include "../include/PoliticParty.h"
// #include "../include/Read.h"
#include "../include/Utils.h"
using namespace cpp_util;

int main() {
    Person p("filipe", 'm', "20/09/2000");

    cout << p;

    cout << "minha idade eh " << p.age_at("19/09/2021") << endl;
    
    double k = percent(20.0, 300.0);

    cout << k << '%' << endl;

    return 0;
}
