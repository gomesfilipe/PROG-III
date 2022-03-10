#include "../include/PoliticParty.h"
// #include "PoliticParty.h"

PoliticParty::PoliticParty(const string& name, const string& abreviation, int number, int legendVotes) {
    this->name = name;
    this->abreviation = abreviation;
    this->number = number;
    this->legendVotes = legendVotes;
}

const string& PoliticParty::get_name() const {
    return this->name;
}

const string& PoliticParty::get_abreviation() const {
    return this->abreviation;
}

int PoliticParty::get_number() const {
    return this->number;
}

int PoliticParty::get_legend_votes() const {
    return this->legendVotes;
}

const vector<Candidate*>& PoliticParty::get_candidates() const {
    return this->candidates;
}

int PoliticParty::qtd_nominal_votes() const {
    int nominal_votes = 0;
    for(Candidate* c : this->get_candidates()) {
        if(c->valid_vote()) nominal_votes += c->get_nominal_votes();
    }
    return nominal_votes;
}

int PoliticParty::qtd_elected() const {
    int qtd_elected = 0;
    for(Candidate* c : this->get_candidates()) {
        if(c->elected()) qtd_elected++;
    }
    return qtd_elected;
}

int PoliticParty::qtd_total_votes() const {
    return this->qtd_nominal_votes() + this->get_legend_votes();
}

void PoliticParty::add_candidate(Candidate* candidate) {
    this->candidates.push_back(candidate);
}

Candidate* PoliticParty::more_nominal_votes() const {
    Candidate* more = NULL;
    for(Candidate* c : this->candidates) {
        if((more == NULL || c->get_nominal_votes() > more->get_nominal_votes()) && c->valid_vote()) more = c;
        if((c->get_nominal_votes() == more->get_nominal_votes()) && c->valid_vote()) more = c->get_birth() >= more->get_birth() ? c : more; //!ERRO TA AQUI
    }

    return more;
}

ostream& operator<<(ostream& out, const PoliticParty& politicParty) {
    out << "Name: " << politicParty.name << endl;
    // out << "Abreviation: " << politicParty.abreviation << endl;
    // out << "Number: " << politicParty.number << endl;
    // out << "LegendVotes: " << politicParty.legendVotes << endl;
    
    return out;
}

bool comparator_legend_votes(const PoliticParty* m , const PoliticParty* n) {
    int legend_mvotes = m->get_legend_votes();
    int legend_nvotes = n->get_legend_votes();
    
    if(legend_mvotes == legend_nvotes) {
        int nominal_nvotes = n->qtd_nominal_votes();
        int nominal_mvotes = m->qtd_nominal_votes();
        
        if(nominal_nvotes == nominal_mvotes){
            return m->get_number() - n->get_number() < 0 ? true : false; 
        }
        else{
            return nominal_nvotes - nominal_mvotes < 0 ? true : false;
        }

    } else {
        return legend_nvotes - legend_mvotes < 0 ? true : false;
    }
}

bool comparator_nominal_votes(const PoliticParty* m , const PoliticParty* n) {
    vector<Candidate*> mvector = m->get_candidates();
    vector<Candidate*> nvector = n->get_candidates();
   
    // Candidate* cm = m->more_nominal_votes();
    // Candidate* cn = n->more_nominal_votes();

    int nominal_mvotes = 0;
    int nominal_nvotes = 0;

    for(Candidate* c : mvector) {
        nominal_mvotes  = c->get_nominal_votes();
        if(c->valid_vote()) {
            break;
        }
    }
    
    for(Candidate* c : nvector) {
        nominal_nvotes  = c->get_nominal_votes();
        if(c->valid_vote()) {
            break;
        }    
    }
    
    // int nominal_mvotes = cm->get_nominal_votes();
    // int nominal_nvotes = cn->get_nominal_votes();
    
    if(nominal_mvotes == nominal_nvotes) {
        return m->get_number() - n->get_number() < 0 ? true : false; 
    } else {
        return nominal_nvotes - nominal_mvotes < 0 ? true : false;
    }
}

bool comparator_total_votes(const PoliticParty* m , const PoliticParty* n) {
    int total_mvotes = m->qtd_total_votes();
    int total_nvotes = n->qtd_total_votes();

    if(total_mvotes == total_nvotes) {
        return n->get_number() - m->get_number() < 0 ? true : false; 
    } else {
        return total_nvotes - total_mvotes < 0 ? true : false;
    }
}
