#include "../include/Read.h"
// #include "Read.h"

vector<PoliticParty*> read_politic_party(const string& fileName) {
    vector<PoliticParty*> partys;

    try {
        ifstream fin(fileName);  
        
        if(!fin.good()) {
            fin.close();
            file_not_found_exception();
        }

        string line;
        getline(fin, line);
        while(!fin.eof()) {
            getline(fin, line);
    
            Tokenizer tokenizer(line, ',');
            vector<string> split = tokenizer.remaining();
            
            if(split.size() < 4) continue;

            int number = stoi(split.at(0));
            int legendVotes = stoi(split.at(1));
            string name = split.at(2);
            string abreviation = split.at(3);

            PoliticParty* p = new PoliticParty(name, abreviation, number, legendVotes);
            partys.push_back(p);
        }

        fin.close();

    } catch(Exception e) {
        cerr << e << endl;
        exit(1);
    }

    // catch(exception& e) {
    //     cerr << "Exception: [" << e.what() << "]";
    // }

    // catch(ios_base::failure& e) {
    //     cout << "Exception: [";
    //     cerr << e.what();
    //     cout << "]" << endl;
    // }

    return partys;
}

vector<Candidate*> read_candidate(const string& fileName) {
    vector<Candidate*> candidates;

    try {
        ifstream fin(fileName);

        if(!fin.good()) {
            fin.close();
            file_not_found_exception();
        }

        string line;
        getline(fin, line);

        while(!fin.eof()) {
            getline(fin, line);
    
            Tokenizer tokenizer(line, ',');
            vector<string> split = tokenizer.remaining();
            
            if(split.size() < 9) continue;

            int balboxNumber = stoi(split.at(0));
            int nominalVotes = stoi(split.at(1));
            string situation = split.at(2);
            string name = trim(split.at(3));
            string balboxName = trim(split.at(4));
            char gender = split.at(5).at(0);
            string birth = split.at(6);
            string voteDestination = split.at(7);
            int partyNumber = stoi(split.at(8));

            Candidate* p = new Candidate(name, gender, birth, balboxName, balboxNumber, nominalVotes, situation, partyNumber, voteDestination);
            candidates.push_back(p);
        }

        fin.close();

    } catch(Exception e) {
        cerr << e << endl;
        exit(1);
    }

    return candidates;
}
