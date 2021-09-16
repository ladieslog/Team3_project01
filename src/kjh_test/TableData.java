package kjh_test;

public class TableData {
	String strNum;
	String strId;
	String strName;
	String strGroup;
	String strClass;
	
	//배열을 받아서 각각의 항목의 저장을 합니다.
	//그리고 출력때 사용 합니다.
	//만들때는 get / set 으로 만들면 됩니다.
	public TableData(String[] strArr) {
		
		this.strNum = strArr[0];
		this.strId = strArr[1];
		this.strName = strArr[2];
		this.strGroup = strArr[3];
		this.strClass = strArr[4];
	}
	public String getStrNum() {
		return strNum;
	}
	public void setStrNum(String strNum) {
		this.strNum = strNum;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrGroup() {
		return strGroup;
	}
	public void setStrGroup(String strGroup) {
		this.strGroup = strGroup;
	}
	public String getStrClass() {
		return strClass;
	}
	public void setStrClass(String strClass) {
		this.strClass = strClass;
	}
	
	
	
}