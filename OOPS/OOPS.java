

public class OOPS {

    // Interfaces # multiple inheritance.
    public static void main(String[] args) {
        // Horse h = new Horse();
        // h.eats();
        // h.produceMilk();

        Herbivore h = new Bear(); 

        Bear b = new Bear();
        b.eatsGrass();
        b.eatsMeat();
        
    }

    
}

interface Animal{
    void eats();
}

interface Mammal{
    void produceMilk();
}


class Horse implements Animal, Mammal{
    public void eats(){
        System.out.println("Horse is working hard!");
    }

    public void produceMilk(){
        System.out.println("Horses are mammals and produce milk to feed their babies!");
    }
}


interface Herbivore{
    void eatsGrass();

}

interface Carnivore{
    void eatsMeat();
}


class Bear implements Carnivore, Herbivore{

    public void eatsGrass(){
        System.out.println("Eats veggies!");

    }

    public void eatsMeat(){
        System.out.println("Eats meat as well!");
    }
}
