package ch.bbw.cardgame;

public class City {
    private String imageUrl;
    private String name;
    private int noOfCityzens;
    private int area;
    private String country;
    private int averageWage;
    private int age;






    public City(String name, int noOfCityzens, int area, String country, int averageWage, String imageUrl, int age){

        this.imageUrl = imageUrl;
        this.name = name;
        this.noOfCityzens = noOfCityzens;
        this.area = area;
        this.country = country;
        this.averageWage = averageWage;
        this.age = age;

    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfCityzens() {
        return noOfCityzens;
    }

    public void setNoOfCityzens(int noOfCityzens) {
        this.noOfCityzens = noOfCityzens;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAverageWage() {
        return averageWage;
    }

    public void setAverageWage(int averageWage) {
        this.averageWage = averageWage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
