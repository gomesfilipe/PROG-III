package TP1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
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
                
                //System.out.println(linePartys[0]);
                
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

    public static void report8(Map<Integer, PoliticParty> partys, PrintWriter output) {
    	output.println("Primeiro e último colocados de cada partido:");
        
    	int j = 1;
        for(Integer key : partys.keySet()) {
            PoliticParty party = partys.get(key);
            List<Candidate> list = party.getCandidates();
            
            Collections.sort(list); // Resolver depois, deve ter um lugar melhor pra ordenar essa lista.
            
            Candidate first = null;
            Candidate last = null;

            for(int i = 0; i < list.size(); i++) {
                first = list.get(i);
                
                if(first.getNominalVotes() > 0 && first.getVoteDestination().equals("Válido")) { // Tem que ser "válido"
                    break;
                }
                first = null;
            }
            
            for(int i = 0; i < list.size(); i++) {
                last = list.get(list.size() - 1 - i);

                if(last.getNominalVotes() > 0 && last.getVoteDestination().equals("Válido")) {
                   break;
                }
                last = null;
            }
            
            if (first != null || last != null){ // Tem ou nï¿½o tem esse if ???
                output.printf("%d - %s - %d, ", j, party.getAbreviation(), party.getNumber());
            	
            	if(first != null) {
                	output.printf("%s (%d, %d votos) ", first.getBalBoxName(), first.getBalBoxNumber(), first.getNominalVotes());
                }
                
            	output.printf("/ ");
            	
                if(last != null) {
                	output.printf("%s (%d, %d votos)", last.getBalBoxName(), last.getBalBoxNumber(), last.getNominalVotes());
                }
            	
                output.println("");
                
            	//output.printf("%d - %s - %d, %s (%d, %d votos) / %s (%d, %d votos)\n", j, party.getAbreviation(), party.getNumber(), first.getBalBoxName(), first.getBalBoxNumber(), first.getNominalVotes(), last.getBalBoxName(), last.getBalBoxNumber(), last.getNominalVotes());
                j++;
            }
        }
        output.println();
    } 
    
    public static void report11(Map<Integer, PoliticParty> partys, PrintWriter output) {
    	
    }
}
