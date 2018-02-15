# JavaProje-2

#### Genel Problem Tanımı: 
Çift bağlı liste (doubly linked list) veri yapısı kullanımına dayanan ve isme göre alfabetik sıralı bir telefon rehberi uygulaması geliştirilmesi istenmektedir. Uygulama görsel bir arayüze de sahip olacaktır. Bu bağlamda aşağıda detaylı olarak verilen gereksinimleri karşılayacak Java kodlarını yazınız.

#### Gereksinimler: 
Rehberde kişilerin adı ve soyadları ile telefon numaraları yer almaktadır. Kişilerin adı ve soyadlarını temsil etmek için adSoyad şeklinde bir String değişken kullanabilirsiniz. Kişinin birden fazla telefon numarası olabilir, bu nedenle kişinin telefon numaraları bir “ArrayList” içinde saklanabilecektir. Kişilerin söz edilen bu bilgilerini Bilgi isimli bir sınıf içinde tanımlayınız. Bu doğrultuda, listeye ilişkin düğüm (Node) sınıfında çift bağlı liste için gerekli bağ sahaları yanı sıra Bilgi sınıfı tipinde bir değişken tanımı da yapılacaktır.

Çift bağlı liste sınıfınızda, çift bağlı liste kullanmanın olası avantajlarından yararlanabilmek için listenin başını (head) ve sonunu (tail) temsil eden 2 değişken tanımlayınız.

**Uygulamada kullanıcıya aşağıdaki seçenekler sunulmalıdır:**

1) Aşağıda gösterilen biçimdeki ve rehber.txt isimli metin dosyasından okuma yapılarak çift bağlı liste bellekte oluşturulmalıdır. (Veriler virgül ile ayrılmıştır.)

- **NOT-1:** Rehber isme göre alfabetik sıralı oluşturulacak olup, aynı isimde diğer bir kişi geldiğinde soyada göre alfabetik sıralı olacak şekilde eklenecektir.
- rehber.txt
- Veli Tuz, 0 533 1111111, 0 232 1111111
- Ali Kara, 0 554 2222222, 0 543 3333333, 0 312 1111111
- Can Demir, 0 216 4444444
- …. gibi 


2) Görsel kullanıcı arayüzünden verileri girilen kişi rehbere alfabetik sıraya göre uygun olan pozisyona eklenecektir. Diğer deyiş ile çift bağlı listeye ekleme yapılmış olacaktır.

3) Görsel kullanıcı arayüzünden adı ve soyadı verilen bir kişinin bilgileri metin alanı (TextArea) veya buna benzer bir görsel bileşene yazdırılacaktır.

4) Görsel kullanıcı arayüzünden adı ve soyadı girilen kişi rehberden silinecektir. (Basitleştirme adına aynı isim ve soyada sahip kişi olmadığı varsayılabilir.) Diğer deyiş ile çift bağlı listeden silme yapılmış olacaktır.

5) Rehberin içindeki tüm kayıtlar artan alfabetik sırada (A’dan Z’ye) uygun bir görsel bileşene yazdırılacaktır.

6) Rehberin içindeki tüm kayıtlar azalan sırada (Z’den A’ya) uygun bir görsel bileşene yazdırılacaktır.

7) ÇIKIŞ: Rehberin içindeki bilgiler “sakla.txt” isimli dosyaya 1. Maddede belirtilen biçime uygun şekilde kayıt edildikten sonra uygulamadan çıkılacaktır.




