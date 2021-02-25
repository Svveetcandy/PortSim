
public class Port {
	Ship[] allShips=new Ship[10];
	int firstFreePlace=0;
	int water=0;
	
	
	boolean deleteShip(String name) {
		
		int indexOfSearchingShip=checkForExist(name);
		if(indexOfSearchingShip!=-1) {
			for(int i=indexOfSearchingShip; i<allShips.length-1; i++) {
				allShips[i]=allShips[i+1];
				
			}
			return true;
		} else return false;
	}
	
	boolean addShip(Ship ship) {
		if(firstFreePlace<10) {
			allShips[firstFreePlace]=ship;
			unloadTheShip(ship);
			firstFreePlace++;
			return true;
		} else return false;
	}
	
	int checkForExist(String name) {
		for(int i=0; i<allShips.length; i++) {
			if(allShips[i]!=null) {
				if(allShips[i].name.equals(name)) {
					allShips[i]=null;
					firstFreePlace--;
					return i;
				}
			}
		}
		return -1;
	}

	void unloadTheShip(Ship ship) {
		water=water+ship.returnWater();
	}
}
