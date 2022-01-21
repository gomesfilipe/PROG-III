package TP1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Candidate extends Person implements Comparable<Candidate> {
    String balBoxName;
    int balBoxNumber;
    int nominalVotes;
    String situation;
    int partyNumber;
    String voteDestination;

    public Candidate(String name, char gender, String birth, String balBoxName, int balBoxNumber, int nominalVotes, String situation, int partyNumber, String voteDestination) {
        super(name, gender, birth);
        
        this.balBoxName = balBoxName;
        this.balBoxNumber = balBoxNumber;
        this.nominalVotes = nominalVotes;
        this.situation = situation;
        this.partyNumber = partyNumber;
        this.voteDestination = voteDestination;
    }

	public String getBalBoxName() {
		return this.balBoxName;
	}

	public int getBalBoxNumber() {
		return this.balBoxNumber;
	}

	public int getNominalVotes() {
		return this.nominalVotes;
	}

	public String getSituation() {
		return this.situation;
	}

    public int getPartyNumber(){
        return this.partyNumber;
    }

    public String getVoteDestination() {
		return this.voteDestination;
	}

    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        // Adicionou 1 ao mï¿½s para ficar de 0 a 12.
        // fmt.format("Name: %s\nGender: %c\nBirth: %02d/%02d/%04d\nbalBoxName: %s\nbalBoxNumber: %d\nnominalVotes: %d\nSituation: %s\nParty Number: %d\nVote Destination: %s\n", this.name, this.gender, this.birth.get(Calendar.DAY_OF_MONTH), this.birth.get(Calendar.MONTH) + 1, this.birth.get(Calendar.YEAR), this.balBoxName, this.balBoxNumber, this.nominalVotes, this.situation, this.partyNumber, this.voteDestination);
        fmt.format("Name: %s\nVoteDestination: %s\n", this.name, this.voteDestination);
        String s = fmt.out().toString();
        fmt.close();
        return s;
    }

    public void printCandidate(){
        System.out.println(this.toString());
    }

    public static List<Candidate> readCandidate(String fileName) throws FileNotFoundException {
        List<Candidate> candidates = new LinkedList<Candidate>();
        
        try {
        	Scanner input = new Scanner(new File(fileName), "utf-8");
			//Scanner input = new Scanner(new FileReader(fileName));
			input.nextLine(); // Ignorando cabecalho
			
			while (input.hasNextLine()) {
			    String line = input.nextLine();
                
                String lineParts[] = line.split(",");
                
                //System.out.println(linePartys[0]);
                
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

    public static int qtdElectedCandidates(List<Candidate> candidates){
        int qtdElect = 0;
        
        for(Candidate p : candidates){
            if(p.getSituation().equals("Eleito")) qtdElect++ ;
        }
        
        return qtdElect;
    }

    public static void report1(List<Candidate> candidates, PrintWriter output) {
        int qtdElect = Candidate.qtdElectedCandidates(candidates);
        output.printf("Número de vagas: %d\n\n", qtdElect);
    }
   
    public static void report2(List<Candidate> candidates, Map<Integer, PoliticParty> partys, PrintWriter output) {
        output.println("Vereadores eleitos: ");
        
        int i = 1;
        for(Candidate p : candidates) {
            if(p.getSituation().equals("Eleito")) {
                int key  = p.getPartyNumber();
                String abreviation = partys.get(key).getAbreviation();
                output.printf("%d - %s / %s (%s, %d votos)\n", i, p.getName(), p.getBalBoxName(), abreviation, p.getNominalVotes());
                i++;
            } 
        }
        output.println();
    }
    
    public static void report3(List<Candidate> candidates, Map<Integer, PoliticParty> partys, PrintWriter output) {
        output.println("Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):");
        
        int qtd_elect = qtdElectedCandidates(candidates);
        int i = 1;
        for(Candidate p : candidates) {
            int key  = p.getPartyNumber();
            String abreviation = partys.get(key).getAbreviation();
            output.printf("%d - %s / %s (%s, %d votos)\n", i, p.getName(), p.getBalBoxName(), abreviation, p.getNominalVotes());
            
            if (i == qtd_elect) break;
            i++;
        }
        
        output.println();
    }

    public static void report4(List<Candidate> candidates, Map<Integer, PoliticParty> partys, PrintWriter output) {
       int qtdElect = Candidate.qtdElectedCandidates(candidates);

        output.println("Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos:");
        output.println("(com sua posição no ranking de mais votados)");
        
        int i = 1;
        for(Candidate p : candidates){
            int key  = p.getPartyNumber();
            String abreviation = partys.get(key).getAbreviation();
            if(!p.getSituation().equals("Eleito")){  //the person wasn't elected in proporcional election
                output.printf("%d - %s / %s (%s, %d votos)\n", i, p.getName(), p.getBalBoxName(), abreviation, p.getNominalVotes()); 
            }
            if(i == qtdElect) break;
            i++;
        }
            
        output.println();

    }

    public static void report5(List<Candidate> candidates, Map<Integer, PoliticParty> partys, PrintWriter output) {
        int qtd_elect = Candidate.qtdElectedCandidates(candidates);
        int elect_proportional = 0;

        output.println("Eleitos, que se beneficiaram do sistema proporcional:");
        output.println("(com sua posição no ranking de mais votados)");

        for(Candidate p : candidates) {
            if(p.getSituation().equals ("Eleito")) {
                elect_proportional++;

                if(candidates.indexOf(p) > qtd_elect - 1) {
                    int key  = p.getPartyNumber();
                    String abreviation = partys.get(key).getAbreviation();
                    
                    output.printf("%d - %s / %s (%s, %d votos)\n", candidates.indexOf(p) + 1, p.getName(), p.getBalBoxName(), abreviation, p.getNominalVotes());
                }
            }
            
            if (elect_proportional == qtd_elect) break;
        }
        
        output.println();
        
    }

    public static void report9(List<Candidate> candidates, PrintWriter output){
        int lt30 = 0, lt40 = 0, lt50 = 0, lt60 = 0, bt60 = 0;
          
        for(Candidate p : candidates ) {
            if( p.getSituation().equals("Eleito")) {
                int age = p.age();
                if (age >= 0 && age < 30)       lt30++;
                else if (age >= 30 && age < 40) lt40++;
                else if (age >= 40 && age < 50) lt50++;
                else if (age >= 50 && age < 60) lt60++;
                else if (age >= 60)             bt60++;    
            }
        }
        
        int total = lt30 + lt40 + lt50 + lt60 + bt60;
        output.println("Eleitos, por faixa etária (na data da eleição):\n");
        output.printf("      Idade < 30: %d (%.2f%%)\n", lt30, Candidate.percent( lt30, total));
        output.printf("30 <= Idade < 40: %d (%.2f%%)\n", lt40, Candidate.percent(lt40, total));
        output.printf("40 <= Idade < 50: %d (%.2f%%)\n", lt50, Candidate.percent(lt50, total));
        output.printf("50 <= Idade < 60: %d (%.2f%%)\n", lt60, Candidate.percent(lt60, total));
        output.printf("60 <= Idade     : %d (%.2f%%)\n\n", bt60, Candidate.percent(bt60, total));
        
    }

    public static void report10(List<Candidate> candidates, PrintWriter output) {
        int male = 0, female = 0;
        
        for(Candidate p : candidates ) {
            if( p.getSituation().equals("Eleito")) {
                if(p.getGender() == 'F') {
                    female++;  
                
                } else if (p.getGender() == 'M') {
                    male++;
                }
            }
        }
        
        output.println("Eleitos, por sexo:");
        output.printf("Feminino: %d (%.2f%%)\n", female , Candidate.percent(female, female + male));
        output.printf("Masculino: %d (%.2f%%)\n\n", male, Candidate.percent(male, female + male));
       
    }

    private static double percent(double value, double total) {
        return value / total * 100.0;
    }

    @Override
    public int compareTo(Candidate candidate) {
        return candidate.nominalVotes - this.nominalVotes;
    }
}




