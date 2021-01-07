/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.User;

/**
 *
 * @author Tolis
 */
public interface User {


    public boolean checkFields();

    public String getUsername();

    public String getPassword();

    public String getEmail();

    public void setUsername(String username);

    public void setPassword(String password);

    public void setEmail(String email);

    @Override
    public String toString();
}
