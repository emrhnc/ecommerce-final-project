# Medipol Üniversitesi - Java Final Projesi: E-Ticaret API

Bu proje, bir E-Ticaret platformunun temel backend servislerini içeren bir REST API uygulamasıdır. Proje, Spring Boot kullanılarak geliştirilmiştir ve ürün yönetimi, kategori işlemleri gibi temel fonksiyonları içerir.

## Proje Yapısı

Proje, katmanlı mimari prensiplerine uygun olarak aşağıdaki paket yapısında organize edilmiştir:

-   `com.medipol.ECommerceFinal`
    -   **`config`**: Uygulamanın yapılandırma sınıflarını içerir. (`AsyncConfig` vb.)
    -   **`controller`**: Dış dünyadan gelen HTTP isteklerini karşılayan ve yanıt döndüren REST API katmanıdır. (`ProductController`)
    -   **`model`**: Veritabanı tablolarını temsil eden JPA varlık (entity) sınıflarını barındırır. (`Product`, `Category`)
    -   **`repository`**: Veritabanı sorgularını yöneten Spring Data JPA arayüzlerini içerir. (`ProductRepository`)
    -   **`service`**: Uygulamanın iş mantığını (business logic) içeren katmandır. (`ProductService`, `NotificationService`)
    -   **`ECommerceFinalApplication`**: Spring Boot uygulamasını başlatan ana sınıftır.

## Kullanılan Teknolojiler ve Konular

Bu proje, ders kapsamında belirtilen konuları kapsayacak şekilde aşağıdaki teknolojiler kullanılarak geliştirilmiştir:

-   **Backend:** Java 17, Spring Boot 3.3.0
-   **Veritabanı:** Microsoft SQL Server (MSSQL)
-   **Veri Erişimi:** Spring Data JPA, Hibernate
-   **API:** Spring Web (RESTful API)
-   **Bağımlılık Yönetimi:** Maven
-   **Yardımcı Kütüphaneler:** Lombok
-   **İşlenen Konular:** OOP, Kalıtım, Generic Programlama, Lambda & Stream API, Multithreading (`@Async`), Sıralama/Arama Algoritmaları (JPA üzerinden).

## API Uç Noktaları (Endpoints)

-   `POST /api/products`: Yeni bir ürün oluşturur.
-   `GET /api/products`: Tüm ürünleri listeler.
-   `GET /api/products/sorted-by-price`: Ürünleri fiyata göre artan sırada listeler.
-   `GET /api/products/search?keyword={kelime}`: Ürünleri isme göre arar.
-   `GET /api/products/filter/expensive-than?price={fiyat}`: Belirtilen fiyattan daha pahalı ürünleri listeler.

## Nasıl Çalıştırılır?

1.  Bu repoyu bilgisayarınıza klonlayın.
2.  Bilgisayarınızda bir MSSQL Server örneğinin çalıştığından emin olun.
3.  SQL Server Management Studio (SSMS) kullanarak `ECommerceDB` adında yeni bir veritabanı oluşturun.
4.  Veritabanı için gerekli kullanıcı adı ve şifre yetkilendirmelerini yapın.
5.  Projedeki `src/main/resources/application.properties` dosyasını kendi MSSQL bağlantı bilgilerinizle (URL, kullanıcı adı, şifre) güncelleyin.
6.  Projeyi kullandığınız IDE üzerinden veya terminalde proje kök dizinindeyken `mvn spring-boot:run` komutuyla çalıştırın.