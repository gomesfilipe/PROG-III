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
    Election(vector<Candidate*>& candidates, const vector<PoliticParty*>& partys, const string& date);

    /**
     * @brief Calculates how many candidates were elected in a election.
     * @return Quantity of elected candidates.
     */
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
    /**
     * @brief Fill the vector of candidates of each party at a vector of parties.
     * @param candidates Vector of candidates.
     * @param partys Vector os parties.
     */
    static void insert_candidates_in_partys(vector<Candidate*> candidates, vector<PoliticParty*> partys);
    
    /**
     * @brief Initializes the party of each candidate.
     * @param candidates Vector of candidates.
     * @param partys Vector os parties.
     */
    static void insert_partys_in_candidates(vector<Candidate*> candidates, vector<PoliticParty*> partys);
    
    /**
     * @brief Search a party at a vector of parties.
     * @param partys Vector of parties.
     * @param key Number of parties.
     * @return Pointer to a PoliticParty. Case the key doesn't exist, returns NULL. 
     */
    static PoliticParty* search_party(vector<PoliticParty*> partys, int key);
};

#endif
