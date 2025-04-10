simple library management system(console based)
it has features:
# add new books-(title,author)
# add new patron/users-(name)
# borrow  books-(keeps track of borrow date)
# return books-(keep tracks of fine automatically)
View: 
-can view all books available or borrowed by some one at that time
-console based menu-driven interface
-input validation and error handling

$ Classes structure:
# Book: stores the title and name of book
        keep track of availability of book
        and stores borrow date and due date which 7 days after borrow date
# Patrons: stores name and borrowed books 
# Library: Manages book and patrons,handles borrow/return logic
# Driver: Main class with menu ui and user interaction

⌛Borrowing and returning 
 # if book is available borrower can borrow and borrow date is set to the current time
 # sets duedate to 7 days after borrowedDate
 # on returning calculates fine if delayed than duedate by $10 per day

** $how to run **
clone or download the project
and run Driver class
