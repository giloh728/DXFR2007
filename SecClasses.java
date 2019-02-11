//package www
//AutoCAD Section -- Classes
import java.util.*;

/**
*@author David Wu<809758521@qq.com>
*@version 0.5
*/
public class SecClasses {

    /**
     * code  0 -Entity section header.
     */
    public String SectionHeader = "SECTION";

    /**
     * code  0 -Entity section name.
     */
    public String SectionName = "CLASSES";

    /**
     * code  0 -Entity section END.
     */
    public String SectionTail = "ENDSEC";


    /**
     * Constructor (empty).
     */
    public SecClasses() {

    }


    /**
     * Constructor (one_classes_section)
     * @param one_classes_section -one object derived from class SecClasses;
     */
    public SecClasses(SecClasses one_classes_section) {
        /*
        this.start_point = one_classes_section.start_point;
        this.end_point = one_classes_section.end_point;

        this.thickness = one_classes_section.thickness;
        this.xExtrusionDirection = one_classes_section.xExtrusionDirection;
        this.yExtrusionDirection = one_classes_section.yExtrusionDirection;
        this.zExtrusionDirection = one_classes_section.zExtrusionDirection;
        */
    }

    /**
     * printAll()
     * <pre>Terminal output the description of start_point and end_point.(serveral lines)
     * Output example:
     * </pre>
     */
    public void printAll() {
        List<String []>  myMap = this.getPairData();
        System.out.println("Entity List's Size: "+myMap.size());
		for (String [] key : myMap) {
            System.out.println("key= "+ key[0] + "\t\t\tvalue= " + key[1]);
        }
        System.out.println();

        /*
        System.out.println("SectionHeader: " + this.SectionHeader);
        System.out.println("SectionName: " + this.SectionName);

        System.out.println("SectionTail: " + this.SectionTail);
        */
    }

    /**
     * getPairData()
     * @return Map of elements description of Entity LINE.
     * <pre>Output example:
     * </pre>
     */
    public List<String []> getPairData() {
        List<String []> params=new ArrayList<>();

        for (int i=0; i< StdSectionStr_R2K.length; i= i + 2) {
            params.add(new String[] {StdSectionStr_R2K[i],StdSectionStr_R2K[i+1]});
        }
        /*
        params.add(new String[] {"  0",this.SectionHeader});
        params.add(new String[] {"  2",this.SectionName});
        params.add(new String[] {"  0",this.SectionTail});
        */
        return params;
    }

    /**
     * getDXF()
     * @return the dxf data of entity line.
     * <pre>Output example:
     * </pre>
     */
    public List<String> getDXF() {

        List<String> DXF_STR = new ArrayList<>();
        /*
        DXF_STR.add("  0");
        DXF_STR.add(this.SectionHeader);
        DXF_STR.add("  2");
        DXF_STR.add(this.SectionName);

        DXF_STR.add("  0");
        DXF_STR.add(this.SectionTail);
        */

        for (int i=0; i< StdSectionStr_R2K.length; i++) {
            DXF_STR.add(StdSectionStr_R2K[i]);
        }

        return DXF_STR;
    }

    public String toString() {
        /* require the jar file --- common-lang3
        List<String> DXF_STR = new ArrayList<>();
        String returnString = new String();

        DXF_STR = this.getDXF();
        returnString = String.join(",",DXF_STR);
        */

        List<String> DXF_STR = new ArrayList<>();
        String returnString = new String();

        DXF_STR = this.getDXF();

        if (null != DXF_STR && DXF_STR.size() > 0) {
            String[] mListArray = DXF_STR.toArray(new String[DXF_STR.size()]);
            for (int i = 0; i < mListArray.length; i++) {
                if (i < mListArray.length - 1) {
                    returnString += mListArray[i] + "\r\n";
                } else {
                    returnString += mListArray[i];
                }
            }
        }

        return returnString;
    }

    public String[] StdSectionStr_R2K = {
		"  0",
		"SECTION",
		"  2",
		"CLASSES",
		"  0",
		"CLASS",
		"  1",
		"ACDBDICTIONARYWDFLT",
		"  2",
		"AcDbDictionaryWithDefault",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"        0",
		" 91",
		"        1",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"MATERIAL",
		"  2",
		"AcDbMaterial",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        3",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"VISUALSTYLE",
		"  2",
		"AcDbVisualStyle",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     4095",
		" 91",
		"       16",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"TABLESTYLE",
		"  2",
		"AcDbTableStyle",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     4095",
		" 91",
		"        2",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"SCALE",
		"  2",
		"AcDbScale",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       33",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"MLEADERSTYLE",
		"  2",
		"AcDbMLeaderStyle",
		"  3",
		"ACDB_MLEADERSTYLE_CLASS",
		" 90",
		"     4095",
		" 91",
		"        1",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"SORTENTSTABLE",
		"  2",
		"AcDbSortentsTable",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"        0",
		" 91",
		"       47",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"MULTILEADER",
		"  2",
		"AcDbMLeader",
		"  3",
		"ACDB_MLEADER_CLASS",
		" 90",
		"     1025",
		" 91",
		"        8",
		"280",
		"     0",
		"281",
		"     1",
		"  0",
		"CLASS",
		"  1",
		"ACAD_TABLE",
		"  2",
		"AcDbTable",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1025",
		" 91",
		"        2",
		"280",
		"     0",
		"281",
		"     1",
		"  0",
		"CLASS",
		"  1",
		"ACDB_BLKREFOBJECTCONTEXTDATA_CLASS",
		"  2",
		"AcDbBlkRefObjectContextData",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       34",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"ACAD_EVALUATION_GRAPH",
		"  2",
		"AcDbEvalGraph",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       22",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKLINEARPARAMETER",
		"  2",
		"AcDbBlockLinearParameter",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       41",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKLINEARGRIP",
		"  2",
		"AcDbBlockLinearGrip",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       34",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKGRIPLOCATIONCOMPONENT",
		"  2",
		"AcDbBlockGripExpr",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"      171",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKLOOKUPPARAMETER",
		"  2",
		"AcDbBlockLookupParameter",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       13",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKLOOKUPGRIP",
		"  2",
		"AcDbBlockLookupGrip",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       12",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKMOVEACTION",
		"  2",
		"AcDbBlockMoveAction",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       28",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKSTRETCHACTION",
		"  2",
		"AcDbBlockStretchAction",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       46",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKLOOKUPACTION",
		"  2",
		"AcDbBlockLookupAction",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        7",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"ACDB_DYNAMICBLOCKPURGEPREVENTER_VERSION",
		"  2",
		"AcDbDynamicBlockPurgePreventer",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       22",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"ACDB_BLOCKREPRESENTATION_DATA",
		"  2",
		"AcDbBlockRepresentationData",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       95",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKVISIBILITYPARAMETER",
		"  2",
		"AcDbBlockVisibilityParameter",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       15",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKVISIBILITYGRIP",
		"  2",
		"AcDbBlockVisibilityGrip",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       13",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKROTATIONPARAMETER",
		"  2",
		"AcDbBlockRotationParameter",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        6",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKROTATIONGRIP",
		"  2",
		"AcDbBlockRotationGrip",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        6",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKFLIPPARAMETER",
		"  2",
		"AcDbBlockFlipParameter",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        7",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKFLIPGRIP",
		"  2",
		"AcDbBlockFlipGrip",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        7",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKROTATEACTION",
		"  2",
		"AcDbBlockRotateAction",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        6",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKFLIPACTION",
		"  2",
		"AcDbBlockFlipAction",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        7",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"ACDB_MTEXTATTRIBUTEOBJECTCONTEXTDATA_CLASS",
		"  2",
		"AcDbMTextAttributeObjectContextData",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"       96",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKALIGNMENTPARAMETER",
		"  2",
		"AcDbBlockAlignmentParameter",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        4",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKALIGNMENTGRIP",
		"  2",
		"AcDbBlockAlignmentGrip",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        4",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKSCALEACTION",
		"  2",
		"AcDbBlockScaleAction",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        6",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKBASEPOINTPARAMETER",
		"  2",
		"AcDbBlockBasepointParameter",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        4",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKARRAYACTION",
		"  2",
		"AcDbBlockArrayAction",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        1",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKPOINTPARAMETER",
		"  2",
		"AcDbBlockPointParameter",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        7",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"BLOCKXYGRIP",
		"  2",
		"AcDbBlockXYGrip",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1153",
		" 91",
		"        6",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"CELLSTYLEMAP",
		"  2",
		"AcDbCellStyleMap",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"     1152",
		" 91",
		"        5",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"CLASS",
		"  1",
		"DICTIONARYVAR",
		"  2",
		"AcDbDictionaryVar",
		"  3",
		"ObjectDBX Classes",
		" 90",
		"        0",
		" 91",
		"       15",
		"280",
		"     0",
		"281",
		"     0",
		"  0",
		"ENDSEC"
    };
}

