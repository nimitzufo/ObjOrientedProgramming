import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.io.*;


public class NewsFolder {
	
	public static void writeToFile() {
		//default fakeNews 
		try {
			String pathToDirectory = System.getProperty("user.dir");
			BufferedWriter fake = new BufferedWriter(new FileWriter(pathToDirectory + "fakeFile.txt"));
			fake.write("senador empreendedor fica rico com loja de chocolates. veja detalhes\n");
			fake.write("comitiva diplomática brasileira deixa o país usando máscara\n");
			fake.write("ex-juiz, ex-ministro ganha medalha por atuação na operação lava-a-jato. Confiança do investidor extrangeiro dispara.\n");
			fake.write("presidente genocida com histórico de atleta vence covid: 'foi mais do que uma gripezinha'\n");
			fake.write("presidente do banco central atual declara: \"tenho o emprego mais fácil do mundo, não entendo por que meus antecessores renunciaram\".\n");
			fake.write("ministro da saúde da vez adverte: \"não sou mágico\".\n");
			fake.write("(TBT) presidente da república relembra seu \"sou messias mas não faço milagre, taokey\"\n");
			fake.write("armas de fogo: o fetiche que está aquecendo ainda mais o mercado do setor de eventos funerários.\n");
			fake.write("diplomatas brasileiros são vacinados em israel. Evento já está conhecido como o escândalo do 'turismo medicinal'\n");
			fake.close();
			
		} catch(Exception ex) {
			return;
		}

	}
	
	
	//pass string from user input as an argument
	public static void writeToFile(String userFakeNews) {
		
		try {
			String pathToDirectory = System.getProperty("user.dir");
			BufferedWriter fake = new BufferedWriter(new FileWriter(pathToDirectory + "fakeFile.txt"));
			fake.write("senador empreendedor fica rico com loja de chocolates. veja detalhes\n");
			fake.write("comitiva diplomática brasileira deixa o país usando máscara\n");
			fake.write("ex-juiz, ex-ministro ganha medalha por atuação na operação lava-a-jato. Confiança do investidor extrangeiro dispara.\n");
			fake.write("presidente genocida com histórico de atleta vence covid: 'foi mais do que uma gripezinha'\n");
			fake.write("presidente do banco central atual declara: \"tenho o emprego mais fácil do mundo, não entendo por que meus antecessores renunciaram\".\n");
			fake.write("ministro da saúde da vez adverte: \"não sou mágico\".\n");
			fake.write("(TBT) presidente da república relembra seu \"sou messias mas não faço milagre, taokey\"\n");
			fake.write("armas de fogo: o fetiche que está aquecendo ainda mais o mercado do setor de eventos funerários.\n");
			fake.write("diplomatas brasileiros são vacinados em israel. Evento já está conhecido como o escândalo do 'turismo medicinal'\n");
			fake.write(userFakeNews + "\n");
			fake.close();
			
		} catch(Exception ex) {
			return;
		}

	}
	
	
	public static void main(String[] args) {
		
	
	}


}