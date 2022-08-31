package queries;

import entities.Company;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JpaManager;

import java.util.List;

public class CompanyQuery {

    private JpaManager jpaManager = new JpaManager();
    private EntityManager manager;
    private Company company;
    private List<Company> listCompany;
    private EntityTransaction transaction;


    public CompanyQuery(){
        //Create new entity manager and transaction
        manager = jpaManager.getManager();
        transaction = manager.getTransaction();
    }

    public List<Company> getAllCompanies() {

        //Get all companies using 'createQuery' operation
        listCompany =  manager.createQuery("FROM company").getResultList();

        return listCompany;
    }

    public Company getCompanyById(int id) {

        //Get company by id using 'find' operation
        company = manager.find(Company.class,id);

        return company;
    }

    public List<Company> getCompanyByName(String name) {

        //Get companies by name using 'createQuery' operation
        listCompany = manager.createQuery("SELECT cm FROM company cm WHERE cm.name = :name").setParameter("name",name).getResultList();

        return listCompany;
    }

    public int insertCompany(Company company){

        //Begin transaction
        transaction.begin();
        //Create a new company using 'persist' operation
        manager.persist(company);

        try{
            //Commit transaction
            transaction.commit();
            return company.getId();

        }catch(Exception e){
            //Rollback transaction
            transaction.rollback();
            System.out.println("Database wasn't updated");
            return -1;

        }


    }

    public int updateCompanyName(int id,String name,String phoneNumber,String email, String address){

        company = getCompanyById(id);

        if(company != null){
            //Update company attributes
            company.setName(name);
            company.setPhoneNumber(phoneNumber);
            company.setEmail(email);
            company.setAddress(address);

            //Begin transaction
            transaction.begin();
            //Update company using 'merge' operation
            manager.merge(company);

            try{
                //Commit transaction
                transaction.commit();
                return company.getId();

            }catch(Exception e) {
                //Rollback transaction
                transaction.rollback();
                System.out.println("Database wasn't updated");
                return -1;
            }

        }else{
            System.out.println("Company wasn't found");
            return -1;
        }

    }

    public int deleteCompany(int id){

        company = getCompanyById(id);

        if(company != null){

            //Begin transaction
            transaction.begin();
            //Delete company using 'remove' operation
            manager.remove(company);

            try{
                //Commit transaction
                transaction.commit();
                return company.getId();

            }catch(Exception e) {
                //Rollback transaction
                transaction.rollback();
                System.out.println("Database wasn't updated");
                return -1;
            }

        }else{
            System.out.println("Company wasn't found");
            return -1;
        }


    }



}
