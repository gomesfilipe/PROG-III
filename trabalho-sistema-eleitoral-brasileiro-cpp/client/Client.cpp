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
    Candidate c("filipe", 'm', "20/09/2000", "filipin", 10, 1000, "Eleito", 30, "Válido");
    Candidate d("filipa", 'f', "18/02/2001", "filipinha", 100, 10000, "Eleito", 40, "Válido");

    cout << c;

    return 0;
}
