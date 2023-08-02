package com.allianz.springlesson.database.entitiy;

import com.allianz.springlesson.util.dbutil.BaseEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // entity olduğunu belirtiyoruz. Önemli bir anotasyon
@Table(name = "person")// tabloyu isimlendirebiliyoruz bu noktada boşta bırakılabilir.
@AttributeOverride(name = "uuid", column = @Column(name = "person_uuid")) // basic sütun ismini overrite ediyoruz.
@Data // lombok anotasyonu getter setter oluşturuyor. @Getter @Setter
public class PersonEntity extends BaseEntity{
	@Column // bvuradaki fieldların sütun olduğunu belirtiyoruz. Önemli bir anotasyon bu. Aynı tablo gibi name verilebiliyor. Yazmasakta olur ama özellik eklemek için gerekli.
	// unique verilebiliyor. nullable verilebiliyor. length verilebiliyor. columnDefinition verilebiliyor. insertable verilebiliyor. updatable verilebiliyor. precision verilebiliyor. scale verilebiliyor. table verilebiliyor. colum
	private String name;
	@Column
	private String surname;
	@Column
	private int birthYear;
	@Column
	private String tc;
}
