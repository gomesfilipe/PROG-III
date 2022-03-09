#ifndef POLITICPARTY_H_
#define POLITICPARTY_H_

#include <string>
#include <iostream>
#include <vector>
#include <algorithm>
#include "Candidate.h"
using namespace std;

class PoliticParty {
    string name;
    string abreviation;
    int number;
    int legendVotes;
    vector<Candidate*> candidates;

public:
    PoliticParty(const string& name, const string& abreviation, int number, int legendVotes);

    const string& get_name() const;
    const string& get_abreviation() const;
    int get_number() const;
    int get_legend_votes() const;
    vector<Candidate*> get_candidates() const;

    void add_candidate(Candidate* candidate);

    int qtd_nominal_votes() const;
    int qtd_elected() const;
    int qtd_total_votes() const;

    friend ostream& operator<<(ostream& out, const PoliticParty& politicParty);
};

bool comparator_legend_votes(const PoliticParty* m , const PoliticParty* n);
bool comparator_nominal_votes(const PoliticParty* m , const PoliticParty* n);
bool comparator_total_votes(const PoliticParty* m , const PoliticParty* n);

#endif
