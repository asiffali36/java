package com.example.lse_bot.model;

public class NewsModel {
    String companyName;
    String issuerName;
    String datetime ;


    public NewsModel(String companyName, String issuerName, String datetime) {
        this.companyName = companyName;
        this.issuerName = issuerName;
        this.datetime = datetime;
    }

    public NewsModel() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "newsModel{" +
                "companyName='" + companyName + '\'' +
                ", issuerName='" + issuerName + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
