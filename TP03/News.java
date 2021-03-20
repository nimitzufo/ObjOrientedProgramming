import java.util.ArrayList;


public class News {

	public static ArrayList<String> fakeNews() {
		
		ArrayList<String> fakeNews = new ArrayList<String>();
			fakeNews.add("senador empreendedor fica rico com loja de chocolates. veja detalhes");
			fakeNews.add("comitiva diplomática brasileira deixa o país usando máscara\n");
			fakeNews.add("ex-juiz, ex-ministro ganha medalha por atuação na operação lava-a-jato\nConfiança do investidor extrangeiro dispara.");
			fakeNews.add("presidente genocida com histórico de atleta vence covid\n 'foi mais do que uma gripezinha'");
			fakeNews.add("presidente do banco central atual declara:\n \"tenho o emprego mais fácil do mundo, não entendo por que meus antecessores renunciaram\".");
			fakeNews.add("ministro da saúde da vez adverte: \"não sou mágico\".");
			fakeNews.add("(TBT) presidente da república relembra seu \"sou messias mas não faço milagre, taokey\"");
			fakeNews.add("armas de fogo: o fetiche que está aquecendo ainda mais o mercado do setor de eventos funerários.");
			fakeNews.add("diplomatas brasileiros são vacinados em israel. \nEvento já está conhecido como o escândalo do 'turismo medicinal'");
		
		return fakeNews;
	}


	public static void main(String[] args) {
		ArrayList<String> defaultFakeNews = fakeNews();
	
	}


}