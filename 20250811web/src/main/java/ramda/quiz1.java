package ramda;

public class quiz1 {

	
	
	public static void main(String[] args) {

//		if(x>y) {
//			System.out.println("true");
//		}else {
//			System.out.println("false");
//		}
//		boolean z = (x > y ? true : false);
//		System.out.println(z);
		
		
		
//		GreaterThan fi = new GreaterThan() {
//			
//			@Override
//			public boolean three(int x, int y) {
//				if(x>y) {
//					System.out.println("true");
//				}else {
//					System.out.println("false");
//				}
//				boolean z = (x > y ? true : false);
//				System.out.println(z);
//			}
//		};
		
		GreaterThan fi = (x,y) ->x > y ? true : false;
		System.out.println(fi.result(20,30));
		
//		Factorial fac = (x) -> {return x==1 ? 1 : z * fac(x - 1)};
		
	}
	

}
