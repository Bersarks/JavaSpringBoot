## Kullanım
```https://api.postman.com/collections/28796069-f843ccba-455d-40a7-bc78-e959204b60a3?access_key=PMAT-01H76ED69G1AJWBW5XVP7C5GJQ```
- API üzerinden örnek isterkleri kullanmak için linki kullanabilirsiniz.
## Örnek Senaryolar
- Kullanıcıların tc kimlik numaraları unique olmak zorunda.
- Bir müşterinin açık siparişi varsa yenisi oluşturulamaz. Yeni ürün eklenmek istediğinde var olan ve onay bekleyen siparişe eklenebilir.
- Ürünler vergili yada vergisiz fiyatlarıyla kayır edilir. Şuanki haliyle zorunlu olarak 1 vergi eklenmesi gerekli.
- Vergisiz ürünlerin fiyatları bu vergi ile hesaplanarak siparişe ekleniyor.
- Tüm sipariş işlemi bittiğinde siparişin durumu onaylanırsa fatura oluşturuluyor.
- İptal edilirse ürünlerin stokları tekrar güncelleniyor ve sipariş siliniyor.

### Not: Şuanda direkt olarak entity'ler üzerinden işlem yapılabiliyor. İleride değiştirilebilir.
