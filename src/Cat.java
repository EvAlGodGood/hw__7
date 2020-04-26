public class Cat {
    String name;
    int age;
    String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @AfterSuite
    public void outCat(){
        System.out.println(getName() + " убежал.");
    }

    @Test(priorety = 2)
    public void vote(){
        System.out.println(getName() + " Меау!!!");
    }

    @Test(priorety = 10)
    public void sprint(){
        System.out.println(getName() + " бежит...");
    }
    //@Test
    public String jamp(int height){
        return getName() + " прыгает " + height;
    }
    @BeforeSuite
    public void GetInfo(){
        System.out.println(name +" "+ age + " "+color);
    }

    @Test2
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }
//    @BeforeSuite
//    @Test
//    @Test
//    @Test
//    @AfterSuite
}