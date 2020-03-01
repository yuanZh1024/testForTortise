public abstract class Person
{
    public abstract String getDescription();

    public String getName() {
        return name;
    }

    private String name;
    public Person(String name)
    {
        this.name = name;
    }
}