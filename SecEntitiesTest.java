//package www
//AutoCAD Section--ENTITIES
import java.util.*;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class SecEntitiesTest {


    public static void  main(String[] args)  throws Exception {
        SecEntities mySecEntities = new SecEntities();

        //mySecEntities.entities = new  ArrayList<Object>();

        EntPolyline myPolyline = new EntPolyline();

        myPolyline.addVertex(new wPoint(90,0));
        myPolyline.addVertex(new wPoint(80,40));
        myPolyline.addVertex(new wPoint(120,80));
        myPolyline.addVertex(new wPoint(150,100));
        myPolyline.addVertex(new wPoint(180,120));
        myPolyline.addVertex(new wPoint(200,80));

        mySecEntities.entities.add(new wPoint(2,2));
        mySecEntities.entities.add(new EntLine(-100,8,0,250,150,0));
        mySecEntities.entities.add(new EntLine(-250,-200,-250,200));
        mySecEntities.entities.add(new EntPoint(10,10,12));
        mySecEntities.entities.add(myPolyline);
        mySecEntities.entities.add(new EntCircle(180,-25,250));
        mySecEntities.entities.add(new EntArc(10,10,180,0,180));
        //mySecEntities.entities.add(new EntEllipse(0,0,0,100,0,0,0.6,0.0,2*Math.PI));
        mySecEntities.entities.add(new EntText(0,0,0,8,"This is mine.���Ĳ���\r\nApache Flink 1.7.0 Release Announcement\nMessage from David Wu\nState schema evolution now works out-of-the-box\rthe integration of complex event processing with streaming SQL "));

        mySecEntities.entities.add(new EntRay(180,-25,250,400));
        mySecEntities.entities.add(new EntXline(100,60,0,300,360,50));
		

        System.out.println("Test toString: ");
        System.out.println(mySecEntities);
        System.out.println();

        System.out.println("List's Size " + mySecEntities.entities.size());


        for (int i = 0; i<mySecEntities.entities.size(); i++) {
            System.out.println(mySecEntities.entities.get(i));
        }
        System.out.println();

        List<String []>  myMap = mySecEntities.getPairData();
        System.out.println("PairData's Size: "+myMap.size());
		for (String [] key : myMap) {
            System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
        }
        System.out.println();


        System.out.println("");
        System.out.println("DXF file's DATA is here:");

        List<String> dxf_str = mySecEntities.getDXF();
        for (int i  =  0; i < dxf_str.size(); i++) {
            System.out.println(dxf_str.get(i));
        }

        mySecEntities.printAll();
    }

}

