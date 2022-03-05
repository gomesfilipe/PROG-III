#ifndef READ_H_
#define READ_H_

#include <fstream>
#include <string>
#include <iostream>
using namespace std;
#include <vector>
#include <exception>
#include "Person.h"
#include "Candidate.h"
#include "PoliticParty.h"
#include "Tokenizer.h"

vector<PoliticParty*> read_politic_party(const string& fileName);

vector<Candidate*> read_candidate(const string& fileName);

#endif
