import java.util.Scanner;


public class Main{
	public static void main(String[]args) {
		boolean escape=false;
		String menu = "1. ���������� ������� ���� � �����\r\n"
				+ "2. ���������� ������ �������� � �����\r\n"
				+ "3. ������� ������� �� ����� (���� ������� � �����)\r\n"
				+ "4. ������� ������� -> ��������� ������� ������������ � �����\r\n"
				+ "5. ���������� ������ ��������, ��������� �������� � ���� -> ���������� ��������� �� ����������� �������\r\n"
				+ "6. ��������� ������� � ����\r\n"
				+ "7. ����� �� ���������";
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
				System.out.println("����� ���� � �����: "+port.water);
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
				System.out.println("������� ��� �������: ");
				if(port.deleteShip(shipName.nextLine())) System.out.println("������� ������ �� �����, � ���� ���������");
				else {
					System.out.println("������� � ����� �������� ��� � �����");
				}
			}
			
			if("4".equals(str)) {
				System.out.println("������� ��� �������: ");
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
			
			//�������� �� �������� �������� � ����.
			for(int i=0; i<waitingShips.ships.size(); i++) {
				if(waitingShips.ships.get(i).checkForArrive()) {
					if(port.allShips[port.allShips.length-1]==null) {
						port.addShip(waitingShips.ships.get(i));
						System.out.println("������� � ������ "+waitingShips.ships.get(i).name+" ������� ������ � ����!");
						waitingShips.deleteShip(i);

					}
				}
			}
		}
	}
	
}