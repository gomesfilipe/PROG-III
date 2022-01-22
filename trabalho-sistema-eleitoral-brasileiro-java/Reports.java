package TP1;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Reports {
    public static void report1(List<Candidate> candidates, PrintWriter output) {
        int qtdElect = Candidate.qtdElectedCandidates(candidates);
        output.printf("N�mero de vagas: %d\n\n", qtdElect);
    }
   
    public static void report2(List<Candidate> candidates, Map<Integer, PoliticParty> partys, PrintWriter output) {
        output.println("Vereadores eleitos: ");
        
        int i = 1;
        for(Candidate p : candidates) {
            if(p.elected()) {
                int key  = p.getPartyNumber();
                String abreviation = partys.get(key).getAbreviation();
                output.printf("%d - %s / %s (%s, %d votos)\n", i, p.getName(), p.getBalBoxName(), abreviation, p.getNominalVotes());
                i++;
            } 
        }
        output.println();
    }

    public static void report3(List<Candidate> candidates, Map<Integer, PoliticParty> partys, PrintWriter output) {
        output.println("Candidatos mais votados (em ordem decrescente de vota��o e respeitando n�mero de vagas):");
        
        int qtd_elect = Candidate.qtdElectedCandidates(candidates);
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

        output.println("Teriam sido eleitos se a vota��o fosse majorit�ria, e n�o foram eleitos:");
        output.println("(com sua posi��o no ranking de mais votados)");
        
        int i = 1;
        for(Candidate p : candidates){
            int key  = p.getPartyNumber();
            String abreviation = partys.get(key).getAbreviation();
            if(!p.elected()){  //the person wasn't elected in proporcional election
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
        output.println("(com sua posi��o no ranking de mais votados)");

        for(Candidate p : candidates) {
            if(p.elected()) {
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

    public static void report6(Map<Integer, PoliticParty> partys, PrintWriter output){
        int i = 1;
        output.println("Vota��o dos partidos e n�mero de candidatos eleitos:");
        for(Integer key : partys.keySet()) {
            PoliticParty party = partys.get(key);
            int nominal_votes = party.qtdNominalVotes();
            int qtd_elected = party.qtdElected();
            int total_votes = party.qtdTotalVotes();
            
            //output.printf("%d - %s - %d, %d votos (%d nominais e %d de legenda), %d candidatos eleitos\n", i, party.getAbreviation(), party.getNumber(), total_votes, nominal_votes, party.getLegendVotes(),qtd_elect);
            
            output.printf("%d - %s - %d, ",  i, party.getAbreviation(), party.getNumber());
            
            if(total_votes > 1) output.printf("%d votos ", total_votes);
            else output.printf("%d voto ", total_votes);

            if( nominal_votes > 1) output.printf("(%d nominais e ", nominal_votes);
            else  output.printf("(%d nominal e ", nominal_votes);
            
            output.printf("%d de legenda), ", party.getLegendVotes() );

            if(qtd_elected > 1) output.printf("%d candidatos eleitos\n", qtd_elected);
            else output.printf("%d candidato eleito\n", qtd_elected);
            
            i++; 
        }
        
        output.println();
    }

    public static void report7(Map<Integer, PoliticParty> partys, PrintWriter output) {
        output.println("Vota��o dos partidos (apenas votos de legenda):");
        
        int total_votes = 0;
        int i = 1;
        
        for(Integer key : partys.keySet()) {
            PoliticParty party = partys.get(key);

            total_votes = party.qtdTotalVotes();
            output.printf("%d - %s - %d, %d votos de legenda (%.2f%% do total do partido)\n", 
            i, party.getAbreviation(), party.getNumber(), party.getLegendVotes(), Utils.percent(party.getLegendVotes(), total_votes));
            i++;
        }

        output.println();
    }

    public static void report8(Map<Integer, PoliticParty> partys, PrintWriter output) {
    	output.println("Primeiro e �ltimo colocados de cada partido:");
        
    	int j = 1;
        for(Integer key : partys.keySet()) {
            PoliticParty party = partys.get(key);
            List<Candidate> list = party.getCandidates();
            
            Collections.sort(list); // Resolver depois, deve ter um lugar melhor pra ordenar essa lista.
            
            Candidate first = null;
            Candidate last = null;

            for(int i = 0; i < list.size(); i++) {
                first = list.get(i);
                
                if(first.validVote()) { // Tem que ser "v�lido"
                    break;
                }
                first = null;
            }
            
            for(int i = 0; i < list.size(); i++) {
                last = list.get(list.size() - 1 - i);

                if(last.validVote())
                    break;
                
                last = null;
            }
            
            if (first != null || last != null){ // Tem ou n�o tem esse if ???

                if(first.getNominalVotes() == 0 && last.getNominalVotes() == 0) continue;
                
            	//output.printf("%d - %s - %d, %s (%d, %d votos) / %s (%d, %d votos)\n", j, party.getAbreviation(), party.getNumber(), first.getBalBoxName(), first.getBalBoxNumber(), first.getNominalVotes(), last.getBalBoxName(), last.getBalBoxNumber(), last.getNominalVotes());
            	output.printf("%d - %s - %d, ", j, party.getAbreviation(), party.getNumber());
                output.printf("%s (%d, %d votos) ", first.getBalBoxName(), first.getBalBoxNumber(), first.getNominalVotes());
            	output.printf("/ ");
                output.printf("%s (%d, %d votos)", last.getBalBoxName(), last.getBalBoxNumber(), last.getNominalVotes());
                output.println();
                
                j++;
            }
        }
        output.println();
    } 

    public static void report9(List<Candidate> candidates, PrintWriter output){
        int lt30 = 0, lt40 = 0, lt50 = 0, lt60 = 0, bt60 = 0;
          
        for(Candidate p : candidates ) {
            if(p.elected()) {
                int age = p.age();
                if (age >= 0 && age < 30)       lt30++;
                else if (age >= 30 && age < 40) lt40++;
                else if (age >= 40 && age < 50) lt50++;
                else if (age >= 50 && age < 60) lt60++;
                else if (age >= 60)             bt60++;    
            }
        }
        
        int total = lt30 + lt40 + lt50 + lt60 + bt60;
        output.println("Eleitos, por faixa et�ria (na data da elei��o):");
        output.printf("      Idade < 30: %d (%.2f%%)\n", lt30, Utils.percent( lt30, total));
        output.printf("30 <= Idade < 40: %d (%.2f%%)\n", lt40, Utils.percent(lt40, total));
        output.printf("40 <= Idade < 50: %d (%.2f%%)\n", lt50, Utils.percent(lt50, total));
        output.printf("50 <= Idade < 60: %d (%.2f%%)\n", lt60, Utils.percent(lt60, total));
        output.printf("60 <= Idade     : %d (%.2f%%)\n\n", bt60, Utils.percent(bt60, total));  
    }

    public static void report10(List<Candidate> candidates, PrintWriter output) {
        int male = 0, female = 0;
        
        for(Candidate p : candidates ) {
            if(p.elected()) {
                if(p.getGender() == 'F') {
                    female++;  
                
                } else if (p.getGender() == 'M') {
                    male++;
                }
            }
        }
        
        output.println("Eleitos, por sexo:");
        output.printf("Feminino: %d (%.2f%%)\n", female , Utils.percent(female, female + male));
        output.printf("Masculino: %d (%.2f%%)\n\n", male, Utils.percent(male, female + male));
    }

    public static void report11(Map<Integer, PoliticParty> partys, PrintWriter output) {
        int nominal_votes = 0;
        int legend_votes = 0;
        
        for(int key : partys.keySet()) {
            PoliticParty party = partys.get(key);
            
            nominal_votes += party.qtdNominalVotes();
            legend_votes += party.getLegendVotes();
        }

        int total = nominal_votes + legend_votes;
        output.printf("Total de votos v�lidos:  %d\n", total);
        output.printf("Total de votos nominais: %d (%.2f%%)\n", nominal_votes, Utils.percent(nominal_votes, total));
        output.printf("Total de votos legenda:  %d (%.2f%%)\n", legend_votes, Utils.percent(legend_votes, total));
    }
}
