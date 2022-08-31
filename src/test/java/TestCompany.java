import org.testng.annotations.Test;
import utils.crud.CompanyCrud;

public class TestCompany {

    CompanyCrud companyCrud = new CompanyCrud();

    @Test
    public void getAllCompanies(){
        companyCrud.getAllCompanies();
    }

    @Test
    public void getCompanyByName(){
        String name = "Only";
        companyCrud.getCompanyByName(name);
    }

    @Test
    public void getCompanyById(){
        int id = 1;
        companyCrud.getCompanyById(id);
    }

    @Test
    public void insertNewCompany(){
        int id = 6;
        String name = "D1";
        String email = "d1@d1.com";
        String address = "Cll 3 #4-78";
        String phone = "1234567";

        companyCrud.insertNewCompany(id,name,email,address,phone);
        companyCrud.getCompanyById(id);
    }

    @Test
    public void updateCompany(){

        int id = 6;
        String name = "Justo y Bueno";
        String email = "jyb@jyb.com";
        String address = "Cll 3 #4-78";
        String phone = "12398737";

        companyCrud.getCompanyById(id);
        companyCrud.updateCompany(id, name,email,address,phone);
        companyCrud.getCompanyById(id);
    }

    @Test
    public void deleteCompany(){
        int id = 6;

        companyCrud.getCompanyById(id);
        companyCrud.deleteCompany(id);
        companyCrud.getCompanyById(id);
    }

}
