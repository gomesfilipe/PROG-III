#include <string>
#include <iostream>
using namespace std;
// #include "Candidate.h"
// #include "Election.h"
#include "../include/Person.h"
// #include "PoliticParty.h"
// #include "Read.h"
// #include "Utils.h"

int main() {
    Person p("filipe", 'm', "20/09/2000");

    cout << p;

    cout << "minha idade eh " << p.age_at("19/09/2021") << endl;
    
    
    return 0;
}
