package org.turkcell;

public class EDevletAPI {

    private static final Citizen[]  citizens = {
            new EDevletAPI.Citizen("12345678901", "Mert", "Deniz", 2000 ),
            new EDevletAPI.Citizen("23423424324", "Ali", "Demir", 1975 ),
            new EDevletAPI.Citizen("43433242341", "Özge", "Yılmaz", 1988 ),
    };
    public static boolean verifyIfCitizen(Customer customer){
        boolean checkNationalIdentity = false;

        if(checkNationalIdentity){
            String nationalIdentity = customer.getNationalIdentity();

            //
            int oddNumberTotal = 0;
            for(int i=0; i<9; i+=2){
                char digit = nationalIdentity.charAt(i); // '1' != 1      '1' + '3' !== "13"
                oddNumberTotal += Integer.parseInt(String.valueOf(digit));
            }

            //
            int evenNumberTotal = 0;
            for(int i=1; i<8; i+=2){
                char digit = nationalIdentity.charAt(i);
                evenNumberTotal += Integer.parseInt(String.valueOf(digit));
            }

            //
            int tenthDigit = (oddNumberTotal*7 - evenNumberTotal) % 10;
            if(tenthDigit != Integer.parseInt(String.valueOf(nationalIdentity.charAt(9))))
                return false;

            //
            int eleventhDigit = (oddNumberTotal+evenNumberTotal+tenthDigit) % 10;
            if(eleventhDigit != Integer.parseInt(String.valueOf(nationalIdentity.charAt(10))))
                return false;

        }


        for(Citizen citizen: citizens){
            if(
                citizen.getNationalIdentity().equals(customer.getNationalIdentity()) &&
                citizen.getFirstName().equalsIgnoreCase(customer.getFirstName()) &&
                citizen.getLastName().equalsIgnoreCase(customer.getLastName()) &&
                citizen.getBirthYear() == customer.getBirthYear()
            ){

                    System.out.println("Customer(" + customer.getId()+ ") is verified");
                    return true;
                }
        }

        System.out.println("Customer(" + customer.getId()+ ") is not verified");
        return false;
    }


    private static class Citizen{
        private String nationalIdentity;
        private String firstName;
        private String lastName;
        private int birthYear;


        public Citizen(String nationalIdentity, String firstName, String lastName, int birthYear) {
            this.nationalIdentity = nationalIdentity;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthYear = birthYear;
        }

        public String getNationalIdentity() {
            return nationalIdentity;
        }

        public void setNationalIdentity(String nationalIdentity) {
            this.nationalIdentity = nationalIdentity;
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

        public int getBirthYear() {
            return birthYear;
        }

        public void setBirthYear(int birthYear) {
            this.birthYear = birthYear;
        }
    }

}
