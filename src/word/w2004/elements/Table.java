package word.w2004.elements;

import word.api.interfaces.IElement;
import word.w2004.elements.tableElements.ITableItemStrategy;
import word.w2004.elements.tableElements.TableEle;
import word.w2004.elements.tableElements.TableFactoryMethod;

public class Table implements IElement {
	
    StringBuilder txt = new StringBuilder("");
    private boolean hasBeenCalledBefore = false; 
    private boolean isRepeatTableHeaderOnEveryPage = false;
    private boolean comBorda;
    
	public Table(boolean comBorda) {
		this.comBorda = comBorda;
	}
    
    public String getContent() {
        if ("".equals(txt.toString())) {
            return "";
        }
        if (hasBeenCalledBefore) {
            return txt.toString();
        } else {
            hasBeenCalledBefore = true;
        }

        ITableItemStrategy tableDef = TableFactoryMethod.getInstance()
                .getTableItem(TableEle.TABLE_DEF);

        txt.insert(0, tableDef.getTop(comBorda));
        txt.append("\n" + tableDef.getBottom());

        return txt.toString();
    }
 
    public void addTableEle(TableEle tableEle, Paragraph... cols) {
        if(cols != null && cols.length > 0){
            StringBuilder th = new StringBuilder("");
            ITableItemStrategy item = TableFactoryMethod.getInstance().getTableItem(tableEle);

            processMiddleForParagraph(th, item, cols);
            
            joinTopMiddleBottom(th, item);
        }    
    }
 
    public void addTableEle(TableEle tableEle, String... cols) {
        if (cols != null && cols.length > 0) {
            StringBuilder th = new StringBuilder("");
            ITableItemStrategy item = TableFactoryMethod.getInstance().getTableItem(tableEle);

            for (int i = 0; i < cols.length; i++) {
                //if(!"".equals(cols[i])){
                th.append("\n" + item.getMiddle().replace("{value}", cols[i]));
                //}
            }

            joinTopMiddleBottom(th, item);
        }
    }
 
    private String setUpRepeatTableHeaderOnEveryPage(StringBuilder th) {
        String res = th.toString();
        if (this.isRepeatTableHeaderOnEveryPage) {
            res = res.replace("{tblHeader}",
                    "  \n<w:trPr>\n        <w:tblHeader/>\n    </w:trPr>\n ");
        }

        // clean up placeholder
        res = res.replace("{tblHeader}", "");
        return res;
    }

    public void setRepeatTableHeaderOnEveryPage() {
        this.isRepeatTableHeaderOnEveryPage = true;
    }
 
	private void processMiddleForParagraph(StringBuilder th,
			ITableItemStrategy item, Paragraph... cols) {
		String templateWithoutParagraph =
		        "                <w:tc> "
		        +"\n                    <w:tcPr> "
		                    +"\n                        <w:tcW w:w=\"4258\" w:type=\"dxa\"/> "
		        +"\n                    </w:tcPr> "
		        +"\n                    {value} "
		        +"\n                </w:tc> "               
		        ;
		for (int i = 0; i < cols.length; i++) {         
		    if(cols[i] != null && cols[i].getContent() != ""){ 
		        th.append("\n" + templateWithoutParagraph.replace("{value}", cols[i].getContent()));
		    } else {
		    	//th.append("\n" + this.getMyMiddle().replace("{value}", ""));
		        th.append("\n" + item.getMiddle().replace("{value}", Paragraph.with("").create().getContent() )); 
		    }
		}
	}
	
	private void joinTopMiddleBottom(StringBuilder th, ITableItemStrategy item) {
		if(!"".equals(th.toString())){
		    th.insert(0, item.getTop(comBorda));
		    th.append(item.getBottom());
		}
		
		String finalResult = setUpRepeatTableHeaderOnEveryPage(th);
		txt.append(finalResult);//final result appended
	}
    
}
