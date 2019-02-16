package word.w2004.elements.tableElements;

public class TableDefinition implements ITableItemStrategy{

	public String getTop(boolean comBorda) {
		String top = 
			 "\n	<w:tbl> "
			+"\n            <w:tblPr> "
			+"\n                <w:tblW w:w=\"0\" w:type=\"auto\"/> " 
			+desenhaBorda(comBorda)+
			//+"\n                <w:tblBorders> "
			//+"\n                    <w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			//+"\n                    <w:left w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			//+"\n                    <w:bottom w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			//+"\n                    <w:right w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			//+"\n                    <w:insideH w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			//+"\n                    <w:insideV w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
			//+"\n                </w:tblBorders> "
			 "\n                <w:tblLook w:val=\"00BF\"/> "
			+"\n            </w:tblPr> "
			+"\n            <w:tblGrid> "
			+"\n                <w:gridCol w:w=\"4258\"/> "
			+"\n                <w:gridCol w:w=\"4258\"/> "
			+"\n            </w:tblGrid> "
			;
		return top;
	}
	
	private String desenhaBorda(boolean comBorda) {
	
		String borda = "";
		if(comBorda) {
		
			borda =  "\n                <w:tblBorders> "
					+"\n                    <w:top w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
					+"\n                    <w:left w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
					+"\n                    <w:bottom w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
					+"\n                    <w:right w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
					+"\n                    <w:insideH w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
					+"\n                    <w:insideV w:val=\"single\" w:sz=\"4\" wx:bdrwidth=\"10\" w:space=\"0\" w:color=\"000000\"/> "
					+"\n                </w:tblBorders> ";
		}
		return borda;
	}

	public String getMiddle() {
		return null; // N/A
	}


	public String getBottom() {
		return "\n	</w:tbl>";
	}
}
