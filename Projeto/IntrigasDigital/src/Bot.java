import java.security.SecureRandom;

public class Bot extends Jogador {
	
	public Bot(String vnome) {
		super(vnome);
	}
	
	public EnumTipoAcao decideAcao() { //esse metodo eh chamado pelo metodo passaVez() da Fluxo
		
		SecureRandom random = new SecureRandom();
		
		if(torroes<0) torroes = 0; //certificando-me que nao tah bugado.
		
		int chave = random.nextInt(4);
		int torroesNecessarios = 0;
		EnumTipoAcao acao = EnumTipoAcao.PEGAR1TORRAO;
		
		//testeeee
		//chave=3;
		
		switch(chave) {
		case 0:
			acao=EnumTipoAcao.PEGAR1TORRAO;
			break;
		case 1:
			acao = EnumTipoAcao.TROCARCARTA;
			torroesNecessarios = 2;
			break;
		case 2:
			acao = EnumTipoAcao.ATAQUEINDEFENSAVEL;
			torroesNecessarios = 7;
			break;
		case 3:
			acao = EnumTipoAcao.PERSONAGEM;
			break;
		default:
				break;
		}
		
		//se nao os torroes nao sao suficientes, chama esse metodo de novo ateh serem.
		if (torroes<torroesNecessarios) //mae, eu sei recursao o/
			acao = decideAcao();
		
		
		if(torroes>6) {
			acao=EnumTipoAcao.ATAQUEINDEFENSAVEL;
		}
		
		return acao;
	}
	
	public EnumPersonagem decidePersonagem() {
		
		if(torroes<0) torroes = 0;
		int torroesNecessarios = 0;
		
		EnumPersonagem p = EnumPersonagem.KANE;
		
		SecureRandom random = new SecureRandom();
		int chave = random.nextInt(5);
		
		switch(chave) {
		case 0:
			break;
		case 1:
			p=EnumPersonagem.LAURA;
			break;
		case 2:
			p=EnumPersonagem.JULIUS;
			torroesNecessarios = 3;
			break;
		case 3:
			p=EnumPersonagem.NINETA;
			break;
		case 4:
			p=EnumPersonagem.PISTONE;
			torroesNecessarios = 2;
			break;
		default:
			System.out.println("caso default atingido no Bot.decidePersonagem");	
		}
		
		//se nao os torroes nao sao suficientes, chama esse metodo de novo ateh serem.
		if (torroes<torroesNecessarios) //mae, eu sei recursao o/
			p = decidePersonagem();
		
		//testeee
		//p=EnumPersonagem.JULIUS;
		
		return p;
	}
}
