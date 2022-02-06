package TP1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Client {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		Locale.setDefault(new Locale("pt", "BR"));
		
		List<Candidate> listCandidates = Read.readCandidate(args[0]);
		List<PoliticParty> listPartys = Read.readPoliticParty(args[1]);
		
        Election election = new Election(listCandidates, listPartys, args[2]);
        
        election.report1();
        election.report2();
        election.report3();
        election.report4();
        election.report5();
        election.report6();
        election.report7();
        election.report8();
        election.report9();
        election.report10();
        election.report11();
	}
}
