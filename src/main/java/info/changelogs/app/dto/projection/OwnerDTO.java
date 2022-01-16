package info.changelogs.app.dto.projection;

public interface OwnerDTO {
	Long getId();
	String getName();
	String getTitle();
	
	void setId(Long id);
	void setName(String name);
	void setTitle(String title);
}
