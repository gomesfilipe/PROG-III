package TP1;

import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

public class PoliticParty {
    private String name;
    private String abreviation;
    private int number;
    private int legendVotes;
    private List<Candidate> candidates;

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
	
	/**
	 * @brief Esse método auxilia na impressão de um partido.
	 * @return Retorna uma string com as informações de um partido.
	 */
	@Override
    public String toString() {
        Formatter fmt = new Formatter();
        fmt.format("Name: %s\nAbreviation: %s\nNumber: %d\nLegendVotes: %d\n", this.name, this.abreviation, this.number, this.legendVotes);
        String s = fmt.out().toString();
        fmt.close();
        return s;
    }
	
    /**
  	 * @brief Esse método calcula a quantidade de votos nominais de um partido. 
  	 * Isto é, a soma dos votos nominais de todos os candidatos do partido.
  	 * @return Retorna a quantidade de votos nominais de um partido.
  	 */
    public int qtdNominalVotes() {
    	int nominal_votes = 0;
    	for(Candidate p : this.getCandidates()) {
            if(p.validVote()) 
            	nominal_votes += p.getNominalVotes();
        }
    	return nominal_votes;
    }
    
    /**
  	 * @brief Esse método calcula a quantidade de candidatos de um partido que foram eleitos . 
  	 * @return Qantidade de candidatos eleitos de um partido.
  	 */
    public int qtdElected() {
    	int qtd_elected = 0;
    	for(Candidate c : candidates) {
    		if(c.elected()) {
    			qtd_elected++;
    		}
    	}
    	//int qtd_elected = Candidate.qtdElectedCandidates(this.candidates);
    	return qtd_elected;
    }
    
    /**
  	 * @brief Esse método calcula a quantidade total de votos de um partido.
  	 * @return Retorna a quantidade total de votos de um partido.
  	 */
    public int qtdTotalVotes() {
    	return this.qtdNominalVotes() + this.getLegendVotes();
    }
}

class CompareLVotes implements Comparator<PoliticParty> {	
	/**
  	 * @brief Esse método auxilia em uma das ordenções dos partidos. 
  	 * Nele, implementa-se a comparação por votos de legenda entre dois partidos.
  	 * Caso os votos de legenda sejam iguam, o próximo critério analisado são os votos nominais.
  	 * Caso os votos de nominais sejam iguam, o próximo critério analisado é o número dos partidos.
  	 * @param:
 	 * 		@m Partido que será comparado.
 	 * 		@n Partido que será comparado.
  	 * @return Retorna um valor positivo ou negativo dependendo dos votos de legenda dos partidos comparados.
  	 */
	public int compare(PoliticParty m , PoliticParty n){
        int legend_mvotes = m.getLegendVotes();
        int legend_nvotes = n.getLegendVotes();
        
        if(legend_mvotes == legend_nvotes) {
            int nominal_nvotes = n.qtdNominalVotes();
            int nominal_mvotes = m.qtdNominalVotes();
            
            if(nominal_nvotes == nominal_mvotes){
                return m.getNumber() - n.getNumber(); 
            }
            else{
                return nominal_nvotes - nominal_mvotes;
            }

        } else {
            return legend_nvotes - legend_mvotes;
        }
    }
}

class CompareNVotes implements Comparator<PoliticParty> {
	/**
  	 * @brief Esse método auxilia em uma das ordenções dos partidos. 
  	 * Nele, implementa-se a comparação por votos nominais entre dois partidos.
  	 * Caso os votos de nominais sejam iguam, o próximo critério analisado é o número dos partidos.
  	 * @param:
 	 * 		@m Partido que será comparado.
 	 * 		@n Partido que será comparado.
  	 * @return Retorna um valor positivo ou negativo dependendo dos votos nominais dos partidos comparados.
  	 */
	public int compare(PoliticParty m , PoliticParty n){
        List<Candidate> mlist = m.getCandidates();
        List<Candidate> nlist = n.getCandidates();
        
        int nominal_mvotes = 0;
        int nominal_nvotes = 0;
        
        for(Candidate c : mlist) {
            nominal_mvotes  = c.getNominalVotes();
            if(c.validVote()) {
                break;
            }
        }
        
        for(Candidate c : nlist) {
            nominal_nvotes  = c.getNominalVotes();
            if(c.validVote()) {
                break;
            }    
        }
        
     
        if(nominal_mvotes == nominal_nvotes) {
            return m.getNumber() - n.getNumber(); 
        } else {
            return nominal_nvotes - nominal_mvotes;
        }
    }
}

class CompareTVotes implements Comparator<PoliticParty> {
	/**
  	 * @brief Esse método auxilia em uma das ordenções dos partidos. 
  	 * Nele, implementa-se a comparação por votos totais entre dois partidos.
  	 * Caso os votos totais sejam iguam, o próximo critério analisado é o número dos partidos.
  	 * @param:
 	 * 		@m Partido que será comparado.
 	 * 		@n Partido que será comparado.
  	 * @return Retorna um valor positivo ou negativo dependendo dos votos totais dos partidos comparados.
  	 */
	public int compare(PoliticParty m , PoliticParty n){
        int total_mvotes = m.qtdTotalVotes();
        int total_nvotes = n.qtdTotalVotes();

        if(total_mvotes == total_nvotes) {
            return n.getNumber() - m.getNumber(); 
        } else {
            return total_nvotes - total_mvotes;
        }
    }
}
