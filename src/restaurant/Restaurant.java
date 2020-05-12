package restaurant;

import java.io.InputStream;

/* * @author RENE */
//interface de comidas
interface FastFood{
    void prepareIngredients();
    void cook();
    void serve();
}
//crea hamburguesas
class Hamburger implements FastFood{

    @Override
    public void prepareIngredients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
//crea sandwich
class Sandwich implements FastFood{

    @Override
    public void prepareIngredients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
//crea hot dogs
class HotDog implements FastFood{

    @Override
    public void prepareIngredients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
//clase trae comidas
class FastFoodFactory {
    public FastFood getFastFood(String type){
        switch(type){
            case "hamburger": return new Hamburger();
            case "sandwich": return new Hamburger();
            case "hot dog": return new Hamburger();
            default: return null;
        }
    }   
}
//crea pizza
class Pizza implements FastFood{

    @Override
    public void prepareIngredients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void serve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
//interface bebidas
interface Drink{
    void pour();    
}
//crea jugo
class Juice implements Drink{

    @Override
    public void pour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//crea soda
class Soda implements Drink{

    @Override
    public void pour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
//crea cerveza
class Beer implements Drink{

    @Override
    public void pour() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

//crea restaurante tipo 1
class Restaurant1Factory extends RestaurantAbstractFactory{    

    public FastFood getFastFood(String type){
        switch(type){
            case "hamburger": return new Hamburger();
            case "sandwich": return new Sandwich();
            case "hot dog": return new HotDog();
            default: return null;
        }
    }
    
    public Drink getDrink(String type){
        switch(type){
            case "soda": return new Soda();                        
            default: return null;
        }
    }    
}
//crea restaurante tipo 2 
class Restaurant2Factory extends RestaurantAbstractFactory{    
    
    public FastFood getFastFood(String type){
        switch(type){
            case "pizza": return new Pizza();
            default: return null;
        }
    }
    
    public Drink getDrink(String type){
        switch(type){
            case "juice": return new Soda();
            case "beer": return new Beer();
            default: return null;
        }        
    }
}
//genera un restaurante
abstract class RestaurantAbstractFactory{
    abstract FastFood getFastFood(String type);
    abstract Drink getDrink(String type);   
}

class RestaurantFactoryProducer{
    public RestaurantAbstractFactory getRestaurantAbstractFactory(int numRestaurant){
        switch(numRestaurant){
            case 1: return new Restaurant1Factory();
            case 2: return new Restaurant2Factory();
            default: return null;
        }
    }
}
public class Restaurant{
    public void principal(InputStream in) throws Exception {
        //factory producer
        RestaurantFactoryProducer restaurantFactoryProducer = new RestaurantFactoryProducer();
        //como cliente usar solo RestaurantAbstractFactory , Drink y Food
        RestaurantAbstractFactory restaurantAbstractFactory1 = restaurantFactoryProducer.getRestaurantAbstractFactory(1);
        //bota null no debe aceptar beer
        System.out.println("PRUEBAS RESTAURANTE TIPO 1: ");
        Drink drinkUno = restaurantAbstractFactory1.getDrink("beer");   
        System.out.println(restaurantAbstractFactory1.getDrink("beer"));//no recibe beer    
        System.out.println(restaurantAbstractFactory1.getDrink("soda"));//recibe soda
        //comida restaurante tipo 1
        FastFood fastFoodt1 = restaurantAbstractFactory1.getFastFood("hot dog");
        System.out.println(restaurantAbstractFactory1.getFastFood("hot dog")); //recibe hot dog
        System.out.println("");
        System.out.println("PRUEBAS RESTAURANTE TIPO 2: ");
        //crea un restaurante tipo 2
        RestaurantAbstractFactory restaurantAbstractFactory2 = restaurantFactoryProducer.getRestaurantAbstractFactory(2);
        //envia el tipo beer
        Drink drinkDos = restaurantAbstractFactory2.getDrink("beer");
        System.out.println(restaurantAbstractFactory2.getDrink("beer"));
        //comida restaurante tipo 2
        System.out.println(restaurantAbstractFactory2.getFastFood("hot dog")); //no recibe hot dog
        FastFood fastFoodt2 = restaurantAbstractFactory2.getFastFood("pizza");
        System.out.println(restaurantAbstractFactory2.getFastFood("pizza"));//recibe pizza
    }
    public static void main(String[] args) throws Exception {
        new Restaurant().principal(System.in);
    }
}