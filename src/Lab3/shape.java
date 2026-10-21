package Lab3;

abstract public class shape{
    private String name;
    private String color;
    abstract double calculateArea();
    String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;
    }
    String getColor(){
        return color;
    }
    void setColor(String color){
        this.color = color;
    }
}
