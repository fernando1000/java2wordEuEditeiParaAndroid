package word.w2004.elements;

import word.api.interfaces.IElement;
import word.w2004.elements.tableElements.TableRow;

/**
 * @author leonardo_correa
 * 
 */
public class TableV2 implements IElement {

    private StringBuilder txt = new StringBuilder("");
    private boolean hasBeenCalledBefore = false;
    
    public String getContent() {
        if (hasBeenCalledBefore) {
            return txt.toString();
        } else {
            hasBeenCalledBefore = true;
        }
        
        if ("".equals(txt.toString())) {
            return "";
        }
        // here it goes
        txt.insert(0, tableTop);
        txt.append("\n" + tableBottom);
        
        //apply style

        return txt.toString();
    }

    /**
     * You always have to use TableRow to add new rows to the table. Eg.:
     * <code>
     * tbl.addRow( TableRowV2.with("Simple String cell") ); 
     * </code>
     * See documentation on method "TableRowV2.with" for very detailed information.
     *  
     * @param row
     * @return
     */
    public TableRow addRow(TableRow row) {
        //the row will have cells. The Row knows how to do the rest...
        txt.append(row.getContent());
        return row;
    }

	String tableTop = 
			 "\n	<w:tbl> "
			+"\n            <w:tblPr> "
			+"\n                <w:tblW w:w=\"0\" w:type=\"auto\"/> "
			+"\n                <w:tblBorders> "
			+"\n                    <w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			+"\n                    <w:left w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			+"\n                    <w:bottom w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			+"\n                    <w:right w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			+"\n                    <w:insideH w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			+"\n                    <w:insideV w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			+"\n                </w:tblBorders> "
			+"\n                <w:tblLook w:val=\"00BF\"/> "
			+"\n            </w:tblPr> "
			+"\n            <w:tblGrid> "
			+"\n                <w:gridCol w:w=\"4258\"/> "
			+"\n                <w:gridCol w:w=\"4258\"/> "
			+"\n            </w:tblGrid> "
			;
	
    private String tableBottom = "\n	</w:tbl>";
    
    

}
