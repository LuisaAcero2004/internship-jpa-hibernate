package utils.crud;

import entities.Company;
import queries.CompanyQuery;

import java.util.List;

public class CompanyCrud {

    CompanyQuery companyQuery = new CompanyQuery();
    List<Company> companyList;
    Company company;

    //Execute queries and print the results

    public void getAllCompanies(){
        companyList = companyQuery.getAllCompanies();

        if(companyList.size() != 0){
            for (Company com:
                    companyList) {
                printCompanyInfo(com);
                System.out.println("");
            }
        }else{
            System.out.println("No companies were found");
        }
    }

    public void getCompanyById(int id){
        company = companyQuery.getCompanyById(id);

        if(company != null){
            printCompanyInfo(company);
        }else {
            System.out.println("The company with id '" + id + "' wasn't found");
        }
    }

    public void getCompanyByName(String name){
        companyList = companyQuery.getCompanyByName(name);

        if(companyList.size() != 0){
            for (Company com:
                    companyList) {
                printCompanyInfo(com);
                System.out.println("");
            }
        }else {
            System.out.println("The company with name '" + name + "' wasn't found");
        }
    }

    public void insertNewCompany(int id, String name, String email, String address, String phone){

        company = new Company();
        company.setId(id);
        company.setName(name);
        company.setEmail(email);
        company.setAddress(address);
        company.setPhoneNumber(phone);

        int companyId = companyQuery.insertCompany(company);

        if(companyId != -1){
            System.out.println("A new company with id " + id + " was created");
        }else {
            System.out.println("No company was created");
        }
    }

    public void updateCompany(int id, String name, String email, String address, String phone){

        int companyId = companyQuery.updateCompanyName(id,name,phone,email,address);

        if(companyId != -1){
            System.out.println("The company with id " + id + " was updated");
        }else {
            System.out.println("No company was updated");
        }

    }

    public void deleteCompany(int id){

        int companyId = companyQuery.deleteCompany(id);

        if(companyId != -1){
            System.out.println("The company with id " + id + " was deleted");
        }else {
            System.out.println("No company was deleted");
        }

    }

    //print the company information
    public void printCompanyInfo(Company company){
        System.out.println("Company Id: "+company.getId());
        System.out.println("Company name: " + company.getName());
        System.out.println("Company email: " + company.getEmail());
        System.out.println("Company phone: " + company.getPhoneNumber());
        System.out.println("Company address: " + company.getAddress());
    }


}
