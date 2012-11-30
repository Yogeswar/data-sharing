// sets the values to variables
package store;
import java.io.Serializable;
public class storage implements Serializable{
	 String ip;
	private String id;
	String role;
	private String mode;
	private String group;
	
public void setip(String ip){
	this.ip=ip;
	String id1 = getid(this.ip);
}

public String getip()
{
	return this.ip;
}

public String getid(String ip){
	this.id = ip.substring(10);
	return this.id;
}

public void setrole(String role){
	
	this.role=role;
		
}
/*public void setmode(String mode){
	this.mode=mode;
}*/
public void setgroup(String group){
	this.group=group;
}


public String toString(){
	return  this.ip;
}

public String getIp() {
	return ip;

}


public void setIp(String ip) {
	this.ip = ip;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getMode() {
	return mode;
}

public void setMode(String mode) {
	this.mode = mode;
}

public String getGroup() {
	return group;
}

public void setGroup(String group) {
	this.group = group;
}


}

