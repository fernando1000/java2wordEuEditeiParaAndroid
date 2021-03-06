package word.w2004.elements.tableElements;

public class TableFooter implements ITableItemStrategy{
	
	public String getTop(boolean comBorda) {
		return "\n		<w:tr wsp:rsidR=\"00505659\" wsp:rsidRPr=\"00505659\">";
	}

	public String getMiddle() {
		String td =
			"                <w:tc> "
			+"\n                    <w:tcPr> "
			+"\n                        <w:tcW w:w=\"4258\" w:type=\"dxa\"/> "
			+"\n                    </w:tcPr> "
			+"\n                    <w:p wsp:rsidR=\"00505659\" wsp:rsidRPr=\"00505659\" wsp:rsidRDefault=\"00505659\"> "
			+"\n                        <w:r wsp:rsidRPr=\"00505659\"> "
            +"\n							<w:rPr> "
			+"\n								<w:b/> "
			+"\n							</w:rPr> " 
			+"\n                            <w:t>{value}</w:t> "
			+"\n                        </w:r> "
			+"\n                    </w:p> "
			+"\n                </w:tc> "				
			;
		return td;
	}
	
	public String getBottom() {
		return "\n		</w:tr>";
	}
	
}
