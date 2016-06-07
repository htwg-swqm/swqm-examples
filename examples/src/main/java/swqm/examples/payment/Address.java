package swqm.examples.payment;

public class Address implements Comparable<Address> {
  private String id = null;
  private String surname = null;
  private String firstname = null;
  private String street = null;
  private String city = null;
  private String postcode = null;


  public Address() {

  }

  public Address(String id, String surname, String firstname, String street, String city,
      String postcode) {
    super();
    this.id = id;
    this.surname = surname;
    this.firstname = firstname;
    this.street = street;
    this.city = city;
    this.postcode = postcode;
  }

  public String getId() {
    return this.id;
  }

  public String getSurname() {
    return this.surname;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public String getStreet() {
    return this.street;
  }

  public String getCity() {
    return this.city;
  }

  public String getPostcode() {
    return this.postcode;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public String getFullname() {
    return this.firstname + " " + this.surname;
  }

  public String getFulladdress() {
    return this.street + " " + this.city + " " + this.postcode;
  }

  public int compareTo(Address address) {
    int compare = this.surname.compareToIgnoreCase(address.surname);
    if (compare == 0) {
      compare = this.firstname.compareToIgnoreCase(address.firstname);
    }
    return (compare);
  }

}
