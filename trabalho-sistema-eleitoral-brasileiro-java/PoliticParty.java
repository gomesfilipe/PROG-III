package TP1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PoliticParty {
    String name;
    String abreviation;
    int number;
    int legendVotes;
    List<Candidate> candidates;

    public PoliticParty(String name, String abreviation, int number, int legendVotes) {
        this.name = name;
        this.abreviation = abreviation;
        this.number = number;
        this.legendVotes = legendVotes;
        this.candidates = new LinkedList<Candidate>();
    }

    public String getName() {
		return name;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public int getNumber() {
		return number;
	}

	public int getLegendVotes() {
		return legendVotes;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}
	
	@Override
    public String toString() {
        Formatter fmt = new Formatter();
        fmt.format("Name: %s\nAbreviation: %s\nNumber: %d\nLegendVotes: %d\n", this.name, this.abreviation, this.number, this.legendVotes);
        String s = fmt.out().toString();
        fmt.close();
        return s;
    }

    public static Map<Integer, PoliticParty> readPoliticParty(String fileName) throws FileNotFoundException {
        Map<Integer, PoliticParty> partys = new HashMap<Integer, PoliticParty>();
        
        try {
        	Scanner input = new Scanner(new File(fileName), "utf-8");
        	//Scanner input = new Scanner(new FileReader(fileName));
			input.nextLine(); // Ignorando cabecalho
			
			while (input.hasNextLine()) {
			    String line = input.nextLine();
                String linePartys[] = line.split(",");
                
                int number = Integer.parseInt(linePartys[0]);
                int legendVotes = Integer.parseInt(linePartys[1]);
                String name = linePartys[2];
                String abreviation = linePartys[3];
                
				PoliticParty p = new PoliticParty(name, abreviation, number, legendVotes);
				partys.put(number, p);
			}
			
			input.close();
		
        } catch (FileNotFoundException e) {
            System.out.println("An Error has ocurred! FileNotFoundException");
        }
        
        return partys;
    }	

    public static void insertCandidatesInPartys(List<Candidate> candidates, Map<Integer, PoliticParty> partys) {
        for(Candidate p : candidates) {
            int key = p.getPartyNumber();
            PoliticParty party = partys.get(key);
            List<Candidate> list = party.getCandidates();
            list.add(p);

        }
        
        // for(Integer key : partys.keySet()) {
        //     PoliticParty party = partys.get(key);
        //     List<Candidate> list = party.getCandidates();

        //     System.out.println("Candidatos do partido numero " + key);
        //     for(Candidate p : list) {
        //         System.out.println(p.getBalBoxName() + " " + p.getPartyNumber());
                
        //     }
        // }
    }
    
    public int qtdNominalVotes() {
    	int nominal_votes = 0;
    	for(Candidate p : this.getCandidates()) {
            if(p.validVote()) 
            	nominal_votes += p.getNominalVotes();
        }
    	return nominal_votes;
    }
    
    public int qtdElected() {
    	int qtd_elected = 0;
    	for(Candidate p : this.getCandidates()) {
            if(p.elected()) 
            	qtd_elected++;
        }
    	return qtd_elected;
    }
    
    public int qtdTotalVotes() {
    	return this.qtdNominalVotes() + this.getLegendVotes();
    }
    
    //Votos totalizados por partido e número de candidatos eleitos;
    // public static void report6(Map<Integer, PoliticParty> partys, PrintWriter output){
    //     int total_votes = 0;
    //     int nominal_votes = 0;
    //     int qtd_elect = 0;
    //     int i = 1;
    //     output.println("Votação dos partidos e número de candidatos eleitos:");
    //     for(Integer key : partys.keySet()) {
    //         PoliticParty party = partys.get(key);
    //         total_votes = 0;
    //         nominal_votes = 0;
    //         qtd_elect = 0;
    //         for(Candidate p : party.getCandidates()) {
    //             if(p.getVoteDestination().equals("V�lido")){
    //                 nominal_votes += p.getNominalVotes();
    //             }
    //             if( p.getSituation().equals("Eleito")){
    //                 qtd_elect++;
    //             }

    //         }
    //         total_votes = nominal_votes + party.getLegendVotes();

    //         //output.printf("%d - %s - %d, %d votos (%d nominais e %d de legenda), %d candidatos eleitos\n", i, party.getAbreviation(), party.getNumber(), total_votes, nominal_votes, party.getLegendVotes(),qtd_elect);
            
    //         output.printf("%d - %s - %d, ",  i, party.getAbreviation(), party.getNumber());
            
    //         if(total_votes > 1) output.printf("%d votos ", total_votes);
    //         else output.printf("%d voto ", total_votes);

    //         if( nominal_votes > 1) output.printf("(%d nominais e ", nominal_votes);
    //         else  output.printf("(%d nominal e ", nominal_votes);
            
    //         output.printf("%d de legenda), ", party.getLegendVotes() );

    //         if(qtd_elect > 1) output.printf("%d candidatos eleitos\n", qtd_elect );
    //         else output.printf("%d candidato eleito\n", qtd_elect );
            
    //         i++; 

    //     }
    //     output.println();
    // }

    // public static void report7(Map<Integer, PoliticParty> partys, PrintWriter output) {
    //     output.println("Votação dos partidos (apenas votos de legenda):");
        
    //     int total_votes = 0;
    //     int i = 1;
        
    //     for(Integer key : partys.keySet()) {
    //         PoliticParty party = partys.get(key);
            
            
            
    //         for(Candidate p : party.getCandidates()) {
    //             if(p.getVoteDestination().equals("V�lido")){
    //                 total_votes += p.getNominalVotes();
    //             }
    //         }
            
    //         total_votes += + party.getLegendVotes();
    //         output.printf("%d - %s - %d, %d votos de legenda (%.2f%% do total do partido)\n", 
    //         i, party.getAbreviation(), party.getNumber(), party.getLegendVotes(), Utils.percent(party.getLegendVotes(), total_votes));
    //         i++;
    //     }

    //     output.println();
    // }

    // public static void report8(Map<Integer, PoliticParty> partys, PrintWriter output) {
    // 	output.println("Primeiro e �ltimo colocados de cada partido:");
        
    // 	int j = 1;
    //     for(Integer key : partys.keySet()) {
    //         PoliticParty party = partys.get(key);
    //         List<Candidate> list = party.getCandidates();
            
    //         Collections.sort(list); // Resolver depois, deve ter um lugar melhor pra ordenar essa lista.
            
    //         Candidate first = null;
    //         Candidate last = null;

    //         for(int i = 0; i < list.size(); i++) {
    //             first = list.get(i);
                
    //             if(first.getVoteDestination().equals("V�lido")) { // Tem que ser "v�lido"
    //                 break;
    //             }
    //             first = null;
    //         }
            
    //         for(int i = 0; i < list.size(); i++) {
    //             last = list.get(list.size() - 1 - i);

    //             if(last.getVoteDestination().equals("V�lido")) {
    //                break;
    //             }
    //             last = null;
    //         }
            
    //         if (first != null || last != null){ // Tem ou n�o tem esse if ???

    //             if( first.getNominalVotes() == 0 && last.getNominalVotes() == 0 ) continue;
                   
    //         	output.printf("%d - %s - %d, ", j, party.getAbreviation(), party.getNumber());
    //         	//if(first != null) {
    //             	output.printf("%s (%d, %d votos) ", first.getBalBoxName(), first.getBalBoxNumber(), first.getNominalVotes());
    //             //}
                
    //         	output.printf("/ ");
            	
    //             //if(last != null) {
    //             	output.printf("%s (%d, %d votos)", last.getBalBoxName(), last.getBalBoxNumber(), last.getNominalVotes());
    //             //}
            	
    //             output.println("");
                
    //         	//output.printf("%d - %s - %d, %s (%d, %d votos) / %s (%d, %d votos)\n", j, party.getAbreviation(), party.getNumber(), first.getBalBoxName(), first.getBalBoxNumber(), first.getNominalVotes(), last.getBalBoxName(), last.getBalBoxNumber(), last.getNominalVotes());
    //             j++;
    //         }
    //     }
        
    //     output.println();
    // } 
    
    // public static void report11(Map<Integer, PoliticParty> partys, PrintWriter output) {
    //     int nominal_votes = 0;
    //     int legend_votes = 0;
        
    //     for(int key : partys.keySet()) {
    //         PoliticParty party = partys.get(key);
    //         legend_votes += party.getLegendVotes();

    //         for(Candidate p : party.getCandidates()) {
    //             if(p.getVoteDestination().equals("V�lido")){
    //                 nominal_votes += p.getNominalVotes();
    //             }
    //         }
    //     }

    //     output.printf("Total de votos válidos:  %d\n", nominal_votes + legend_votes);
    //     output.printf("Total de votos nominais: %d (%.2f%%)\n", nominal_votes, Utils.percent(nominal_votes, nominal_votes + legend_votes));
    //     output.printf("Total de votos legenda:  %d (%.2f%%)\n", legend_votes, Utils.percent(legend_votes, nominal_votes + legend_votes));
    // }
}
