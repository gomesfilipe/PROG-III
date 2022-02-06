package TP1;

import java.util.Calendar;
import java.util.Formatter;

public class Candidate extends Person implements Comparable<Candidate> {
    private String balBoxName;
    private int balBoxNumber;
    private int nominalVotes;
    private String situation;
    private int partyNumber;
    private String voteDestination;
    private PoliticParty party;

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
    
    public PoliticParty getParty(){
        return this.party;
    }
    
    public void setParty(PoliticParty party) {
    	this.party = party;
    }

    public String getVoteDestination() {
		return this.voteDestination;
	}
    
    public Boolean elected() {
    	return this.getSituation().equals("Eleito");
    }
    
    public Boolean validVote() {
    	return this.getVoteDestination().equals("Válido");
    } 
    
    /**
 	 * @brief Método que auxilia a impressão de um candidato.
 	 * @return String que contém os campos de um candidato.
 	 */
    @Override
    public String toString() {
        Formatter fmt = new Formatter();
        fmt.format("Name: %s\nVoteDestination: %s\n", this.getName(), this.voteDestination);
        String s = fmt.out().toString();
        fmt.close();
        return s;
    }
    
    /**
  	 * @brief Esse método auxilia a ordenção dos candidatos. 
  	 * Nele, implementa-se a comparação por votos nominais entre dois candidatos.
  	 * Caso os votos nominais sejam iguam, o próximo critério analisado é a idade.
  	 * O candidato mais velho possui preferência sobre o mais novo.
  	 * @param:
 	 * 		@Candadidate Candidato que terá seus votos nominais comparados com os votos nominais de outro candidato.
  	 * @return Retorna um valor positivo ou negativo dependendo dos votos nominais dos candidatos comparados.
  	 */
    @Override
    public int compareTo(Candidate candidate) {
        if(candidate.nominalVotes == this.nominalVotes) {
            Calendar birth1 = this.getBirth();
            Calendar birth2 = candidate.getBirth();

            if(birth1.before(birth2)) return -1; // Candidate 1 is older 
            else return 1;   

        } else {
            return candidate.nominalVotes - this.nominalVotes;
        }
    }
}
