#ifndef ELECTION_H_
#define ELECTION_H_

#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

#include "NumberUtils.h"
#include "PoliticParty.h"
#include "Candidate.h"
#include "Utils.h"
using namespace std;

class Election {
    vector<Candidate*> candidates;
    vector<PoliticParty*> partys;
    time_t date;

public:
    Election(const vector<Candidate*>& candidates, const vector<PoliticParty*>& partys, const string& date);

    int qtd_elected() const;

    void report_1() const;
    void report_2();
    void report_3();
    void report_4();
    void report_5();
    void report_6();
    void report_7();
    void report_8();
    void report_9() const;
    void report_10() const;
    void report_11() const;

private:
    static void insert_candidates_in_partys(vector<Candidate*> candidates, vector<PoliticParty*> partys);
    static void insert_partys_in_candidates(vector<Candidate*> candidates, vector<PoliticParty*> partys);
    static PoliticParty* search_party(vector<PoliticParty*> partys, int key);
};

#endif
