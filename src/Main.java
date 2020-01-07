import java.util.Scanner;

public class Main
{
    private String name;
    private double population;
    private double growthRate;
    private double populationAmount;

    Scanner keyboard = new Scanner(System.in);

    public void readInput()
    {
        System.out.println("enter name of the species:");
        name = keyboard.nextLine();
        System.out.println("enter population of the species: ");
        population = keyboard.nextDouble();
        System.out.println("enter growthRate of the population:");
        growthRate = keyboard.nextDouble();

    }
    public void writeOutput()
    {
        System.out.println("name: "+ name);
        System.out.println("population: "+ population);
        System.out.println("grwothRate: "+ growthRate);
    }
    public int predictPopulation(int years)
    {
        int result = 0;
        int count = years;
        populationAmount = population;
        while ((count >= 0) &&(populationAmount >= 0))
        {
            populationAmount = populationAmount + ((growthRate/100.0)*populationAmount);
            count--;
        }
        if(populationAmount > 0)
            result = (int)populationAmount;

        return result;

    }
    public void setSpecies(String newName, double newPopulation , double newGrowthRate)
    {
        name = newName;
        if((newPopulation <= 0) ||(newGrowthRate <= 0))
            System.out.println("Wrong parameter entered");
        else
        {
            population = newPopulation;
            growthRate = newGrowthRate;
        }
    }
    public String getName()
    {
        return name;
    }
    public double getPopulation()
    {
        return  population;
    }
    public double getGrowthRate()
    {
        return growthRate;
    }
    public boolean equals(Main object)
    {
        return name.equalsIgnoreCase(object.name)
                &&(population == object.population)
                &&(growthRate == object.growthRate);
    }

    public static void main(String[] args)
    {
        Main species1 = new Main(), species2 = new Main();
        species1.setSpecies("ox", 10,15);
        species2.setSpecies("ox", 10,15);
        testEqualOperator(species1, species2);
        textEqualsWithEquals(species1, species2);





    }
    public static void testEqualOperator(Main s1, Main s2)
    {
        if(s1 == s2)
        {
            System.out.println("match with ==");
        }
        else
            System.out.println("do not match with ==");
    }

    public static void textEqualsWithEquals(Main s1, Main s2)
    {
        if(s1.equals(s2))
            System.out.println("match with equals method");
        else
            System.out.println("do not match with equas");
    }

}
