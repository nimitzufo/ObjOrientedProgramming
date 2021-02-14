import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;


public class Temperatures {

	public static void printStarterMenu() {
		
		System.out.println("Temperaturas da década 2011-2020");
		System.out.println("1 - Entrada das temperaturas");
		System.out.println("2 - Cálculo da temperatura média");
		System.out.println("3 - Cálculo da temperatura mínima");
		System.out.println("4 - Cálculo da temperatura máxima");
		System.out.println("5 - Relatório meteorológico");
	}
	
	
	public static void getDate() {
		Date date = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Insira a data ");
		String inputDate = scan.next();
		
		try {
		    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    formatter.setLenient(false);
		    date = formatter.parse(inputDate);
		    System.out.println(date);
		} catch (ParseException e) { 
		    System.out.println("Data inválida");
			e.printStackTrace();
		}
	}
	
	
	public static int getUserInputMenu() {
		Scanner scan = new Scanner(System.in);
		int number = 0;
		do {
			System.out.println("Escolha uma das opções(1-5):");
			while (!scan.hasNextInt()) {
				System.out.println("Sua entrada deve ser um número");
				scan.next();
			}
			number = scan.nextInt();
		} while(number<1 || number>5);
		System.out.println("Sua escolha "+ number);
		return number;
	}
	

	public static int getMonth() {
		Scanner scan = new Scanner(System.in);
		int number = 0;
		do {
			while (!scan.hasNextInt()) {
				System.out.println("Sua entrada deve ser um número entre um e doze");
				scan.next();
			}
			number = scan.nextInt();
		} while(number<1 || number>12);
		System.out.println("mês "+ number);
		return number;
	}
	
	
	public static int getYear() {
		Scanner scan = new Scanner(System.in);
		int number = 0;
		do {
			while (!scan.hasNextInt()) {
				System.out.println("Sua entrada deve ser um número entre 2011 e 2020");
				scan.next();
			}
			number = scan.nextInt();
		} while(number<2011 || number>2020);
		System.out.println("ano "+ number);
		return number;
	}
	
	
	public static int[] getMonthAndYear() {
		System.out.println("Insira o mês(1-12): ");
		int month = getMonth();
		System.out.println("Insira o ano(2011-2020)");
		int year = getYear();
		
		int[] monthYear = {month, year};
		return monthYear;		
	}
	
	
	public static HashMap getDayAvgTemperature(int month, int year) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Insira a temperatura média para o dia em questão: ");
		
		int daysInMonth = getNumberOfDaysInMonth(year, month);
		System.out.println("O mês " + month + " têm " + daysInMonth + " dias");
		int currentDay = 1;
		HashMap<Integer, Integer> dailyTemperatures = new HashMap<Integer, Integer>();
		while (currentDay <= daysInMonth) {
			System.out.println("Insira a temperatura média para o dia " + currentDay);
			while(!scan.hasNextInt()) {
				System.out.println("Temperatura inválida");
				scan.next();
			} int avgTemperature = scan.nextInt();
			dailyTemperatures.put(currentDay, avgTemperature);
			currentDay++;		
		}

		return dailyTemperatures;		
	}
	
	
	public static int getNumberOfDaysInMonth(int year, int month) {
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		return daysInMonth;
	}
	
	
	public static int calcAvgTemperature(int month, int year, int sumOfTemperatures) {
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth();
		System.out.println("dias no mes " + daysInMonth);
		int avgTemp = sumOfTemperatures/daysInMonth;
		
		return avgTemp;
	}
	
	
	public static int sumTemperaturesInHashMap(HashMap<Integer, Integer> dailyTemperatures ) {
		int sumTemp = 0;
		for (Integer i : dailyTemperatures.keySet()) {
			  System.out.println(i);
			  sumTemp = sumTemp + i;
			}
		return sumTemp;
	}

	
	public static int minTemp(ArrayList<Integer> tempsToFind) {
		int sizeOfArray = tempsToFind.size();
		int minTemperature = Collections.min(tempsToFind);;
		return minTemperature;
	}
	
	
	public static int maxTemp(ArrayList<Integer> tempsToFind) {
		int sizeOfArray = tempsToFind.size();
		int maxTemperature = Collections.min(tempsToFind);;
		return maxTemperature;
		
	}
	
	
	private static ArrayList<Integer> generateRandomTemperaturesInRange(int daysInMonth) {
		ArrayList<Integer> temperatures = new ArrayList<Integer>();
		//array int temperature = 0;
	    int min = 19, max = 32;
        Random r = new Random();
        for (int i = 0; i < daysInMonth; i++) {
        	temperatures.add(r.ints(min, (max + 1)).findFirst().getAsInt());
        }
        return temperatures;
    }
	
	
	private static int sumTemperaturesInArrayList(ArrayList<Integer> tempsToSum){
		int sum = 0;
		for (int i = 0; i < tempsToSum.size(); i++) {
		      sum = sum + tempsToSum.get(i);
		    }
		return sum;
	}
	
	/*
	o usuário irá dizer qual o mês e ano que entrará com os dados e
	depois entrar com a média de temperatura de cada um dos dias daquele mês/ano.
	*/
	public static HashMap inputOne() {
		System.out.println("Entrada das temperaturas");
		System.out.println("Usuário deve inserir o mês/ano seguido da média de temperatura para cada dia do mês");
		int[] monthYear = getMonthAndYear();
		HashMap<Integer, Integer> dailyMonthAvgTemperatures = new HashMap<Integer, Integer>();
		dailyMonthAvgTemperatures = getDayAvgTemperature(monthYear[0], monthYear[1]);
		System.out.println(dailyMonthAvgTemperatures);
		return dailyMonthAvgTemperatures;		
	}
	
	
	/*
	 2. Cálculo da temperatura média: o usuário deverá dizer qual é o mês e ano desejado e o
	programa irá calcular a média de temperatura daquele mês/ano.
	 */
	//default argument 01/2020
	public static void inputTwoWithUserInput(HashMap<Integer, Integer> userInputTempHashMap) {
		System.out.println("Cálculo da temperatura média");
		System.out.println("Insira o mês e o ano desejado para o cálculo da temperatura média");
		//if there is an user input(a hashmap) use it to sumTemperatures
		//if not, take the random generated temperatures
		int[] monthYear = getMonthAndYear();
		int sumOfTemperatures = 0;
			sumOfTemperatures = sumTemperaturesInHashMap(userInputTempHashMap);
		
		int AvgTemperature = calcAvgTemperature(monthYear[0],monthYear[1], sumOfTemperatures);
		System.out.println("Temperatura média:\t " + AvgTemperature);	
	}
	
	
	public static void inputTwoWithoutUserInput() {
		System.out.println("Cálculo da temperatura média");
		System.out.println("Insira o mês e o ano desejado para o cálculo da temperatura média");
		int[] monthYear = getMonthAndYear();
		int daysInMonth = getNumberOfDaysInMonth(monthYear[1], monthYear[0]);
		int sumOfTemperatures = 0;
		sumOfTemperatures = sumTemperaturesInArrayList(generateRandomTemperaturesInRange(daysInMonth)); 
		
		int AvgTemperature = calcAvgTemperature(monthYear[0],monthYear[1], sumOfTemperatures);
		System.out.println("Temperatura média:\t " + AvgTemperature);	
	}
	
	/*
 	3. Cálculo da temperatura mínima: o usuário deverá dizer qual é o mês e ano desejado e o
	programa irá mostrar a temperatura mínima daquele mês/ano. O programa deve indicar qual foi o
	dia/mês/ano (ou dias no caso de temperaturas iguais), em que a temperatura mínima aconteceu.
	*/
	public static void inputThreeWithUserInput(HashMap<Integer, Integer> userInputTempHashMap) {
		System.out.println("Five");		
	}

	public static void inputThreeWithoutUserInput() {
		System.out.println("Cálculo da temperatura mínima");
		System.out.println("Insira o mês e o ano desejado para o cálculo da temperatura média");
		int[] monthYear = getMonthAndYear();
		int daysInMonth = getNumberOfDaysInMonth(monthYear[1], monthYear[0]);
		int minTemperature = minTemp(generateRandomTemperaturesInRange(daysInMonth)); 
		
		System.out.println("Temperatura mínima:\t " + minTemperature);
	}

	/*
	4. Cálculo da temperatura máxima: o usuário deverá dizer qual é o mês e ano desejado e o
	programa irá mostrar a temperatura máxima daquele mês/ano. O programa deve indicar qual
	foi o dia/mês/ano (ou dias no caso de temperaturas iguais), em que a temperatura máxima
	aconteceu.
	*/
	public static void inputFourWithUserInput(HashMap<Integer, Integer> userInputTempHashMap) {
		System.out.println("Four");
	}
	public static void inputFourWithoutUserInput() {
		System.out.println("Cálculo da temperatura mínima");
		System.out.println("Insira o mês e o ano desejado para o cálculo da temperatura média");
		int[] monthYear = getMonthAndYear();
		int daysInMonth = getNumberOfDaysInMonth(monthYear[1], monthYear[0]);
		int maxTemperature = maxTemp(generateRandomTemperaturesInRange(daysInMonth)); 
		
		System.out.println("Temperatura máxima:\t " + maxTemperature);
	}
	
	
	/*
	5. Relatório meteorológico: o usuário deverá dizer qual é o mês e ano desejado e o programa irá
	apresentar um relatório contendo:

	• As médias de temperatura de cada um dos dias daquele mês
	• A média de temperatura daquele mês
	• A mínima de temperatura daquele mês
	• A máxima de temperatura daquele mês
	*/
	public static void inputFiveWithUserInput(HashMap<Integer, Integer> userInputTempHashMap) {
		System.out.println("Five");		
	}
	public static void inputFiveWithoutUserInput() {
		
		System.out.println("Relatório meteorológico");
		System.out.println("Insira o mês e o ano desejado para o cálculo da temperatura média");
		int[] monthYear = getMonthAndYear();
		int daysInMonth = getNumberOfDaysInMonth(monthYear[1], monthYear[0]);
		int minTemperature = minTemp(generateRandomTemperaturesInRange(daysInMonth)); 
		int maxTemperature = maxTemp(generateRandomTemperaturesInRange(daysInMonth)); 
		int sumOfTemperatures = 0;
		
		sumOfTemperatures = sumTemperaturesInArrayList(generateRandomTemperaturesInRange(daysInMonth)); 
		int AvgTemperature = calcAvgTemperature(monthYear[0],monthYear[1], sumOfTemperatures);
		
		System.out.println("Temperatura média:\t " + AvgTemperature);		
		System.out.println("Temperatura mínima:\t " + minTemperature);
		System.out.println("Temperatura máxima:\t " + maxTemperature);


	}
	
	
	public static int restart() {
		System.out.println(" ");
		System.out.println(" ");
		printStarterMenu();
		int choice = 0;
		return choice = getUserInputMenu();
	}
	

	public static void main(String[] args) {
		int choice = 0;
		boolean userInput = false;
		printStarterMenu();
		choice = getUserInputMenu();
		HashMap<Integer, Integer> userInputTempHashMap = new HashMap<Integer, Integer>();
		int defaultMaxTemp = 32; 
		int defaultMinTemp = 19; 
				
		if (choice == 1) {
			userInputTempHashMap = inputOne();
			 //calcMaxTemperature();
			 //calcMinTemperature();
			 restart();
		}
		if (choice == 2) {
			if(userInput == true) {
				 inputTwoWithUserInput(userInputTempHashMap);
			 } else {
				 inputTwoWithoutUserInput();
			 }
		}
		if (choice == 3) {
			if(userInput == true) {
				inputThreeWithUserInput(userInputTempHashMap);
			 } else {
				 inputThreeWithoutUserInput();
			 }
		}
		if (choice == 4) {
			if(userInput == true) {
				inputFourWithUserInput(userInputTempHashMap);
			 } else {
				 inputFourWithoutUserInput();
			 }
		}
		if (choice == 5) {
			if(userInput == true) {
				inputFiveWithUserInput(userInputTempHashMap);
			 } else {
				 inputFiveWithoutUserInput();
			 }
		}
	}
}



/*
Para facilitar a correção do seu trabalho, na função main cadastre automaticamente dados 
aleatórios referentes ao mês de janeiro de 2020.
https://www.accuweather.com/pt/br/bras%C3%ADlia/43348/january-weather/43348?year=2020
max 32 min 19 
*/
