#ifndef ELECTION_H_
#define ELECTION_H_

#include <vector>
#include <string>
#include <iostream>
using namespace std;
#include "NumberUtils.h"
#include "PoliticParty.h"
#include "Candidate.h"
#include "Utils.h"

class Election {
    vector<Candidate*> candidates;
    vector<PoliticParty*> partys;
    time_t date;

public:
    Election(vector<Candidate*>& candidates, vector<PoliticParty*>& partys, const string& date);

    int qtd_elected() const;

    void report_1() const;
    void report_2() const;
    void report_3() const;
    void report_4() const;
    void report_5() const;
    void report_6() const;
    void report_7() const;
    void report_8() const;
    void report_9() const;
    void report_10() const;
    void report_11() const;

private:
    static void insert_candidates_in_partys(vector<Candidate*> candidates, vector<PoliticParty*> partys);
    static void insert_partys_in_candidates(vector<Candidate*> candidates, vector<PoliticParty*> partys);
    static PoliticParty* search_party(vector<PoliticParty*> partys, int key);

};


#endif
