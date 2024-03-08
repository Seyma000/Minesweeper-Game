# MineSweeper Oyunu

Bu proje, Java dilinde metin tabanlı bir Mayın Tarlası oyununu içermektedir. Oyun kuralları gereğince, kullanıcı tarafından girilen satır ve sütun sayılarına göre bir oyun alanı oluşturulur. Oyuncu, bu alanda rastgele yerleştirilmiş mayınları bulmaya çalışır.

## Nasıl Çalıştırılır

1. Java çalışma zamanı ortamınızın kurulu olduğundan emin olun.
2. Bu projeyi bilgisayarınıza indirin veya klonlayın.
3. Java derleme aracınızı kullanarak `MineSweeper.java` dosyasını derleyin:
    ```
    javac MineSweeper.java
    ```
4. Derlendikten sonra, `Main` sınıfını içeren `Main.class` dosyasını çalıştırın:
    ```
    java Main
    ```
5. Program başladığında, satır ve sütun sayılarını girmeniz istenecektir. İstenilen girişleri yapın ve Enter tuşuna basın.
6. Oyun başlayacak ve size sırasıyla satır ve sütun bilgilerini girmeniz gerekecektir. Girişlerinizi yapın ve Enter tuşuna basın.
7. Mayınlardan kaçının ve tüm boş hücreleri açarak oyunu kazanmaya çalışın!

## Teknolojiler

- Java 21
- Scanner sınıfı (kullanıcı girişi almak için)
- Random sınıfı (rastgele sayılar oluşturmak için)

## Notlar

- Oyun başlangıcında, oyun alanında rastgele yerleştirilmiş mayınlar bulunmaktadır. Oyuncunun amacı, tüm mayınları bulmadan tüm boş hücreleri açmaktır.
- Kullanıcı tarafından girilen satır ve sütun sayılarına göre oyun alanı oluşturulur ve mayınlar yerleştirilir.
- Mayın bulunan hücrelere tıklanması durumunda oyun kaybedilir. Tüm boş hücrelerin açılması durumunda ise oyun kazanılır.
