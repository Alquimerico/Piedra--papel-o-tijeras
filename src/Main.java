import java.util.Random;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gui1 n = new gui1();
		//n.main(null);
		
	}
	public int match(int jugada, int jugadaEnemiga)
	{
		//Returns 1 if player 1 wins, 2 player 2 wins, 3 for a drawn 
		//Piedra = 1, Papel = 2, Tijera = 3
		if(jugada == jugadaEnemiga) return 3;
		if(jugada == 1 && jugadaEnemiga == 3) return 1;
		return 2;
	}
	public int random1_3()
	{
		//Computer player uses this one
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		return randomNum;
		
	}
	public static String matchOutcome(int n)
	{
		if(n==1) return "El jugador gana.";
		if(n==2) return "La maquina gana.";
		if(n==3) return "Ha habido un empate.";
		return "Algo ha salido muy mal :< ";
	}
	public static String intToppt(int n)
	{
		if(n==1) return "piedra";
		if(n==2) return "papel";
		if(n==3) return "tijeras";
		return "Algo ha salido muy mal :< ";
	}
	
	
	
	
}
