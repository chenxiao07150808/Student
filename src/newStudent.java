
public class newStudent {
 String name;
 String id;
 String crid;
 String grade;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCrid() {
	return crid;
}
public void setCrid(String crid) {
	this.crid = crid;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
newStudent(String crid,String grade,String id){
	this.crid=crid;
	this.grade=grade;
	this.id=id;
}

}