package entity;

public class Person {
	public Person(String name2, String age2, String gender2) {
		this.name = name2;
		this.age = Integer.parseInt(age2);
		this.gender = gender2.charAt(0);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	String name;
	int age;
	char gender;
}
