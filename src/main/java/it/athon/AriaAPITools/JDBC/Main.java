package it.athon.AriaAPITools.JDBC;

public class Main {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        // 1. Aggiungiamo un utente
        dao.insertUser("Davide", "davide@email.it");

        // 2. Leggiamo la lista
        System.out.println("Lista utenti nel database:");
        dao.getAllUsers();
    }
}