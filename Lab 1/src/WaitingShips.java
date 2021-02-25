import java.util.ArrayList;

public class WaitingShips {
	ArrayList<Ship> ships=new ArrayList<Ship>();
	
	public void addShip(Ship ship) {
		ship.sendShip();
		ships.add(ship);
	}
	
	public void deleteShip(int index) {
		ships.remove(index);
	}
	
	public void info() {
		for(int i=0; i<ships.size(); i++) {
			System.out.print((i+1)+". ");
			ships.get(i).infoAboutShip();
		}
	}
}