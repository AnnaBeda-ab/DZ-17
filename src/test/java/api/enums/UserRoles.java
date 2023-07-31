package api.enums;

public enum UserRoles {
USER ("app_user"),
MANAGER ("app_manager"),
ADMIN ("app_admin");
private String role;
UserRoles(String role){this.role=role;}
public String getRole(){ return role;}

}
