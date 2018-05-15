
package Ward;

public class Ward{
    private int id;
    private String name;
    private String location;
    private String building;
    private String floor;

    
    public Ward(int wid,String wname,String wlocation,String wbuilding,String wfloor){
        this.id=wid;
        this.name=wname;
        this.location=wlocation;
        this.building=wbuilding;
        this.floor=wfloor;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getBuilding(){
        return building;
    }
    public String getFloor(){
        return floor;
    }
}