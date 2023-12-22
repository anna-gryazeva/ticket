package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void aFewTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бангкок", 60_000, 9, 20);
        Ticket ticket2 = new Ticket("Москва", "Волгоград", 10_000, 18, 20);
        Ticket ticket3 = new Ticket("Москва", "Бангкок", 50_000, 10, 19);
        Ticket ticket4 = new Ticket("Москва", "Пенза", 5_000, 12, 14);
        Ticket ticket5 = new Ticket("Москва", "Стамбул", 20_000, 14, 18);
        Ticket ticket6 = new Ticket("Москва", "Бангкок", 45_000, 7, 20);
        Ticket ticket7 = new Ticket("Москва", "Пенза", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket6, ticket3, ticket1};
        Ticket[] actual = manager.search("Москва", "Бангкок");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void oneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бангкок", 60_000, 9, 20);
        Ticket ticket2 = new Ticket("Москва", "Волгоград", 10_000, 18, 20);
        Ticket ticket3 = new Ticket("Москва", "Бангкок", 50_000, 10, 19);
        Ticket ticket4 = new Ticket("Москва", "Пенза", 5_000, 12, 14);
        Ticket ticket5 = new Ticket("Москва", "Стамбул", 20_000, 14, 18);
        Ticket ticket6 = new Ticket("Москва", "Бангкок", 45_000, 7, 20);
        Ticket ticket7 = new Ticket("Москва", "Пенза", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.search("Москва", "Стамбул");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бангкок", 60_000, 9, 20);
        Ticket ticket2 = new Ticket("Москва", "Волгоград", 10_000, 18, 20);
        Ticket ticket3 = new Ticket("Москва", "Бангкок", 50_000, 10, 19);
        Ticket ticket4 = new Ticket("Москва", "Пенза", 5_000, 12, 14);
        Ticket ticket5 = new Ticket("Москва", "Стамбул", 20_000, 14, 18);
        Ticket ticket6 = new Ticket("Москва", "Бангкок", 45_000, 7, 20);
        Ticket ticket7 = new Ticket("Москва", "Пенза", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);


        Ticket[] expected = {};
        Ticket[] actual = manager.search("Москва", "Лондон");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingTicketsByTime() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бангкок", 60_000, 9, 20);
        Ticket ticket2 = new Ticket("Москва", "Волгоград", 10_000, 18, 20);
        Ticket ticket3 = new Ticket("Москва", "Бангкок", 50_000, 10, 19);
        Ticket ticket4 = new Ticket("Москва", "Пенза", 5_000, 12, 14);
        Ticket ticket5 = new Ticket("Москва", "Стамбул", 20_000, 14, 18);
        Ticket ticket6 = new Ticket("Москва", "Бангкок", 45_000, 7, 20);
        Ticket ticket7 = new Ticket("Москва", "Пенза", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket1, ticket6};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Бангкок", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void similarTicketComp() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бангкок", 60_000, 9, 20);
        Ticket ticket2 = new Ticket("Москва", "Волгоград", 10_000, 18, 20);
        Ticket ticket3 = new Ticket("Москва", "Бангкок", 50_000, 10, 19);
        Ticket ticket4 = new Ticket("Москва", "Пенза", 5_000, 12, 14);
        Ticket ticket5 = new Ticket("Москва", "Стамбул", 20_000, 14, 18);
        Ticket ticket6 = new Ticket("Москва", "Бангкок", 45_000, 7, 20);
        Ticket ticket7 = new Ticket("Москва", "Пенза", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket7};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Пенза", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void zeroTicketComp() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бангкок", 60_000, 9, 20);
        Ticket ticket2 = new Ticket("Москва", "Волгоград", 10_000, 18, 20);
        Ticket ticket3 = new Ticket("Москва", "Бангкок", 50_000, 10, 19);
        Ticket ticket4 = new Ticket("Москва", "Пенза", 5_000, 12, 14);
        Ticket ticket5 = new Ticket("Москва", "Стамбул", 20_000, 14, 18);
        Ticket ticket6 = new Ticket("Москва", "Бангкок", 45_000, 7, 20);
        Ticket ticket7 = new Ticket("Москва", "Пенза", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("Москва", "Лондон", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Москва", "Бангкок", 60_000, 9, 20);
        Ticket ticket2 = new Ticket("Москва", "Волгоград", 10_000, 18, 20);
        Ticket ticket3 = new Ticket("Москва", "Бангкок", 50_000, 10, 19);
        Ticket ticket4 = new Ticket("Москва", "Пенза", 5_000, 12, 14);
        Ticket ticket5 = new Ticket("Москва", "Стамбул", 20_000, 14, 18);
        Ticket ticket6 = new Ticket("Москва", "Бангкок", 45_000, 7, 20);
        Ticket ticket7 = new Ticket("Москва", "Пенза", 7_000, 12, 14);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
