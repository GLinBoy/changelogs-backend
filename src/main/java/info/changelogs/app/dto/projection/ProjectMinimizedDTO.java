package info.changelogs.app.dto.projection;

public interface ProjectMinimizedDTO {
	Long getId();
	String getName();
	String getTitle();
	String getOwner();
	
	void setId(Long id);
	void setName(String name);
	void setTitle(String title);
	void setOwner(String owner);
}
