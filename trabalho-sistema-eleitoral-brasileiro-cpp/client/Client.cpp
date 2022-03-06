#include <string>
#include <iostream>
#include <vector>
#include "../include/Person.h"
#include "../include/Candidate.h"
#include "../include/PoliticParty.h"
#include "../include/Election.h"
#include "../include/Read.h"
#include "../include/Utils.h"

using namespace std;
using namespace cpp_util;

int main() {
    // vector<PoliticParty*> partys = read_politic_party("partidos.csv");
    vector<Candidate*> candidates = read_candidate("candidatos.csv");
    for(Candidate* c : candidates) {
        cout << *c;
    }

    sort(candidates.begin(), candidates.end());

    // Election e(candidates, partys, "15/11/2020");

    for(Candidate* c : candidates) {
        cout << *c;
        delete c;
    }

    // for(PoliticParty* p : partys) {
    //     cout << *p;
    //     delete p;
    // }

    return 0;
}

// Dúvidas:
// Métodos static em c++
// Se colocar métodos privados na classe, tem que colocar os parâmetros nessa parte também?
// Ordenação (fiz comparados entre candidatos, mas vetor é de ponteiros para candidato).
// Ver se só nos campos das classes que devem ter ponteiros.
