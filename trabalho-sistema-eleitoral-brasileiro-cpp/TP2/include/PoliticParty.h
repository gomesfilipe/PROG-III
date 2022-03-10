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
    const vector<Candidate*>& get_candidates() const;

    /**
     * @brief Calculates the quantity of nominal votes in a politic party.
     * @return Quantity of nominal votes.
     */
    int qtd_nominal_votes() const;

    /**
     * @brief Calculates the quantity of elected candidates in a politic party.
     * @return Quantity of elected candidates.
     */
    int qtd_elected() const;

    /**
     * @brief Calculates the total quantity of votes in a party (legend votes + nominal votes). 
     * @return total Quantity of votes in a party.
     */
    int qtd_total_votes() const;

    /**
     * @brief Add a candidate pointer at the vector of candidates in a party.
     * @param candidate Candidate pointer which will be added in the vector.
     */
    void add_candidate(Candidate* candidate);

    /**
     * @brief Finds the candidate with the most quantity of nominal votes in a party.
     * @return Candidate pointer with the most quantity of nominal votes.
     */
    Candidate* more_nominal_votes() const;

    friend ostream& operator<<(ostream& out, const PoliticParty& politicParty);
};

/**
 * @brief Compares two party pointers according their legend votes.
 * @param m One of elements which will be comparated.
 * @param n One of elements which will be comparated.
 * @return true if m < n.
 * @return false if m >= n.
 */
bool comparator_legend_votes(const PoliticParty* m , const PoliticParty* n);

/**
 * @brief Compares two party pointers according their nominal votes.
 * @param m One of elements which will be comparated.
 * @param n One of elements which will be comparated.
 * @return true if m < n.
 * @return false if m >= n.
 */
bool comparator_nominal_votes(const PoliticParty* m , const PoliticParty* n);

/**
 * @brief Compares two party pointers according their total votes.
 * @param m One of elements which will be comparated.
 * @param n One of elements which will be comparated.
 * @return true if m < n.
 * @return false if m >= n.
 */
bool comparator_total_votes(const PoliticParty* m , const PoliticParty* n);

#endif
