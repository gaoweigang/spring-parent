package pkg;

public class MethodExample {
	
	private int f;
	
	public void checkAndSetF(int f){
		if( f >= 0){
			this.f = f;
		}else{
			throw new IllegalArgumentException();
		}
	}

}
