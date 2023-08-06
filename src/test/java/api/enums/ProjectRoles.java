package api.enums;

public enum ProjectRoles {
    MANAGER("project-manager"),
    MEMBER("project-member"),
    VIEWER("project-viewer");

    private String projectRole;

    ProjectRoles(String projectRole) {
        this.projectRole = projectRole;
    }

    public String getProjectRole() {
        return projectRole;
    }

}
