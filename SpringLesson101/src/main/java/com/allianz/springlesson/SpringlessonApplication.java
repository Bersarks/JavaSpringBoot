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
* Bu bütün get post put delete aynıu url üzerinden yapılabiliyor sadece request tipi değişse yeterli.
* */


/*Bugün API yazma günüüüüü GetMapping ile bu olayları tekrar edip işimize gücümüze bakalım :D
* Tiscordda bir araya gelip cayır cayır yapın :D bilmeyenlerde yönlendirmeye çalışsın*/
@SpringBootApplication
@EnableJpaAuditing // bazı şeyler için bunu aktif hale getirmemiz gerekiyor. Auditing Listenerı çalıştırmaya yarıyor.
public class SpringlessonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringlessonApplication.class, args);
	}

}

/* Projede biz pokemonları karakterleri ve savaş alanlarını veritabanında tutacağız.
* Kaydedip get ile getireceğiz.
* ekstra olarak pikaçu seni şeçtim diye string gönderince pickachunun objesini döneceğiz.
* Stadyumlar listelenecek eklenecek ve stadyumun isminde % olan bir şeyler getirilecek.
* oyundaki karakterler listelenecek.
* Yazdığımız apiye Ash pikachuyu seçsin diyoruz ikisinin de verileri dönüyor.
* */
