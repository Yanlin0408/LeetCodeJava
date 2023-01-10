class Dog{
    public String name;
    public int age;

    public Dog(String mingzi, int nianling){
        this.name = mingzi;
        this.age = nianling;
    }

    public void spark(){
        System.out.println("主人  "+this.age+"  "+this.name);
    }

}