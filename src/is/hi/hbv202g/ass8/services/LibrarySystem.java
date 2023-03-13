package is.hi.hbv202g.ass8.services;

import is.hi.hbv202g.ass8.entities.*;

import java.time.LocalDate;
import java.util.List;

public class LibrarySystem {

    private List<Book> books;
    private List<Lending> lendingList;
    private List<User> users;

    public LibrarySystem() {
    }

    public void addBookWithTitleAndAuthorlist(String title, List<Author> authors) {
        Book bookToAdd = new Book(title, authors);
        books.add(bookToAdd);
    }

    public void addStudentUser(String name, boolean feePaid) {
        Student newStudentUser = new Student(name, feePaid);
        users.add(newStudentUser);
    }

    public void addFacultyMemberUser(String name, String department) {
        FacultyMember newFacultyMemberUser = new FacultyMember(name, department);
        users.add(newFacultyMemberUser);
    }

    public Book findBookByTitle(String title) {
        for (Book book: books) {
            if (book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }

    public User findUserByName(String name) {
        for (User user: users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void borrowBook(User user, Book book) {
        Lending lendBookToUser = new Lending(book, user);
        lendingList.add(lendBookToUser);
    }

    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
        Lending lendingToExtend =
    }

    public void returnBook(User user, Book book) {

    }
}
