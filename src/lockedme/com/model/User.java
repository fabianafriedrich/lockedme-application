package lockedme.com.model;

public class User implements Comparable<User> {
	private String name;

	public User() {
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(User user) {
		return this.getName().compareTo(user.getName());
	}

}
