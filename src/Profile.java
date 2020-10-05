/**
 * The profile class where all the attributes of a profile is stored.
 *
 * @author 1909148
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Profile {
    private String firstName;
    private String lastName;
    private int day;
    private int month;
    private int year;
    private String email;
    private String[] interest;
    private String[] groups;
    private ArrayList<Profile> friends = new ArrayList<>();

    /**
     * A Constructor for profile
     *
     * @param firstName The first name of a person's profile.
     * @param lastName  The last name of a person's profile.
     * @param day       The day of the date of birth of a person's profile.
     * @param month     The month of the date of birth of a person's profile.
     * @param year      The year of the date of birth of a person's profile.
     * @param email     The email of a person's profile.
     * @param interest  The interests of a person's profile.
     * @param groups    The groups of a person's profile.
     */
    public Profile(String firstName, String lastName, int day, int month, int year, String email, String[] interest,
                   String[] groups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.email = email;
        this.interest = interest;
        this.groups = groups;
    }

    /**
     * A getter for the first name.
     *
     * @return The first name of a person's profile.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * A setter for the first name
     *
     * @param firstName The string value of a person's profile
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * A getter for the last name.
     *
     * @return The last name of a person's profile.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * A setter for the last name.
     *
     * @param lastName The string value of a person's profile.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * A getter for the day.
     *
     * @return The day of date of birth of a person's profile.
     */
    public int getDay() {
        return day;
    }

    /**
     * A setter for the day.
     *
     * @param day The integer value of day.
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * A getter for month.
     *
     * @return The month of date of birth of a person's profile.
     */
    public int getMonth() {
        return month;
    }

    /**
     * A setter for month.
     *
     * @param month The integer value of month.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * A getter for year.
     *
     * @return The year of date of birth of a person's profile.
     */
    public int getYear() {
        return year;
    }

    /**
     * A setter for year.
     *
     * @param year The integer value of year.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * A getter for email.
     *
     * @return The email of a person's profile.
     */
    public String getEmail() {
        return email;
    }

    /**
     * A setter for email.
     *
     * @param email The String value of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * A getter for interests.
     *
     * @return The interest of a person's profile.
     */
    public String[] getInterest() {
        return interest;
    }

    /**
     * A setter for interest.
     *
     * @param interest The String array of interests.
     */
    public void setInterest(String[] interest) {
        this.interest = interest;
    }

    /**
     * A getter for groups.
     *
     * @return The groups of a person's profile.
     */
    public String[] getGroups() {
        return groups;
    }

    /**
     * A setter for groups.
     *
     * @param groups The String array of groups.
     */
    public void setGroups(String[] groups) {
        this.groups = groups;
    }

    /**
     * A method to combine all of the Date of birth into a single line.
     *
     * @return A string of a person's date of birth on a profile.
     */
    public String getDateOfBirth() {
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

    /**
     * A setter to add a profile to friends.
     *
     * @param p The profile to be added.
     */
    public void addFriend(Profile p) {
        friends.add(p);
    }

    /**
     * A getter for friend.
     *
     * @param i The index of the friends list.
     * @return The profile of friend.
     */
    public Profile getFriend(int i) {
        return friends.get(i);
    }

    /**
     * A method to show how many friends are in the friends list.
     *
     * @return
     */
    public int numOfFriends() {
        return friends.size();
    }

    /**
     * A toString method to for testing purposes.
     *
     * @return The result in String.
     */
    @Override
    public String toString() {
        String result = "";
        result += getLastName() + " " + getFirstName() + " DOB: " + getDateOfBirth() + " Email: " + getEmail() +
                " Interests: " + Arrays.toString(getInterest()) + " Groups : " + Arrays.toString(getGroups());
        return result;
    }
}