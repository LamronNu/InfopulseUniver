package lessons.patterns.builder;

interface Builder{

    public void buildFundament();

    public void buildWalls();

    public void buildRoof();

    public Building getBuilding();
}
interface Building{

}
class Cottage implements Building{

}
class CottadgeBuilder implements Builder{
    Cottage c;

    public CottadgeBuilder() {
        c = new Cottage();
    }

    public void buildFundament(){
        System.out.printf("buildFundament");
    }

    public void buildWalls(){
        System.out.printf("buildWalls");
    }

    public void buildRoof(){
        System.out.printf("buildRoof");
    }

    public Cottage getBuilding(){
        return c;
    }
}

class Director {
    Builder b;

    public Director(Builder b) {
        this.b = b;
    }
    public void create(){
        b.buildFundament();
        b.buildWalls();
        b.buildRoof();
    }
}

/**
 * Created by Univer_29 on 07.03.2015.
 */
public class BuilderTest {
    public static void main(String[] args) {
        Builder b = new CottadgeBuilder();
        Director d = new Director(b);
        d.create();
        Building c = b.getBuilding();
    }
}
