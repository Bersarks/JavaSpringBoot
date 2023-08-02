package com.allianz.springlesson.util.dbutil;

// BaseEntity classı tüm entitylerin ortak özelliklerini tutmak için oluşturuldu.
// Bu classı extend eden classlar bu classın özelliklerini kullanabilir.

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass // inheritance yapılacaksa mutlaka kullanılmalı. Bu classı extend eden classlar bu classın özelliklerini kullanabilir.
@Data
@EntityListeners({AuditingEntityListener.class}) // bir obje oluşturduğumuzda bu objenin oluşturulma zamanını tutuyor ve veritabanına kaydediyor.
//onChange gibi veritabanındaki her bir değişiklikte çalışan bir listener.
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Bir nevi primary Key olduğunu tanımlıyoruz otomatik artırıyor.
	private Long id;

	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2") //UUID oluşturuyor.
	@JdbcTypeCode(java.sql.Types.VARCHAR)//Db deki sütunun tipini belirtiyoruz.
	private UUID uuid;

	@CreatedDate
	private Date createdDate;

	@LastModifiedDate
	private Date updatedDate;

	@PrePersist // Kayıttan önce çalışan bir listener. Bu listener sayesinde kayıt oluşturulmadan önce çalışan bir method yazabiliriz.
	protected void onCreate() {
		setUuid(UUID.randomUUID());
	}

}
