package model.person;

public abstract class Person {
    private String name;

    public Person(String name){
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public void whoYouAre(){
        System.out.println("Person "+ getName());
    }
}
