//skeleton for an interface

public class NameInterface {
    /** Sets the first and last names.
     * 
     * @param firstName a string that is desired first name
     * @param lastName a string that is deisred last name
     */
    public void setName(String firstName, String lastName);

    /**
     * Gets the full name.
     * @return A string containing the first and last names */
    public String getName();

    public void setFirst(String firstName);
    public String getFirst();

    public void setLast(String lastName);
    public String getLast();

    public void giveLastNameTo(NameInterface aName);

    public String toString();

}
