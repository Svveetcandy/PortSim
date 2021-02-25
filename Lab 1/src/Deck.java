import java.util.ArrayList;

public class Deck {
	ArrayList<Container> containers = new ArrayList<Container>();
	public boolean addLargeContainer() {
		if(checkForLarge()) {
			 containers.add(new Large());
			 return true;
		} else return false;
		
	}
	public boolean addSmallContainer() {
		if(checkForSmall()) {
			containers.add(new Small());
			return true;
		} else return false;
		
	}
	
	boolean checkForSmall() {
		if(containers.size()==0) return true;
		else {
			if(containers.size()==1) {
				if(containers.get(containers.size()-1) instanceof Small) return true;
				else return false;
			}else return false;

		}
	}
	boolean checkForLarge() {
		if(containers.size()==0) return true;
		else return false;
	}
	
	public int returnWater() {
		int water=0;
		for(int i=0; containers.size()>i; i++) {
			water=containers.get(i).litresOfWater+water;
		}
		return water;
	}
}
