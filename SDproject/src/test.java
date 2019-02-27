
public class test {
public static void main(String[] args) {
	String rule = "^(0|[1-9][0-9]?|100)$";
	
	if("-1".matches(rule)) {
		System.out.println("match");
	}else {
		System.out.println("wrong input");
	}
	
}

}
