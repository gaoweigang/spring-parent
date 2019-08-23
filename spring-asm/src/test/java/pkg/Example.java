package pkg;

public class Example {
	
	public void m(int i, int j){
		for(; cond(i); --i){
			if(j == 0){
				break;
			}
		}
	}
	
	public boolean cond(int i){
		if(i > 0){
			return true;
		}else{
			return false;
		}
	}

}
