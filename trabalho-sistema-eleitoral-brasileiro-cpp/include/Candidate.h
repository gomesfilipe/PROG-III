#ifndef CANDIDATE_H_
#define CANDIDATE_H_

#include <string>
#include <iostream>
#include <vector>
#include <algorithm>

#include "Person.h"
using namespace std;

class PoliticParty;

class Candidate: public Person {
    string balboxName;
    int balboxNumber;
    int nominalVotes;
    string situation;
    int partyNumber;
    string voteDestination;
    PoliticParty* party;

public:
    Candidate(const string& name, char gender, const string& birth, const string& balBoxName, int balBoxNumber, int nominalVotes, const string& situation, int partyNumber, const string& voteDestination);

    const string& get_balbox_name() const;
    int get_balbox_number() const;
    int get_nominal_votes() const;
    const string& get_situation() const;
    int get_party_number() const;
    const string& get_vote_destination() const;
    PoliticParty* get_party() const;

    void set_party(PoliticParty* party);

    bool elected() const;
    bool valid_vote() const;

    friend ostream& operator<<(ostream& out, const Candidate& candidate);
};

bool comparator_candidates(const Candidate* m, const Candidate* n);

#endif
