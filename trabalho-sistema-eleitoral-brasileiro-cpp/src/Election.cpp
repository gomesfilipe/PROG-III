// #include "Election.h"
#include "../include/Election.h"

Election::Election(const vector<Candidate*>& candidates, const vector<PoliticParty*>& partys, const string& date) {
    this->candidates = candidates;

    insert_candidates_in_partys(this->candidates, partys);
    insert_partys_in_candidates(this->candidates, partys);

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
    cout << "Número de vagas:" << this->qtd_elected() << endl << endl;
}

void Election::report_2() {
    sort(this->candidates.begin(), this->candidates.end(), comparator_candidates);

    cout << "Vereadores Eleitos: " << endl;
    
    int i = 1;
    for(Candidate* c : this->candidates) {
        if(c->elected()) {
            string abreviation = c->get_party()->get_abreviation();
            cout << i++ << " - " << c->get_name() << " / " << c->get_balbox_name() << " (" << abreviation << ", " << c->get_nominal_votes() << " votos)" << endl;
        }
    }
    cout << endl;
}

void Election::report_3() {
    sort(this->candidates.begin(), this->candidates.end(), comparator_candidates);
    cout << "Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):" << endl;
    
    int qtd_elect = this->qtd_elected();
    int i = 1;

    for(Candidate* p : this->candidates) {         
        string abreviation = p->get_party()->get_abreviation();
        
        cout << i << " - " << p->get_name() << " / " << p->get_balbox_name() << " (" << abreviation << ", " << p->get_nominal_votes() << " votos)" << endl;
        
        if (i == qtd_elect) break;
        i++;
    }

    cout << endl;
}

void Election::report_4() {
    sort(this->candidates.begin(), this->candidates.end(), comparator_candidates);
    
    cout << "Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos:" << endl;
    cout << "(com sua posição no ranking de mais votados)" << endl;

    int qtd_elect = this->qtd_elected();

    int i = 1;

    for(Candidate* p : this->candidates) {
        string abreviation = p->get_party()->get_abreviation();

        if(!p->elected()) {
            cout << i << " - " << p->get_name() << " / " << p->get_balbox_name() << " (" << abreviation << ", " << p->get_nominal_votes() << " votos)" << endl; 
        }

        if(i == qtd_elect) break;
        i++;
    }

    cout << endl;
}

void Election::report_5() {
    sort(this->candidates.begin(), this->candidates.end(), comparator_candidates);
    
    cout << "Eleitos, que se beneficiaram do sistema proporcional:" << endl;
    cout << "(com sua posição no ranking de mais votados)" << endl;

    int qtd_elect = this->qtd_elected();
    int elect_proportional = 0, index = 0;

    for(Candidate* p : this->candidates) {
        if(p->elected()) {
            elect_proportional++;

            if(index > qtd_elect - 1) {
                string abreviation = p->get_party()->get_abreviation();
                cout << index + 1 << " - " << p->get_name() << " / " << p->get_balbox_name() << " (" << abreviation << ", " << p->get_nominal_votes() << " votos)" << endl; 
            }
        }
        
        if (elect_proportional == qtd_elect) break;
        index++;
    }

    cout << endl;
}

void Election::report_6() {
    sort(this->partys.begin(), this->partys.end(), comparator_total_votes);
    
    cout << "Votação dos partidos e número de candidatos eleitos:" << endl;

    int i = 1;
    for(PoliticParty* p : this->partys) {
        int nominal_votes = p->qtd_nominal_votes();
        int qtd_elected = p->qtd_elected();
        int total_votes = p->qtd_total_votes();

        cout << i << " - " << p->get_abreviation() << " - " << p->get_number() << ", ";

        if(total_votes > 1) cout << total_votes << " votos ";
        else cout << total_votes << " voto ";

        if(nominal_votes > 1) cout << "(" << nominal_votes << " nominais e ";
        else cout << "(" << nominal_votes << " nominal e ";

        cout << p->get_legend_votes() << " de legenda), ";

        if(qtd_elected > 1) cout << qtd_elected << " candidatos eleitos" << endl;
        else cout << qtd_elected << " candidato eleito" << endl;

        i++;
    }


    cout << endl;
}

void Election::report_7() {
    sort(this->partys.begin(), this->partys.end(), comparator_legend_votes);
    
    cout << "Votação dos partidos (apenas votos de legenda):" << endl;

    int total_votes = 0;
    int i = 1;

    for(PoliticParty* p : this->partys) {
        total_votes = p->qtd_total_votes();

        cout << i << " - " << p->get_abreviation() << " - " << p->get_number() << ", ";

        if(p->get_legend_votes() > 1) cout << p->get_legend_votes() << " votos de legenda ";
        else cout << p->get_legend_votes() << " voto de legenda ";

        double percent_legend_votes = percent(p->get_legend_votes(), total_votes);

        if(total_votes != 0) cout << "(" << formatDoubleCurrency(percent_legend_votes, LOCALE_PT_BR) << "% do total do partido)" << endl; 
        else cout << "proporção não calculada, 0 voto no partido)" << endl;

        i++;
    }

    cout << endl;
}

void Election::report_8() {
    for(PoliticParty* p : this->partys) {
        vector<Candidate*> vector_candidates = p->get_candidates();
        sort(vector_candidates.begin(), vector_candidates.end(), comparator_candidates);
    }
    
    sort(this->partys.begin(), this->partys.end(), comparator_nominal_votes);

    cout << "Primeiro e último colocados de cada partido:" << endl;

    int j = 1;

    

    
    for(PoliticParty* p : this->partys) {
        vector<Candidate*> vector_candidates = p->get_candidates();
        // sort(vector_candidates.begin(), vector_candidates.end(), comparator_candidates);

        Candidate* first = NULL;
        Candidate* last = NULL;

        for(int i = 0; i < vector_candidates.size(); i++) {
            first = vector_candidates.at(i);

            if(first->valid_vote()) break;

            first = NULL;
        }

        for(int i = 0; i < vector_candidates.size(); i++) {
            last = vector_candidates.at(vector_candidates.size() - 1 - i);

            if(last->valid_vote()) break;

            last = NULL;
        }

        if(first != NULL || last != NULL) {
            cout << p->qtd_nominal_votes() << " // ";
            
            if(first->get_nominal_votes() == 0 && last->get_nominal_votes() == 0) continue;

            cout << j << " - " << p->get_abreviation() << " - " << p->get_number() << ", ";
            cout << first->get_balbox_name() << " (" << first->get_balbox_number() << ", ";

            if(first->get_nominal_votes() == 0 || first->get_nominal_votes() == 1)
                cout << first->get_nominal_votes() << " voto) ";
            else
                cout << first->get_nominal_votes() << " votos) ";

            cout << "/ " << last->get_balbox_name() << " (" << last->get_balbox_number() << ", ";

            if(last->get_nominal_votes() == 0 || last->get_nominal_votes() == 1)
                cout << last->get_nominal_votes() << " voto) " << endl;
            else
                cout << last->get_nominal_votes() << " votos) " << endl;

            j++;
        }
    }

    cout << endl;
}

void Election::report_9() const {
    int lt30 = 0, lt40 = 0, lt50 = 0, lt60 = 0, bt60 = 0;

    for(Candidate* p : this->candidates) {
        if(p->elected()) {
            int age = p->age_at(this->date);
            if (age >= 0 && age < 30)       lt30++;
            else if (age >= 30 && age < 40) lt40++;
            else if (age >= 40 && age < 50) lt50++;
            else if (age >= 50 && age < 60) lt60++;
            else if (age >= 60)             bt60++;    
        }
    }

    int total = lt30 + lt40 + lt50 + lt60 + bt60;
    double lt30_percent = percent(lt30, total);
    double lt40_percent = percent(lt40, total);
    double lt50_percent = percent(lt50, total);
    double lt60_percent = percent(lt60, total);
    double bt60_percent = percent(bt60, total);

    cout << "Eleitos, por faixa etária (na data da eleição):" << endl;
    cout << "      Idade < 30: " << lt30 << " (" << formatDoubleCurrency(lt30_percent, LOCALE_PT_BR) << "%)" << endl;
    cout << "30 <= Idade < 40: " << lt40 << " (" << formatDoubleCurrency(lt40_percent, LOCALE_PT_BR) << "%)" << endl;
    cout << "40 <= Idade < 50: " << lt50 << " (" << formatDoubleCurrency(lt50_percent, LOCALE_PT_BR) << "%)" << endl;
    cout << "50 <= Idade < 60: " << lt60 << " (" << formatDoubleCurrency(lt60_percent, LOCALE_PT_BR) << "%)" << endl;
    cout << "60 <= Idade     : " << bt60 << " (" << formatDoubleCurrency(bt60_percent, LOCALE_PT_BR) << "%)" << endl;
    cout << endl;
}

void Election::report_10() const {
    int male = 0, female = 0;
        
    for(Candidate* p : this->candidates) {
        if(p->elected()) {
            if(p->get_gender() == 'F') female++;  
            else if (p->get_gender() == 'M') male++;    
        }
    }
    
    double female_percent = percent(female, female + male);
    double male_percent = percent(male, female + male);

    cout << "Eleitos, por sexo:" << endl;
    cout << "Feminino: " << female << " (" << formatDoubleCurrency(female_percent, LOCALE_PT_BR) << "%)" << endl;
    cout << "Masculino: " << male << " (" << formatDoubleCurrency(male_percent, LOCALE_PT_BR) << "%)" << endl;
    cout << endl; 
}

void Election::report_11() const {
    int nominal_votes = 0;
    int legend_votes = 0;
    
    for(PoliticParty* p : partys) {
        nominal_votes += p->qtd_nominal_votes();
        legend_votes += p->get_legend_votes();
    }

    int total = nominal_votes + legend_votes;
    double nominal_percent = percent(nominal_votes, total);
    double legend_percent = percent(legend_votes, total);
    cout << "Total de votos válidos: " <<  total << endl;
    cout << "Total de nominais: " <<  nominal_votes <<  " ("  << formatDoubleCurrency(nominal_percent, LOCALE_PT_BR) << "%)" << endl;
    cout << "Total de votos de legenda: " <<  legend_votes <<  " ("  << formatDoubleCurrency(legend_percent, LOCALE_PT_BR) << "%)" << endl;
}

void Election::insert_candidates_in_partys(vector<Candidate*> candidates, vector<PoliticParty*> partys) {
    for(Candidate* c : candidates) {
        int key = c->get_party_number();
        PoliticParty* party = search_party(partys, key);
        party->add_candidate(c);
    }

    // for(PoliticParty* p : partys) {
    //     vector<Candidate*> vector_candidates = p->get_candidates();
    //     sort(vector_candidates.begin(), vector_candidates.end(), comparator_candidates);
    // }
}

void Election::insert_partys_in_candidates(vector<Candidate*> candidates, vector<PoliticParty*> partys) {
    for(Candidate* c : candidates) {
    	int key = c->get_party_number();
        PoliticParty* party = search_party(partys, key);  
        c->set_party(party);
    }
}

PoliticParty* Election::search_party(vector<PoliticParty*> partys, int key) {
    for(PoliticParty* p : partys) {
        if(p->get_number() == key) return p;
    }
    return NULL;
}
