package com.allianz.springlesson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*!!!!!!!!!Dependency değiştiği zaman kesinlikle clean ve sonrasında install yapılması gerekiyor.!!!!!!!!!!!*/

/*API=Rest API --> REST - SOAP = RESTFUL service
* API Http protocol üzerinden çalışır birileri request atar api da response döner
* Örneğin: TC doğrulamada gelen verileri sistemde kontrol ederek response olarak true ya da false döner.
* Request ---> API
* API ---> Response
* restte nasıl request geleceğinin kuralları yazılır doğru bir request gelirse response döner
* request GET / POST / PUT / DELETE
* GET getirmeye veri çekme
* Post ekleme yeni kayıt // genelde urlde gözükmez urlde karakter sınırı var postta yok her şeyi postta gönderirsek bir sınırı yoktur.
* Put güncelleme
* Delete Silme
*
* Bu bütün get post put delete aynı url üzerinden yapılabiliyor sadece request tipi değişse yeterli.
*
*
* pdf yapmak için jasper diye bir repository var.* */


@SpringBootApplication
@EnableJpaAuditing // bazı şeyler için bunu aktif hale getirmemiz gerekiyor. Auditing Listenerı çalıştırmaya yarıyor.
public class SpringlessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringlessonApplication.class, args);
	}

}
