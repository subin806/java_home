package ex_241023;

public class Person {
	private String name;
	private String phoneNumber;
	private String registrationDate;

	public Person(String name, String phoneNumber, String registrationDate) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.registrationDate = registrationDate;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void printPersonInfo() {
		System.out.println("이름:" + name + " 연락처:" + phoneNumber + " 등록날짜 :" + registrationDate);
	}

}
