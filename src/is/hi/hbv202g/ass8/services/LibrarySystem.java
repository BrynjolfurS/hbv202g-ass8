package is.hi.hbv202g.ass8.services;

import is.hi.hbv202g.ass8.entities.*;
import is.hi.hbv202g.ass8.exceptions.EmptyAuthorListException;
import is.hi.hbv202g.ass8.exceptions.UserOrBookDoesNotExistException;

import java.time.LocalDate;
import java.util.List;

public class LibrarySystem {

    private List<Book> books;
    private List<Lending> lendingList;
    private List<User> users;

    public LibrarySystem() {
    }

    public void addBookWithTitleAndAuthorlist(String title, List<Author> authors) {
        Book bookToAdd;
        try {
            bookToAdd = new Book(title, authors);
        } catch (EmptyAuthorListException e) {
            throw new RuntimeException(e);
        }
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

    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book: books) {
            if (book.getTitle().equals(title)){
                return book;
            }
        } throw new UserOrBookDoesNotExistException("Book does not exist");
    }

    public User findUserByName(String name) throws UserOrBookDoesNotExistException{
        for (User user: users) {
            if (user.getName().equals(name)) {
                return user;
            }
        } throw new UserOrBookDoesNotExistException("User does not exist");
    }

    public void borrowBook(User user, Book book) {
        Lending lendBookToUser = new Lending(book, user);
        lendingList.add(lendBookToUser);
    }

    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) {
        for (Lending lending: lendingList) {
            if (lending.getBook().getTitle().equals(book.getTitle())) {
                lending.setDueDate(newDueDate);
            }
        }
    }

    public void returnBook(User user, Book book) {
        for (Lending lending: lendingList) {
            if (lending.getBook().equals(book) && lending.getUser().equals((user))) {
                lendingList.remove(lending);
            }
        }
    }
}
