/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class MVC {
    View view = new View();
    Model model = new Model();
    Controller control = new Controller(view, model); 
}
