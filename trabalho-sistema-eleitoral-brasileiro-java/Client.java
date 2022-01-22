package TP1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Client {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		Locale.setDefault(new Locale("pt", "BR"));
		
		Map<Integer, PoliticParty> hashParty = PoliticParty.readPoliticParty("partidos.csv");
		List<Candidate> listCandidates = Candidate.readCandidate("candidatos.csv");
		
        PoliticParty.insertCandidatesInPartys(listCandidates, hashParty);
		
        Collections.sort(listCandidates);
		
        String fileName = "reports.txt";
        try {
            File file = new File(fileName);
            PrintWriter overwrite = new PrintWriter(new FileWriter(file, false));
            PrintWriter output = new PrintWriter(new FileWriter(file, true));

            overwrite.println("R1");
            Reports.report1(listCandidates, output); // Colocar overwrite no final
            
            output.println("R2");
            Reports.report2(listCandidates, hashParty, output);
            
            output.println("R3");
            Reports.report3(listCandidates, hashParty, output);
            
            output.println("R4");
            Reports.report4(listCandidates, hashParty, output);
            
            output.println("R5");
            Reports.report5(listCandidates, hashParty, output);
            
            output.println("R6");
            Reports.report6(hashParty, output);
            
            output.println("R7");
            Reports.report7(hashParty, output);
            
            output.println("R8");
            Reports.report8(hashParty, output);
            
            output.println("R9");
            Reports.report9(listCandidates, output);
            
            output.println("R10");
            Reports.report10(listCandidates, output);
            
            output.println("R11");
            Reports.report11(hashParty, output);

            overwrite.close();
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("An Error has ocurred! FileNotFoundException");
        
        } catch (IOException f) {
        	System.out.println("An Error has ocurred! IOException");
        }
	}
}

/*
    *** TO DO ***
        * Gols or  Next steps *

        Sunday:
        Ver como criar v�rios m�todos compareTo simulteamente para ordenar os partidos.
        MAKE: Nos relatorios de 2 a 5, nao fizemos o tratamento para caso de empate!
        Sort R6, R7, R8
        Think about classes for reading or something like that
        Remember to organize prints messed-up caused by eclipse/vscode
        
        Monday:
        Tests!!!! File "created" by gc
        Build file
        Report of Work in Latex!
*/
