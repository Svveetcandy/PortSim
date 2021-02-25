import java.util.Scanner;


public class Main{
	public static void main(String[]args) {
		boolean escape=false;
		String menu = "1. Посмотреть сколько воды в порту\r\n"
				+ "2. Посмотреть список кораблей в порту\r\n"
				+ "3. Удалить корабль из порта (вода остаётся в порту)\r\n"
				+ "4. Создать корабль -> наполнить корабль контейнерами с водой\r\n"
				+ "5. Посмотреть список кораблей, ожидающих прибытия в порт -> посмотреть инормацию по конкретному кораблю\r\n"
				+ "6. Загрузить корабль в порт\r\n"
				+ "7. Выйти из программы";
		Port port = new Port();
		Scanner shipName, choice;
		String noShip="noShip";
		Ship ship=new Ship(noShip);
		WaitingShips waitingShips=new WaitingShips();
		while(!escape) {
			System.out.println(menu);
			choice=new Scanner(System.in);
			String str=choice.nextLine();
			

			
			
			if("1".equals(str)) {
				System.out.println("Всего воды в порту: "+port.water);
			}
			
			if("2".equals(str)) {
				int count=1;
				for(int i=0; i<port.allShips.length; i++) {
					if(port.allShips[i]!=null) {
						System.out.print(count+". ");
						port.allShips[i].infoAboutShip();
						count++;
					}
				}
			}
			
			if("3".equals(str)) {
				shipName=new Scanner(System.in);
				System.out.println("Введите имя корабля: ");
				if(port.deleteShip(shipName.nextLine())) System.out.println("Корабль удален из порта, а вода выгружена");
				else {
					System.out.println("Корабля с таким имененем нет в порту");
				}
			}
			
			if("4".equals(str)) {
				System.out.println("Введите имя корабля: ");
				shipName=new Scanner(System.in);
				ship = new Ship(shipName.nextLine());
			}
			
			if("5".equals(str)) {
				waitingShips.info();
			}
			
			if("6".equals(str)) {
				if(ship.name!=noShip) {
					waitingShips.addShip(ship);
				}
			}
			
			if("7".equals(str)) {
				escape = true;
			}
			
			//Проверка на прибытие кораблей в порт.
			for(int i=0; i<waitingShips.ships.size(); i++) {
				if(waitingShips.ships.get(i).checkForArrive()) {
					if(port.allShips[port.allShips.length-1]==null) {
						port.addShip(waitingShips.ships.get(i));
						System.out.println("Корабль с именем "+waitingShips.ships.get(i).name+" успешно прибыл в порт!");
						waitingShips.deleteShip(i);

					}
				}
			}
		}
	}
	
}