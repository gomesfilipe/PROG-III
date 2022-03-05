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
    vector<PoliticParty*> partys = read_politic_party("partidos.csv");
    vector<Candidate*> candidates = read_candidate("candidatos.csv");

    for(Candidate* c : candidates) {
        cout << *c;
        delete c;
    }

    for(PoliticParty* p : partys) {
        cout << *p;
        delete p;
    }

    return 0;
}
