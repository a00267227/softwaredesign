package entity;

public class Person {
	public Person(String name2, int age2, char gender2) {
		this.name = name2;
		this.age = age2;
		this.gender = gender2;
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
