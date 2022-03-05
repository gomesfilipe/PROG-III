#include "../include/Candidate.h"

Candidate::Candidate(const string& name, char gender, const string& birth, const string& balboxName, int balboxNumber, int nominalVotes, const string& situation, int partyNumber, const string& voteDestination): Person(name, gender, birth) {
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

const string& Candidate::get_situation() const {
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

ostream& operator<<(ostream& out, const Candidate& candidate) {
    // acessar classe mãe, pesquisar
    out << candidate.get_name()<< endl;
    // out << candidate.get_gender() << endl;
    // out << formatDate(candidate.get_birth(), "%d/%m/%Y") << endl;
    // out << candidate.balboxName << endl;
    // out << candidate.balboxNumber << endl;
    // out << candidate.nominalVotes << endl;
    // out << candidate.situation << endl;
    // out << candidate.partyNumber << endl;
    // out << candidate.voteDestination << endl;

    return out;
}

bool Candidate::operator<(const Candidate& candidate) {
    if(candidate.nominalVotes == this->nominalVotes) {
        time_t birth1 = this->get_birth();
        time_t birth2 = candidate.get_birth();

        if(birth1 < birth2) return true;
        else return false;
    
    } else {
        if(candidate.nominalVotes > this->nominalVotes) return false;
        else return true;
    }
}
