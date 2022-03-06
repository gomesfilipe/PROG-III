#include "../include/Election.h"

Election::Election(vector<Candidate*>& candidates, vector<PoliticParty*>& partys, const string& date) {
    insert_candidates_in_partys(candidates, partys);
    insert_partys_in_candidates(candidates, partys);
    
    this->candidates = candidates;
    this->partys = partys;
    this->date = parseDate(date, "%d/%m/%Y");
}

int Election::qtd_elected() const {
    int qtd_elected = 0;

    for(PoliticParty* p : this->partys) {
        qtd_elected += p->qtd_elected();
    }

    return qtd_elected;
}

void Election::report_1() const {

}

void Election::report_2() const {

}

void Election::report_3() const {

}

void Election::report_4() const {

}

void Election::report_5() const {

}

void Election::report_6() const {

}

void Election::report_7() const {

}

void Election::report_8() const {

}

void Election::report_9() const {

}

void Election::report_10() const {

}

void Election::report_11() const {

}

void Election::insert_candidates_in_partys(vector<Candidate*> candidates, vector<PoliticParty*> partys) {

}

void Election::insert_partys_in_candidates(vector<Candidate*> candidates, vector<PoliticParty*> partys) {

}

PoliticParty* Election::search_party(vector<PoliticParty*> partys, int key) {
    return NULL;
}
