package principal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;
public class main {

	static Scanner scanner = new Scanner(System.in);
	static Random r = new Random();
	
	public static void main(String[] args) {
	sop("Numero de bolas");	
	n_de_bolas = scanner.nextInt();	
		for(int i = 0; i != n_de_bolas; i++){
		bola b = new bola();
		b.eixx = r.nextInt(map_larg);
		b.eixy = r.nextInt(map_alt);
		b.x = true;
		b.y = true;
		list.add(b);
		}
		mov_bol();
	}
	
	
	
	static int map_larg = 10;
	static int map_alt = 10;
	static int n_de_bolas;
	static String tela_jogo;
	
	static ArrayList<bola> list = new ArrayList();
	static ArrayList<String> mapa = new ArrayList();
	
	private static void mov_bol() {
		
		for(int j = 0; j <= map_alt; j++) {
			for(int k = 0; k <= map_larg; k++) {
			tela_jogo += " "; 
			}
			mapa.add(tela_jogo);
		}
			
		
		while(true) {
			for(int i = 0; i != n_de_bolas; i++){
				
				bola b = list.get(i);
				
				if(b.eixx == 0 || b.eixx == map_larg -1) {
					
					if (b.eixx == 0) {
						b.x = true;
					}else {
						b.x = false;
					} 	
				}
				
				if(b.eixy == 0 || b.eixy == map_alt -1) {
					
					if(b.eixy == 0) {
						b.y = true;
						if(b.x = true) {b.x = false;}else {b.x = true;}
					}else {
						b.y = false;
						if(b.x = true) {b.x = false;}else {b.x = true;}
					}
				}
				
				if(b.x = true) {
					b.eixx ++;
				}else{
					b.eixx --;
				}
				
				if(b.y = true) {
					b.eixy ++;
				}else{
					b.eixy --;
				}
				
				list.remove(i);
					
				list.add(i, b);
				
				tela_jogo = mapa.get(b.eixy);
				tela_jogo.substring(0,i);
				StringBuilder sb = new StringBuilder(mapa.get(b.eixy));
				sb.insert(b.eixx, '*');
				mapa.remove(b.eixy);
				mapa.add(b.eixy, sb.toString());
			}
			for(int x = 0; x != map_alt; x++){
				jogo += mapa.get(x) + "\n";
			}
			sop(jogo);
			try {
			Thread.sleep(100);}catch(Exception e) {}
		}
	}
	static String jogo; 
	public static void sop(String s) {
		System.out.print(s);
	}

}
