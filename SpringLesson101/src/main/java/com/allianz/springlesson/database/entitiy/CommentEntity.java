package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class CommentEntity extends BaseEntity {
}
