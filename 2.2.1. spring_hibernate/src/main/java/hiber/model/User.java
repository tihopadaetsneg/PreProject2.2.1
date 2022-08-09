package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   /*
         Вот это и есть внешний ключ, который я создавал в БД.
         Хибернейт кабанчиком метнется в бд, посмотрит там на столбец с именем "car_id"
         Узнает что это внешний ключ для другой таблицы в БД
         Метнется туда и вытащит все, что мне надо
    */
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "car_id")
   private Car car;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", car=" + car +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
}
