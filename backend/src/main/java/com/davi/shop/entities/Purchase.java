package com.davi.shop.entities;

import com.davi.shop.Enum.Sex;
import com.davi.shop.entities.location.Address;
import com.davi.shop.entities.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Entity
@Table(name = "purchase")
public class Purchase{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long purchase_id;
        @NotNull(message = "'user' should not be empty.")
        private String First_name;
        @NotNull(message = "'user' should not be empty.")
        private String Last_name;
        @NotNull(message = "'age' should not be empty.")
        private Long age;
        @NotNull(message = "'purchase value' should not be empty.")
        private Long purchase_value;
        @NotNull(message = "'age' should not be empty.")
        private Sex sex;
        @NotNull(message = "'IpAdress' should not be empty.")
        private String IpAdress;
        private Date purchase_time = new Date();

        private Date singup_time =new Date(purchase_time.getTime() - 1000);
        private int classe =0;
        private static final String[] SOURCE_OPTIONS = {"SEO", "Ads", "Direct"};
        private static final String[] BROWSER_OPTIONS = {"FireFox", "Chrome", "Safari", "Opera", "IE"};
        @Column(columnDefinition = "TEXT")
        private String Source = getRandomSource();
        @Column(columnDefinition = "TEXT")
        private String browser = getRandomBrowser();
        private static final String[] DEVICE_ID_OPTIONS = {"NAUITBZFJKHWW", "YSSKYOSJHPPLJ", "EOGFQPIZPYXFZ", "QVPSPJUOCKZAR", "YIIEFBZUGEXNR", "URHCRIXOMLJMH", "ALEYXFXINSXLZ"};
        @Column(columnDefinition = "TEXT")
        private String device_id = getRandomDeviceId();
    private String getRandomDeviceId() {
        Random random = new Random();
        int index = random.nextInt(DEVICE_ID_OPTIONS.length);
        return DEVICE_ID_OPTIONS[index];
    }
    private String getRandomBrowser() {
        Random random = new Random();
        int index = random.nextInt(BROWSER_OPTIONS.length);
        return BROWSER_OPTIONS[index];
    }
    private String getRandomSource() {
        Random random = new Random();
        int index = random.nextInt(SOURCE_OPTIONS.length);
        return SOURCE_OPTIONS[index];
    }


    public Purchase(Long purchase_id, String first_name, String last_name, Long age, Sex sex, String ipAdress, Date purchase_time, Date singup_time, String source, String browser, String device_id, int classe) {
        this.purchase_id = purchase_id;
        First_name = first_name;
        Last_name = last_name;
        this.age = age;
        this.sex = sex;
        IpAdress = ipAdress;
        this.purchase_time = purchase_time;
        this.singup_time = singup_time;
        Source = source;
        this.browser = browser;
        this.device_id = device_id;
        this.classe = classe;
    }

    public Purchase() {
    }

    public Long getPurchase_value() {
        return purchase_value;
    }

    public void setPurchase_value(Long purchase_value) {
        this.purchase_value = purchase_value;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getFormattedSignupTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(singup_time);
    }

    public String getFormattedPurchaseTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(purchase_time);
    }
    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public Long getPurchase_id() {
        return purchase_id;
    }

    public void setPurchase_id(Long purchase_id) {
        this.purchase_id = purchase_id;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        Last_name = last_name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getPurchase_time() {
        return purchase_time;
    }

    public void setPurchase_time(Date purchase_time) {
        this.purchase_time = purchase_time;
    }

    public String getIpAdress() {
        return IpAdress;
    }

    public void setIpAdress(String ipAdress) {
        IpAdress = ipAdress;
    }

    public Date getSingup_time() {
        return singup_time;
    }

    public void setSingup_time(Date singup_time) {
        this.singup_time = singup_time;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}

