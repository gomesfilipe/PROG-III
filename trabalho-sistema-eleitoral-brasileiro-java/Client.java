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

            Candidate.report1(listCandidates, overwrite);
            Candidate.report2(listCandidates, hashParty, output);
            Candidate.report3(listCandidates, hashParty, output);
            Candidate.report4(listCandidates, hashParty, output);
            Candidate.report5(listCandidates, hashParty, output);
            PoliticParty.report8(hashParty, output);
            Candidate.report9(listCandidates, output);
            Candidate.report10(listCandidates, output);
            

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
        Relatórios 6,7,8,10,11
        Ver como criar v�rios m�todos compareTo simulteamente para ordenar os partidos.
*/

/*  
    Choosing between Hash or List
    Documentation: LC(list of candidates) and LP(list of partys)

    We have 2 lists: 1 for candidates adnd another for partys
 

    R6: We can do this part in only one reasrch!
    Considering that the list of candidates of each party are filled
    total votes = legend_votes + nominal_votes_of_each_candidate_from_that_party
    Implentation: Search on the list of candidates and store in a variable the number 
    After that + legend_votes
    
    number_of_elected_candidate = 
    Implementation: Search on the list of candidates and see if the fiel situation is Elected
    If it is, qtd++ 

    Search the list of each party (2 counts)
    Count the number of votes of each candidate
    If the candidate is elected, qtd++

    R7: Legend_votes /variable of total_votes in R6

    R8: Look the list of candidates of each party and then print the first and the last candidates(nominal votes)

    R11:

    OBS: Nos relatorios de 2 a 5, nao fizemos o tratamento para caso de empate!
    OBS: nossa impressao estao com "." e nao com "," nas porcentagens
    OBS: Dúvida no Relatório 8
    Na impressão desse relatorio, queremos saber se um partido que possua 
    o mesmo candidato como primeiro e último deve ser impresso. 
    Tivemos problemas com os partidos PCO e PTC, em ambos o candidato com maior quantidade de votos nominais é o mesmo que o último, porém no output fornecido, o partido PTC é impresso e o POC não.
    Há algum critério que não estamos percebendo ou é um erro na saída fornecida? 
*/