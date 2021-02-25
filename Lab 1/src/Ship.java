import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ship {
	String name;
	Deck[] decks = new Deck[2];
	long timeLeave;
	long timeArrive;
	long timeInSea=60000;
	
	public Ship(String name) {
		
		for(int i=0; i<decks.length; i++) {
			decks[i]=new Deck();
		}
		
		this.name=name;
		fillShip();
	}
	
	void fillShip() {
		int index=0;
		boolean escape = false;
		while(!escape) {
			while(index<2) {
				System.out.print("1. Маленький контейнер.\r\n2. Большой контейнер.\r\n3. Выход\r\n");
				Scanner choiceOfContainer=new Scanner(System.in);
				String str=choiceOfContainer.nextLine();
				if("1".equals(str)) {
					if(decks[index].addSmallContainer()) {
						System.out.println("Контейнейр успешно добавлен!");
						if(decks[index].containers.size()==2) index++;
					}else {
						if(index==0) {
							index++;
						} else {
							System.out.println("Невозможно добавить маленький контейнер.");
						}
					}
				}
				
				if("2".equals(str)) {
					if(decks[index].addLargeContainer()) {
						index++;
						System.out.println("Контейнейр успешно добавлен!");
					}else {
						
						System.out.println("Невозможно добавить большой контейнер.");
					}
				}
				if("3".equals(str)) {
					index=3;
				}
			}
			escape=true;
			System.out.println("Корабль загружен!");
		}
	}

	public int returnWater() {
		int water=0;
		for(int i=0; i<decks.length; i++) {
			water=decks[i].returnWater()+water;
		}
		return water;
	}
	
	public void sendShip() {
        timeLeave = System.currentTimeMillis();
        timeArrive=timeLeave+timeInSea;
	}
	
	public boolean checkForArrive() {
		long timeCurrent =System.currentTimeMillis();
		if(timeCurrent>timeArrive) return true;
		else return false;
	}

	public void infoAboutShip() {
		
		Date dateLeave=new Date(timeLeave);
		Date dateArrive=new Date(timeArrive);
		SimpleDateFormat formatForDate = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
		Date date = new Date();
		date.getTime();
		System.out.println(name+"\t-\t"+returnWater()+"( "+ formatForDate.format(timeLeave)+"\t-\t"+formatForDate.format(timeArrive)+")");
	}
}
