#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
#include "../include/DateUtils.h"
#include "../include/Read.h"
#include "../include/Election.h"

using namespace std;
using namespace cpp_util;

int main(int argc, char** argv) {
    if(argc != 4) {
        cout << "Incorrect number of parameters." << endl;
        exit(1);
    }
    
    string candidates_file = argv[1];
    string partys_file = argv[2];
    string date_election = argv[3];

    try {
        if(!validDate(date_election, "%d/%m/%Y")) throw date_election;

    } catch(string e) {
        cerr << "[" << e << "] is not a valid date." << endl;
        exit(1);
    }
    
    vector<PoliticParty*> partys = read_politic_party(partys_file);
    vector<Candidate*> candidates = read_candidate(candidates_file);

    Election e(candidates, partys, date_election);

    e.report_1(); 
    e.report_2(); 
    e.report_3(); 
    e.report_4(); 
    e.report_5(); 
    e.report_6(); 
    e.report_7(); 
    e.report_8(); 
    e.report_9(); 
    e.report_10();
    e.report_11();

    for(PoliticParty* p : partys) delete p;
    for(Candidate* c : candidates) delete c;
    
    return 0;
}

//TODO
// Fazer exceções
// Verificar problema do \r\n no test.sh

