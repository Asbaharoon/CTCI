public abstract class Animal{
	protected String type;
	protected int id;
	public void setId(int id){
		this.id = id; 
	}
	public int getId(){
		return id;
	}
	public String getType(){
		return type;
	}
}

public class Dog extends Animal{
	public Dog(){
		type = "Dog";
	}
}

public class Cat extends Animal{
	public Cat(){
		type = "Cat"
	}
}

public class Shelter<Animal>{
	public static final String DOG = "Dog";
	public static final String CAT = "Cat";
	private LinkedList<Animal> dogList;
	private LinkedList<Animal> catList;
	private static id = 1;
	public Shelter(){
		dogList = new LinkedList<>();
		catList = new LinkedList<>();
	}

	public void enqueue(Animal animal){
		if(animal.getType().equals(DOG)){
			animal.setId(id);
			dogList.add(animal);
		}else if(animal.getType().equals(CAT)){
			animal.setId(id);
			catList.add(animal);			
		}
		id++;
	}

	public Animal dequeueAny(){
		if(dogList.size()==0&&catList.size()==0){throw new EmptyQueueException();}
		if(dogList.size()==0){return dequeueCat();}
		if(catList.size()==0){return dequeueDog();}
		Animal target = dogList.peek().getId()<catList.peek().getId()?dogList.remove():catList.remove();
		return target;
	}

	public Dog dequeueDog(){
		Animal dog = dogList.remove();
		return dog;
	}

	public Cat dequeueCat(){
		Animal cat = catList.remove();
		return cat;
	}
}
