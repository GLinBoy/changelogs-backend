package info.changelogs.app.entity;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ProjectMeta extends MetaData {

}
