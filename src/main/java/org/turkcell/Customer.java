package org.turkcell;

public class Customer extends User {
    private String nationalIdentity;
    private int birthYear;
    private boolean isCitizen;

    private BankAccount bankAccount;

    public Customer( String nationalIdentity, BankAccount bankAccount, int birtYear, String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        this.nationalIdentity = nationalIdentity;
        this.birthYear = birtYear;
        this.bankAccount = bankAccount;
        this.isCitizen = EDevletAPI.verifyIfCitizen(this);
        System.out.println( "Bu müşteri " + (isCitizen? "vatandaş.": "vatandaş değil.") );
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isCitizen() {
        return isCitizen;
    }

    public void setCitizen(boolean citizen) {
        isCitizen = citizen;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nationalIdentity='" + nationalIdentity + '\'' +
                ", birthYear=" + birthYear +
                ", isCitizen=" + isCitizen +
                ", bankAccount=" + bankAccount +
                '}';
    }
}
