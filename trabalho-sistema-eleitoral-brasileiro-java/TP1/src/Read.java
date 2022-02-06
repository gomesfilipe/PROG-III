package TP1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Read {
	/**
  	 * @brief Esse método implementa a leitura do arquivo de partidos políticos.
  	 * As informações sobre os partidos são armazenadas em uma lista encadeada.
  	 * @param:
 	 * 		@fileName Nome do arquivo que será lido.
  	 */
     public static List<PoliticParty> readPoliticParty(String fileName) throws FileNotFoundException {
        List<PoliticParty> partys = new LinkedList<PoliticParty>();
        try {
        	Scanner input = new Scanner(new File(fileName), "utf-8");
			input.nextLine(); 
			
			while (input.hasNextLine()) {
			    String line = input.nextLine();
                String linePartys[] = line.split(",");
                
                int number = Integer.parseInt(linePartys[0]);
                int legendVotes = Integer.parseInt(linePartys[1]);
                String name = linePartys[2];
                String abreviation = linePartys[3];
                
				PoliticParty p = new PoliticParty(name, abreviation, number, legendVotes);
				partys.add(p);
			}
			
			input.close();
		
        } catch (FileNotFoundException e) {
            System.out.println("An Error has ocurred! FileNotFoundException");
        }
        
        return partys;
    }
     
 	/**
   	 * @brief Esse método implementa a leitura do arquivo de candidatos.
   	 * As informações sobre os candidatos são armazenadas em uma lista encadeada.
   	 * @param:
  	 * 		@fileName Nome do arquivo que será lido.
   	*/
    public static List<Candidate> readCandidate(String fileName) throws FileNotFoundException {
        List<Candidate> candidates = new LinkedList<Candidate>();
        
        try {
        	Scanner input = new Scanner(new File(fileName), "utf-8");
			input.nextLine(); 
			
			while (input.hasNextLine()) {
			    String line = input.nextLine();
                String lineParts[] = line.split(",");
                
                int balBoxNumber = Integer.parseInt(lineParts[0]);
                int nominalVotes = Integer.parseInt(lineParts[1]);
                String situation = lineParts[2];
                String name = lineParts[3];
                String balBoxName = lineParts[4];
                char gender = lineParts[5].charAt(0);
                String birth = lineParts[6];
                String voteDestination = lineParts[7];
                int partyNumber = Integer.parseInt(lineParts[8]);

				Candidate p = new Candidate(name, gender, birth, balBoxName, balBoxNumber, nominalVotes, situation, partyNumber, voteDestination);
				candidates.add(p);
			}
			
			input.close();
		
        } catch (FileNotFoundException e) {
        	System.out.println("An Error has ocurred! FileNotFoundException");
        }
        
        return candidates;
    }
}
