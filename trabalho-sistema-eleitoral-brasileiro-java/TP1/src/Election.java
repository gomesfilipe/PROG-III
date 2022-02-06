package TP1;

import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Election {
	private List<Candidate> candidates;
	private List<PoliticParty> partys;
	private Calendar date;

	public Election(List<Candidate> candidates, List<PoliticParty> partys, String date) {
        Election.insertCandidatesInPartys(candidates, partys);
        Election.insertPartyInCandidates(candidates, partys);
        
		this.candidates = candidates;
		this.partys = partys;
		this.date = Utils.convertDate(date);
	}
		
	/**
	 * @brief Esse método insere os candidatos de um partido qualquer na lista de candidatos desse partido qualquer.
	 * Essa inserção é feita para todos os partidos. Assim, a lista de candidatos de cada partido estará completa.
	 * @param:
	 * 		@partys É a lista de partidos
	 * 		@candidates É a lista de candidatos 
	 */
    private static void insertCandidatesInPartys(List<Candidate> candidates, List<PoliticParty> partys) {
        for(Candidate c : candidates) {
            int key = c.getPartyNumber();
            PoliticParty party = Election.searchParty(partys, key);
            List<Candidate> list = party.getCandidates();
            list.add(c);
        }

        for(PoliticParty p : partys) {    
            List<Candidate> list = p.getCandidates();
            Collections.sort(list);   
        }
    }
	
    /**
	 * @brief Esse método insere o partido de cada candidato em seu respectivo campo party.
	 * @param:
	 * 		@Candadidates  É a lista de candidatos
	 * 		@partys É a lista de partidos.
	 */
    private static void insertPartyInCandidates(List<Candidate> candidates, List<PoliticParty> partys) {
    	for(Candidate c : candidates) {
    		int key = c.getPartyNumber();
    		PoliticParty p = Election.searchParty(partys, key);
    		c.setParty(p);
    	}
    }
    
    /**
	 * @brief Esse método implementa a busca de um partido p na lista de partidos a partir do número do partido p.
	 * @param:
	 * 		@partys É a lista de partidos
	 * 		@key É o número do partido que queremos encontrar na lista de partidos 
	 * @return Retorna o partido correspondente ao número passado pelo parâmetro key.
	 */
    private static PoliticParty searchParty(List<PoliticParty> partys, int key) {
        for(PoliticParty p : partys) {
            if(p.getNumber() == key) {
                return p;
            }
        }
        return null;
    }
    
    /**
 	 * @brief Método que calcula quantos candidatos foram eleitos
 	 * @param:
	 * 		@Candadidates  É a lista de candidatos
 	 * @return Quantidade de candidatos que foram eleitos na eleição proporcional
 	 */
    public int qtdElectedCandidates(){
        int qtdElect = 0;
        
        for(PoliticParty p : partys) {
        	qtdElect += p.qtdElected();
        }
        
        // for(Candidate p : candidates){
        //     if(p.getSituation().equals("Eleito")) qtdElect++ ;
        // }
        
        return qtdElect;
    }
	
    /**
  	 * @brief Esse método imprime a quantidade de vagas para cargos de vereadores na eleição de 2020. 
  	 * @param:
 	 * 		@candidates É a lista de candidatos.
  	 */
    public void report1() {
        int qtdElect = this.qtdElectedCandidates();
        System.out.printf("Número de vagas: %d\n\n", qtdElect);
    }
   
	/**
  	 * @brief Esse método imprime as informações sobre os candidatos que foram eleitos a vereadores. 
  	 * @param:
 	 * 		@candidates É a lista de candidatos.
 	 * 		@partys É a lista de partidos.
  	*/
    public void report2() {
        Collections.sort(candidates);
        System.out.println("Vereadores eleitos: ");
        int i = 1;
        for(Candidate p : candidates) {
            if(p.elected()) {
                String abreviation = p.getParty().getAbreviation();
                System.out.printf("%d - %s / %s (%s, %d votos)\n", i, p.getName(), p.getBalBoxName(), abreviation, p.getNominalVotes());
                i++;
            } 
        }
        System.out.println();
    }
    
	/**
  	 * @brief Esse método imprime as informações sobre os candidatos que foram mais votados dentro do número de
  	 * vagas da eleição. Não necessariamente esses candidatos foram eleitos. 
  	 * @param:
 	 * 		@candidates É a lista de candidatos.
 	 * 		@partys É a lista de partidos.
  	*/
    public void report3() {
        Collections.sort(candidates);
        System.out.println("Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):");
        
        int qtd_elect = this.qtdElectedCandidates();
        int i = 1;
        for(Candidate p : candidates) {         
            String abreviation = p.getParty().getAbreviation();
            System.out.printf("%d - %s / %s (%s, %d votos)\n", i, p.getName(), p.getBalBoxName(), abreviation, p.getNominalVotes());
            
            if (i == qtd_elect) break;
            i++;
        }
        
        System.out.println();
    }
    
	/**
  	 * @brief Esse método imprime as informações sobre os candidatos que teriam sido eleitos a vereadore, caso a
  	 * votação fosse majoritária. 
  	 * @param:
 	 * 		@candidates É a lista de candidatos.
 	 * 		@partys É a lista de partidos.
  	*/
    public void report4() {
       Collections.sort(candidates);
       int qtdElect = this.qtdElectedCandidates();

       System.out.println("Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos:");
       System.out.println("(com sua posição no ranking de mais votados)");
        
        int i = 1;
        for(Candidate p : candidates){
            String abreviation = p.getParty().getAbreviation();
            if(!p.elected()){  //the person wasn't elected in proporcional election
            	System.out.printf("%d - %s / %s (%s, %d votos)\n", i, p.getName(), p.getBalBoxName(), abreviation, p.getNominalVotes()); 
            }
            if(i == qtdElect) break;
            i++;
        }
            
        System.out.println();
    }
    
	/**
  	 * @brief Esse método imprime as informações sobre os candidatos que foram eleitos apenas pelo fato
  	 *  da eleição ser proporcional. 
  	 * @param:
 	 * 		@candidates É a lista de candidatos.
 	 * 		@partys É a lista de partidos.
  	*/
    public void report5() {
        Collections.sort(candidates);
        int qtd_elect = this.qtdElectedCandidates();
        int elect_proportional = 0;

        System.out.println("Eleitos, que se beneficiaram do sistema proporcional:");
        System.out.println("(com sua posição no ranking de mais votados)");

        for(Candidate p : candidates) {
            if(p.elected()) {
                elect_proportional++;

                if(candidates.indexOf(p) > qtd_elect - 1) {
                    String abreviation = p.getParty().getAbreviation();
                    
                    System.out.printf("%d - %s / %s (%s, %d votos)\n", candidates.indexOf(p) + 1, p.getName(), p.getBalBoxName(), abreviation, p.getNominalVotes());
                }
            }
            
            if (elect_proportional == qtd_elect) break;
        }
        
        System.out.println();
    }

	/**
  	 * @brief Esse método imprime para cada partido:
  	 * O número de votos totalizados do patirdo.
  	 * O número de candidatos que foram eleitos do partido.
  	 * @param:
 	 * 		@partys É a lista de partidos.
  	*/
    public void report6(){
        Collections.sort(partys, new CompareTVotes());
        
        int i = 1;
        System.out.println("Votação dos partidos e número de candidatos eleitos:");
        
        for(PoliticParty p : partys) {
            int nominal_votes = p.qtdNominalVotes();
            int qtd_elected = p.qtdElected();
            int total_votes = p.qtdTotalVotes();
                        
            System.out.printf("%d - %s - %d, ",  i, p.getAbreviation(), p.getNumber());
            
            if(total_votes > 1) System.out.printf("%d votos ", total_votes);
            else System.out.printf("%d voto ", total_votes);

            if( nominal_votes > 1) System.out.printf("(%d nominais e ", nominal_votes);
            else  System.out.printf("(%d nominal e ", nominal_votes);
            
            System.out.printf("%d de legenda), ", p.getLegendVotes() );

            if(qtd_elected > 1) System.out.printf("%d candidatos eleitos\n", qtd_elected);
            else System.out.printf("%d candidato eleito\n", qtd_elected);
            
            i++; 
        }

        System.out.println();
    }
    
	/**
  	 * @brief Esse método imprime as informações sobre os votos de legenda de cada partido.
  	 * @param:
 	 * 		@partys É a lista de partidos.
  	*/
    public void report7() {
        Collections.sort(partys, new CompareLVotes());
        
        System.out.println("Votação dos partidos (apenas votos de legenda):");
        
        int total_votes = 0;
        int i = 1;
        
        for(PoliticParty p : partys) {
            total_votes = p.qtdTotalVotes();
            
            System.out.printf("%d - %s - %d, ", i, p.getAbreviation(), p.getNumber());
            if(p.getLegendVotes() > 1) {
                System.out.printf("%d votos de legenda ", p.getLegendVotes());

            }else {
                System.out.printf("%d voto de legenda ", p.getLegendVotes());
            }
            
            if(total_votes != 0){
            	System.out.printf("(%.2f%% do total do partido)\n", Utils.percent(p.getLegendVotes(), total_votes));
            } else {
            	System.out.printf("(proporção não calculada, 0 voto no partido)\n");
            }
            
            i++;
        }

        System.out.println();
    }
    
	/**
  	 * @brief Esse método imprime as informações sobre o primeiro e o último colocados de cada partido em relação
  	 * aos votos nominais. 
  	 * @param:
 	 * 		@partys É a lista de partidos.
  	*/
    public void report8() {
    	int j = 1;
 
    	Collections.sort(partys, new CompareNVotes());
   
    	System.out.println("Primeiro e último colocados de cada partido:");
        
        for(PoliticParty p : partys) {
            List<Candidate> list = p.getCandidates();
            
            
            Candidate first = null;
            Candidate last = null;

            for(int i = 0; i < list.size(); i++) {
                first = list.get(i);
                
                if(first.validVote()) { 
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
            
            if (first != null || last != null){

                if(first.getNominalVotes() == 0 && last.getNominalVotes() == 0) continue;
                
                System.out.printf("%d - %s - %d, ", j, p.getAbreviation(), p.getNumber());
                System.out.printf("%s (%d, ", first.getBalBoxName(), first.getBalBoxNumber());
                if(first.getNominalVotes() == 0 || first.getNominalVotes() == 1 ) {
                    System.out.printf("%d voto) ", first.getNominalVotes());
                }
                else {
                    System.out.printf("%d votos) ", first.getNominalVotes());
                }

                System.out.printf("/ ");
                System.out.printf("%s (%d, ", last.getBalBoxName(), last.getBalBoxNumber());
                if(last.getNominalVotes() == 0  || last.getNominalVotes() == 1) {
                    System.out.printf("%d voto) ", last.getNominalVotes());
                }
                else {
                    System.out.printf("%d votos) ", last.getNominalVotes());
                }
                System.out.println();
                j++;
            }
        }
        
        System.out.println();
    } 
    
	/**
  	 * @brief Esse método imprime a faixa etária dos candidatos que foram eleitos. 
  	 * @param:
 	 * 		@candidates É a lista de candidatos.
  	*/
    public void report9(){
        int lt30 = 0, lt40 = 0, lt50 = 0, lt60 = 0, bt60 = 0;
          
        for(Candidate p : candidates ) {
            if(p.elected()) {
                int age = p.age(this.date);
                if (age >= 0 && age < 30)       lt30++;
                else if (age >= 30 && age < 40) lt40++;
                else if (age >= 40 && age < 50) lt50++;
                else if (age >= 50 && age < 60) lt60++;
                else if (age >= 60)             bt60++;    
            }
        }
     
        int total = lt30 + lt40 + lt50 + lt60 + bt60;
        System.out.println("Eleitos, por faixa etária (na data da eleição):");
        System.out.printf("      Idade < 30: %d (%.2f%%)\n", lt30, Utils.percent( lt30, total));
        System.out.printf("30 <= Idade < 40: %d (%.2f%%)\n", lt40, Utils.percent(lt40, total));
        System.out.printf("40 <= Idade < 50: %d (%.2f%%)\n", lt50, Utils.percent(lt50, total));
        System.out.printf("50 <= Idade < 60: %d (%.2f%%)\n", lt60, Utils.percent(lt60, total));
        System.out.printf("60 <= Idade     : %d (%.2f%%)\n\n", bt60, Utils.percent(bt60, total));  
    }
    
	/**
  	 * @brief Esse método imprime a distribuição de candidatos por sexo feminino e masculino. 
  	 * @param:
 	 * 		@candidates É a lista de candidatos.
  	 */
    public void report10() {
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
        
        System.out.println("Eleitos, por sexo:");
        System.out.printf("Feminino: %d (%.2f%%)\n", female , Utils.percent(female, female + male));
        System.out.printf("Masculino: %d (%.2f%%)\n\n", male, Utils.percent(male, female + male));
    }
    
	/**
  	 * @brief Esse método imprime as informações dos votos de cada partido. Isto é, o número absoluto e 
  	 * em porcentagem dos votos nominais e de legenda de cada partido e o número de votos válidos de cada partido. 
  	 * @param:
 	 * 		@partys É a lista de partidos.
  	 */
    public void report11() {
        int nominal_votes = 0;
        int legend_votes = 0;
        
        for(PoliticParty p : partys) {
            nominal_votes += p.qtdNominalVotes();
            legend_votes += p.getLegendVotes();
        }

        int total = nominal_votes + legend_votes;
        System.out.printf("Total de votos válidos:  %d\n", total);
        System.out.printf("Total de votos nominais: %d (%.2f%%)\n", nominal_votes, Utils.percent(nominal_votes, total));
        System.out.printf("Total de votos de legenda: %d (%.2f%%)\n", legend_votes, Utils.percent(legend_votes, total));
    }
}
