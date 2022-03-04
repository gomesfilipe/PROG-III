#include "../include/Candidate.h"

Candidate::Candidate(const string& name, char gender, const string& birth, const string& balBoxName, int balBoxNumber, int nominalVotes, const string& situation, int partyNumber, const string& voteDestination): Person(name, gender, birth) {
    this->balboxName = balboxName;
    this->balboxNumber = balboxNumber;
    this->nominalVotes = nominalVotes;
    this->situation = situation;
    this->partyNumber = partyNumber;
    this->voteDestination = voteDestination;
}

const string& Candidate::get_balbox_name() const {
    return this->balboxName;
}

int Candidate::get_balbox_number() const {
    return this->balboxNumber;
}

int Candidate::get_nominal_votes() const {
    return this->nominalVotes;
}

const string& Candidate::get_situation()) const {
    return this->situation;
}

int Candidate::get_party_number() const {
    return this->partyNumber;
}

const string& Candidate::get_vote_destination() const {
    return this->voteDestination;
}

// get party

// set party

bool Candidate::elected() const {
    return this->get_situation() == "Eleito";
}

bool Candidate::valid_vote() const {
    return this->get_vote_destination() == "Válido";
}

friend ostream& operator<<(ostream& out, const Person& person) {
    // acessar classe mãe, pesquisar 
    out << this->balboxName << endl;
    out << this->balboxNumber << endl;
    out << this->nominalVotes << endl;
    out << this->situation << endl;
    out << this->partyNumber << endl;
    out << this->voteDestination << endl;

    return out;
}

friend int operator<(const Person& person) {

}
