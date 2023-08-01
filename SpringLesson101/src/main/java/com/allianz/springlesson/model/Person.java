package com.allianz.springlesson.model;

import lombok.Data; // lombok kütüphanesini ekledikten sonra bu satırı eklememiz gerekiyor. Get ve set yazmamıza gerek kalmıyor
import lombok.Getter;

@Data
//@Getter // asdece Getter oluşturuyor sadece setter için yine aynı şekilde @Setter. @NoArgsConstructor ise parametresiz constructor oluşturuyor.
public class Person {
	private String name;
	private String surname;
	private int BirthYear;
	private int tc;
}
