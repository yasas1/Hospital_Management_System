
package Test;

public class Test {
    private int id;
    private String description;
    private int price;
    private String conditions;


    
    public Test(int tid,String tdescription,int tprice,String tconditions){
        this.id=tid;
        this.description=tdescription;
        this.price=tprice;
        this.conditions=tconditions;
        
    }
    public int getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }
    public int getPrice(){
        return price;
    }
    public String getConditions(){
        return conditions;
    }
    
}
