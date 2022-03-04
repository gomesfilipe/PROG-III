#include <string>
#include <iostream>
#include "../include/Person.h"
#include "../include/Candidate.h"
#include "../include/PoliticParty.h"
#include "../include/Election.h"
#include "../include/Read.h"
#include "../include/Utils.h"

using namespace std;
using namespace cpp_util;

int main() {
    Person p("filipe", 'm', "20/09/2000");
    cout << p;
    cout << "minha idade eh " << p.age_at("19/09/2021") << endl;
    return 0;
}
