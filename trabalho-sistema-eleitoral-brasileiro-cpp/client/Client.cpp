#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
#include "../include/Person.h"
#include "../include/Candidate.h"
#include "../include/PoliticParty.h"
#include "../include/Election.h"
#include "../include/Read.h"
#include "../include/Utils.h"

using namespace std;
using namespace cpp_util;

int main(int argc, char** argv) {
    if(argc != 4) {
        cout << "Incorrect number of parameters." << endl;
    }
    
    string candidates_file = argv[1];
    string partys_file = argv[2];
    string date_election = argv[3];
    
    vector<PoliticParty*> partys = read_politic_party(partys_file);
    vector<Candidate*> candidates = read_candidate(candidates_file);

    // sort(candidates.begin(), candidates.end(), comparator_candidates);
    // sort(partys.begin(), partys.end(), comparator_legend_votes);
    // sort(candidates.begin(), candidates.end(), comparator_candidates);


    Election e(candidates, partys, date_election);

    // e.report_1();  // ok
    // e.report_2();  // ok
    // e.report_3();  // ok
    // e.report_4();  // ok
    e.report_5();
    // e.report_6();
    // e.report_7();
    // e.report_8();
    // e.report_9();  // ok
    // e.report_10(); // ok
    // e.report_11(); // ok

    for(PoliticParty* p : partys) {
        // cout << *p;
        delete p;
    }

    for(Candidate* c : candidates) {
        // cout << *c;
        delete c;
    }

    return 0;
}

// Dúvidas:
// Métodos static em c++
// Se colocar métodos privados na classe, tem que colocar os parâmetros nessa parte também?
// Ordenação (fiz comparados entre candidatos, mas vetor é de ponteiros para candidato).
// Ver se só nos campos das classes que devem ter ponteiros.
// Conferir Makefile

//TODO
// Verificar se os true e false estão corretos nas funções de comparação.
// Como usar função sort?
// Terminar relatórios
// Exceções
