//package www
//AutoCAD Entity -- Polyline
import java.util.*;

/**
*@author <a href="mailto:809758521@qq.com"> David Wu</a>
*@version 0.6
*/
public class EntPolyline extends EntBase {
    /**
     * code  0 -Entity name.
     */
    public String EntityName = "POLYLINE";

    /**
     * code  5 - Handle.
     */
    public String Handle;

    /**
     * code  5 - endHandle.
     */
    public String endHandle;

    /**
     * code  330 - Object ID.
     */
    public String ObjectId = "1F";

    /**
     * code  100 -Class Label.
     */
    public String ClassLabel = "AcDbEntity";

    /**
     * code  100 -Sub Class Label.
	 * AcDb2dPolyline or AcDb3dPolyline
     */
    public String SubClassLabel = "AcDb3dPolyline";

    /**
     * code  10,20,30
     *            A "dummy" point. The X and Y coordinates are always 0,
     *            and the Z coordinate is the polyline's elevation (in OCS
     *            when 2D, WCS when 3D).
     */
    public  wPoint     DummyPoint;

    /**
     * code  10,20,30 -Start Point location (in WCS).
     * code  11,22,31 -End Point location (in WCS).
     */
    public List<EntVertex> vertexs;

    /**
    * code  39 - Thickness (optional; default  =  0).
    */
    public double thickness = 0.0;

    /**
     * code  40 - Starting width (optional; default is 0).
     */
    public    double                      begwidth        = 0.0;
    /**
     *            Starting width coded - true if code 40 is not just default.
     */
    public    boolean                     begwidth_set    = false;
    /**
     * code  41 - Ending width (optional; default is 0).
     */
    public    double                      endwidth        = 0.0;
    /**
     *            Ending width coded - true if code 41 is not just default.
     */
    public    boolean                     endwidth_set    = false;

    /**
     * code  66 - Vertices-follow flag (always 1 for a polyline).
     */
    public    int                         vtxFollow       = 1;

    /**
     * code  70 - Polyline flag (bit-coded); default is 0.
     * <UL>
     *   <LI>  1 = This is a closed polyline (or a polygon mesh closed in
     *             the M directtion).
     *   <LI>  2 = Curve-fit vertices have been added.
     *   <LI>  4 = Spline-fit vertices have been added.
     *   <LI>  8 = This is a 3D polyline.
     *   <LI> 16 = This is a 3D polygon mesh.
     *   <LI> 32 = The polygon mesh is closed in the N direction.
     *   <LI> 64 = The polyline is a polyface mesh.
     *   <LI>128 = The linetype pattern is generated continuously
     *             around the vertices of this polyline.
     * </UL>
     */
    public    int                         TypeFlag           = 8;

    /**
     * code  71 - Polygon mesh M vertex count (optional; default = 0).
     */
    public    int                         meshcntM        = 0;
    /**
     * code  72 - Polygon mesh N vertex count (optional; default = 0).
     */
    public    int                         meshcntN        = 0;

    /**
     * code  73 - Smooth surface M density (optional; default = 0).
     */
    public    int                         smoothM         = 0;
	
    /**
     * code  74 - Smooth surface N density (optional; default = 0).
     */
    public    int                         smoothN         = 0;

    /**
     * code  75 - Curves and smooth surface type (optional; default = 0).
     * <UL>
     *   <LI>0 = No smooth surface fitted.
     *   <LI>5 = Quadratic B-spline surface.
     *   <LI>6 = Cubic B-spline surface.
     *   <LI>8 = Bezier surface.
     * </UL>
     */
    public    int                         surfType        = 0;

    /**
     * code 210,220,230 -
     *            Extrusion direction. Present if the extrusion direction is
     *            not parallel to the world Z axis.
     */
    public double   xExtrusionDirection = 0;
    public double   yExtrusionDirection = 0;
    public double   zExtrusionDirection = 1;

    /**
     * Constructor (empty).
     */
    public EntPolyline() {
		this.Handle = FileDXF.ApplyHandle();
        this.vertexs = new ArrayList<>();
    }

    /**
     * Constructor (x_value,y_value)
     * @param x_value -x of start vertex;
     * @param y_value -y of start vertex;
     */
    public EntPolyline(double[] x_value,double[] y_value) {
		this.Handle = FileDXF.ApplyHandle();
        this.vertexs = new ArrayList<>();

        for (int i=0;i < x_value.length;i++){
			this.AddVertex(new wPoint(x_value[i],y_value[i]));
		}
    }

    /**
     * Constructor (x_value,y_value,z_value)
     * @param x_value -x of start vertex;
     * @param y_value -y of start vertex;
     * @param z_value -z of start vertex;
     */
    public EntPolyline(double[] x_value,double[] y_value,double[] z_value) {
		this.Handle = FileDXF.ApplyHandle();
        this.vertexs = new ArrayList<>();
        for (int i=0;i < x_value.length;i++){
			this.AddVertex(new wPoint(x_value[i],y_value[i],z_value[i]));
		}
        //this.AddVertex(new EntVertex(x_value,y_value,z_value));
    }

    /**
     * Constructor (points)
     * @param points - two dimensions array of double, x - points[i][0], y - points[i][1];
     */
    public EntPolyline(double[][] points) {
		this.Handle = FileDXF.ApplyHandle();
        this.vertexs = new ArrayList<>();

        for (int i=0; i < points.length; i++) {
            if (points[i].length == 2) {
                this.AddVertex(new wPoint(points[i][0],points[i][1]));
            } else if (points[i].length == 3) {
                this.AddVertex(new wPoint(points[i][0],points[i][1],points[i][2]));
            }
        }
    }

    /**
     * AddVertex(point)
     * @param point -one vertex to add class EntPolyline;
     */
    public void AddVertex(wPoint2D point) {
		this.AddVertex(new wPoint(point));
    }

    /**
     * AddVertex(point)
     * @param point -one vertex to add class EntPolyline;
     */
    public void AddVertex(wPoint point) {
		EntVertex myVertex;
		
		myVertex = new EntVertex(point);
		myVertex.ObjectId = this.Handle;
		myVertex.SubClassLabel2 = "AcDb3dPolylineVertex";
		myVertex.flags = 32;
		
        this.vertexs.add(myVertex);
    }

    /**
     * AddVertex(one_vertex)
     * @param one_vertex -one vertex to add class EntPolyline;
     */
    //Abandon this method to avoid the vertex's ObjectId is null
	//public void AddVertex(EntVertex one_vertex) {
    //    this.vertexs.add(new EntVertex(one_vertex,this.Handle));
    //}

    /**
     * Constructor (one_polyline)
     * @param one_polyline -one object derived from class EntPolyline;
     */
    public EntPolyline(EntPolyline one_polyline) {
        this.EntityName = one_polyline.EntityName;
        this.ClassLabel = one_polyline.ClassLabel;
        this.SubClassLabel = one_polyline.SubClassLabel;

        this.DummyPoint = new wPoint(one_polyline.DummyPoint);

        this.vertexs = new ArrayList<>();
        //this works ok.
        //this.vertexs.addAll(one_polyline.vertexs);
        for(int i=0; i<one_polyline.vertexs.size(); i++) {
            this.vertexs.add(one_polyline.vertexs.get(i));
        }

        this.thickness = one_polyline.thickness;
        this.begwidth = one_polyline.begwidth;
        this.begwidth_set = one_polyline.begwidth_set;
        this.endwidth = one_polyline.endwidth;
        this.endwidth_set = one_polyline.endwidth_set;
        this.vtxFollow = one_polyline.vtxFollow;
        this.TypeFlag = one_polyline.TypeFlag;
        this.meshcntM = one_polyline.meshcntM;
        this.meshcntN = one_polyline.meshcntN;
        this.smoothM = one_polyline.smoothM;
        this.smoothN = one_polyline.smoothN;
        this.surfType = one_polyline.surfType;
        this.xExtrusionDirection = one_polyline.xExtrusionDirection;
        this.yExtrusionDirection = one_polyline.yExtrusionDirection;
        this.zExtrusionDirection = one_polyline.zExtrusionDirection;
		
		this.Handle = FileDXF.ApplyHandle();
    }

    /**
    * GetSize()
    * Get the number of the vertexs of the polyline;
    */
    public int GetSize() {
        return this.vertexs.size();
    }

    /**
    * GetLength()
    * Get the total length of the polyline;
    */
    public double GetLength() {
        double Length = 0.0;

        for (int i = 1; i < this.vertexs.size(); i++) {
            //Length = Math.pow(vertexs.get(i).bPoint.x-vertexs.get(i-1).bPoint.x);
            //Length = Math.sqrt(Math.pow(vertexs.get(i).bPoint.x-vertexs.get(i-1).bPoint.x));
            double dx,dy,dz;

            dx = this.vertexs.get(i).bPoint.x - this.vertexs.get(i-1).bPoint.x;
            dy = this.vertexs.get(i).bPoint.y - this.vertexs.get(i-1).bPoint.y;
            dz = this.vertexs.get(i).bPoint.z - this.vertexs.get(i-1).bPoint.z;

            Length = Length + Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2) + Math.pow(dz,2) );
        }
        return Length;
    }

    /**
      * Print2D()
      * Terminal output x,y of start_point and end_point.(one line for one point)
      */
    public void Print2D() {
        //System.out.println("Start point:  "+"x = "+start_point.x+"   y = "+start_point.y);
        //System.out.println("End point:  "+"x = "+end_point.x+"   y = "+end_point.y);
    }

    /**
     * Print3D()
     * Terminal output x,y,z of start_point and end_point.(one line for one point)
     */
    public void Print3D() {
        //System.out.println("Start point:  "+"x = "+start_point.x+"   y = "+start_point.y+"   z = "+start_point.z);
        //System.out.println("End point:  "+"x = "+end_point.x+"   y = "+end_point.y+"   z = "+end_point.z);
    }


    /**
     * GetMapData()
     * @return Map of elements description of Entity LINE.
     * <pre>Output example:
     * Map's Size: 10
     * key= Entity                     value= LINE
     * key= zExtrusionDirection                        value= 1.0
     * key= ClassLabel                 value= AcDbEntity
     * key= xExtrusionDirection                        value= 0.0
     * key= SubClassLabel                      value= AcDbLine
     * key= thickness                  value= 0.0
     * key= yExtrusionDirection                        value= 0.0
     * key= x                  value= 50.2314
     * key= y                  value= 30.12546
     * key= z                  value= 80.01234567890124</pre>
     */
    public List<String []> GetPairData() {
        List<String []> params=new ArrayList<>();

        params.add(new String[] {"Entity",this.EntityName});

        params.addAll(super.GetPairData());

        params.add(new String[] {"ClassLabel",this.ClassLabel});
        params.add(new String[] {"SubClassLabel",this.SubClassLabel});
        params.add(new String[] {"  8",super.layer});

        params.add(new String[] {"  66",Integer.toString(this.vtxFollow)});
        params.add(new String[] {"  70",Integer.toString(this.TypeFlag)});

        for (int i  =  0; i < this.vertexs.size(); i++) {
            params.addAll(this.vertexs.get(i).GetPairData());
        }
        params.add(new String[] {"  0","SEQEND"});

        return params;
    }

    /**
     * GetDXFData()
     * @return the dxf data of entity line.
     * <pre>Output example:
     * 0
     * LINE
     * 100
     * AcDbEntity
     * 8
     * 0
     * 100
     * AcDbLine
     * 10
     * 10.0
     * 20
     * 10.0
     * 30
     * 10.0
     * 11
     * 50.2314
     * 21
     * 30.12546
     * 31
     * 80.01234567890124
     * 39
     * 0.0
     * 210
     * 0.0
     * 220
     * 0.0
     * 230
     * 1.0</pre>
     */
    public List<String> GetDXFData() {

        List<String> DXF_STR = new ArrayList<>();
		this.endHandle = FileDXF.ApplyHandle();
		
        DXF_STR.add("  0");
        DXF_STR.add(this.EntityName);

        DXF_STR.add("  5");
        DXF_STR.add(this.Handle);

        DXF_STR.add("330");
        DXF_STR.add("1F");

        DXF_STR.add("100");
        DXF_STR.add(this.ClassLabel);

        DXF_STR.addAll(super.GetDXFData());

        DXF_STR.add("100");
        DXF_STR.add(this.SubClassLabel);

        DXF_STR.add("  66");
        DXF_STR.add(Integer.toString(this.vtxFollow));
		
        DXF_STR.add("  10");
        DXF_STR.add("0.0");
		
        DXF_STR.add("  20");
        DXF_STR.add("0.0");
		
        DXF_STR.add("  30");
        DXF_STR.add("0.0");
		
        DXF_STR.add("  70");
        DXF_STR.add(Integer.toString(this.TypeFlag));

        for (int i  =  0; i < this.vertexs.size(); i++) {
            DXF_STR.addAll(this.vertexs.get(i).GetDXFData());
        }

        DXF_STR.add("  0");
        DXF_STR.add("SEQEND");

        DXF_STR.add("  5");
        DXF_STR.add(this.endHandle);

        DXF_STR.add("330");
        DXF_STR.add(this.Handle);

        DXF_STR.add("100");
        DXF_STR.add(this.ClassLabel);

        DXF_STR.addAll(super.GetDXFData());

        return DXF_STR;
    }

}