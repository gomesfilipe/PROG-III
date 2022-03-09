#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
#include "../include/Read.h"
#include "../include/Election.h"

using namespace std;
using namespace cpp_util;

int main(int argc, char** argv) {
    if(argc != 4) {
        cout << "Incorrect number of parameters." << endl;
        return 0;
    }
    
    string candidates_file = argv[1];
    string partys_file = argv[2];
    string date_election = argv[3];
    
    vector<PoliticParty*> partys = read_politic_party(partys_file);
    vector<Candidate*> candidates = read_candidate(candidates_file);

    Election e(candidates, partys, date_election);

    e.report_1();  // ok
    e.report_2();  // ok
    e.report_3();  // ok
    e.report_4();  // ok
    e.report_5();  // ok
    e.report_6();  // ok
    e.report_7();  // ok
    e.report_8();  // ok
    e.report_9();  // ok
    e.report_10(); // ok
    e.report_11(); // ok

    for(PoliticParty* p : partys) delete p;
    for(Candidate* c : candidates) delete c;
    
    return 0;
}

// Dúvidas:
// Métodos static em c++.
// Se colocar métodos privados na classe, tem que colocar os parâmetros nessa parte também?
// Ordenação (fiz comparados entre candidatos, mas vetor é de ponteiros para candidato).
// Ver se só nos campos das classes que devem ter ponteiros.
// Conferir Makefile.

//TODO
// Verificar se os true e false estão corretos nas funções de comparação.
// Exceções.
