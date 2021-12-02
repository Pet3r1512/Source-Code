public class Person {
    
    public String name;
    public int priority;
    
    public Person(String name, int priority ){
        this.name=name;
        this.priority=priority;
    }

    @Override
    public String toString() {
        return name+"-"+priority;
    }
}
