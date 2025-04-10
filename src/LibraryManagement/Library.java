package LibraryManagement;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Library {
    private final int  MAX_BOOKS=5;
    private final int  MAX_PATRONS=5;

   private final Book[] books=new Book[MAX_BOOKS];
   private final Patrons[] patrons=new Patrons[MAX_PATRONS];
   private int bookCount=0;
   private int patronCount=0;

    public int getBookCount() {
        return bookCount;
    }

    public int getPatronCount() {
        return patronCount;
    }

    public Book[] getBooks(){
        return books;
    }
    public boolean addBook(String title, String author) {
        if(bookCount<MAX_BOOKS){
         books[bookCount++]=new Book(title,author);
            System.out.println("Book has successfully added to the system");
         return true;
        }else{
            System.out.println("You have reached with Max Limit");
            return false;
        }
    }

    public boolean addPatron(String name) {
        if(patronCount>=MAX_PATRONS){
            System.out.println("You have reached with Max Limit");
            return false;
        }
        patrons[patronCount++]=new Patrons(name,MAX_BOOKS);
        return true;
    }


    public boolean borrowBook(int patronId, int bookId){
        if(!isValidPatron(patronId) || !isValidBook(bookId)){
            System.out.println("Not valid credentials");
            return false;
        }
        Book book=books[bookId];
        if(!book.isAvailable())return false;
        book.borrow();
        Patrons patron=patrons[patronId];
        patron.borrowBook(bookId);
        System.out.println("Your due date is:" +book.getReturnDate());
        return true;
    }


    public boolean returnBook(int patronId,int bookId){
        if(!isValidBook(bookId) || !isValidPatron(patronId)){
            return false;
        }
        Book book=books[bookId];
        Patrons patron=patrons[patronId];
        if(!patron.hasBorrowed(bookId))return false;
        LocalDateTime now=LocalDateTime.now();
        LocalDateTime dueDate=book.getReturnDate();
        long delayedDays=java.time.Duration.between(dueDate,now).toDays();
        if(delayedDays>0){
            long fine=delayedDays*10;
            System.out.println("You are returning beyond returning time period so you have to pay "+fine);
        }else{
            System.out.println("You are on time,no fine for you,Keep learning!!!");
        }
        patron.returnBook(bookId);
        book.returnBook();
        return true;
    }
    public boolean isValidBook(int bookId) {
        return bookId >=0 && bookId < bookCount;
    }

    public boolean isValidPatron(int patronId) {
        return patronId>=0 && patronId < patronCount;
    }

}
