# UTP
### *Universal Programming Techniques in Java*
###### This course is meant to learn how to make your programs operate more quickly and aquire skills that will aid me in later endevours.
###### Each task included will have a set of "Test" classes meant to test the functionality of a program. 
</br>



## ***Table of Contents***
### **UTP Task** [1](https://github.com/patjagielski/UTP/tree/master/UTP_1/UTP/src)
Title: *Generics* </br>
**Objective:**</br>
Create classes that implement interfaces *IAggregable* and *IDeeplyCloneable*.</br>
Create a *"Container"* class that will hold instances of these interfaces.
    
 ### **UTP Task** [2](https://github.com/patjagielski/UTP/tree/master/UTP_2/UTP_Task2)
 Title: *Functional Programming* </br>
 **Objective:**</br>
Create a hierarchy of classes for storing information about human resources of a company.</br>
Create a 3-level hierarchy composed of at least 20 different employees of types:</br>
* Trainees
* Workers
* Managers</br>

Using *Functional Programming* techniques prepare the following:
 1. payroll for all employees
 2. payroll for subordinates of a given Manager
 3. searching for an employee with the longest seniority
 4. searching for the highest salary without bonus 
 5. searching for the highest salary with bonus
 6. searching for employees whose surnames begin with [Given Letter] of a given Manager
 7. searching for all employees who earn more than 1000 PLN

 ### **UTP Task** [3](https://github.com/patjagielski/UTP/tree/master/UTP_3/UTP_Task3/src/com/company)
 Title: *Lambda expressions* </br>
 **Objective:**</br>
 Similar to Task 2, but implementation of lambda expressions and changes to a few methods.

 ### **UTP Task** [4](https://github.com/patjagielski/UTP/tree/master/UTP_4/UTP_4/src)
 Title: *Collections*</br>
 **Objective:**</br>
Create application which will read input data from the file of the following format: </br>
**< FirstName >< Surname >< Birhtdate >** </br>
The contents of an example:</br>
**Jane Doe 1950-01-02**</br>
Additionally implement a unique ID for each person allowing them to be identified seperately.</br>
Data entered from the input file should be stored in several collections: </br>

1. sorted by first name.
2. sorted by surname, first name and birthdate.
3. sorted by birthdate
4. collection which enables quick filtering of data of people born on a specific day.
    * enable custom sorting by implementing interface *Comparable<TValue>* and *Comparator<TValue>* interfaces 
    * for quick filtering feature use an implementation of *Map<TKey, TValue>* interfaces.
  
 ### **UTP Task** [5](https://github.com/patjagielski/UTP/tree/master/UTP_5/UTP_5)
 Title: *Collections - Priority Queues*</br>
 **Objective:**</br>
Create a multi-threaded application based on requestor-service architecture.</br>
The requestor threads put tasks in queues.</br>
The service threads get tasks from a queue, perform them and then put processing result in the queue with the same priority as the task.</br>
Each task put in the queue by the requestor has a priority: LOW, NORMAL, HIGH</br>
Priorities are held in an enum.</br>
Tasks are retrieved from queue based on the priority.</br>
**Example:**
A task for this process could be performing arithmetic equations. In this case the request would contain two objects that will be passed to the response and the response will calculate the the two objects.</br>
The result is sent back to the requestor and consumed by the requestor.


 ### **UTP Task** [6](https://github.com/patjagielski/UTP/tree/master/UTP_6/UTP_6/src)
Title: *Collections - Sets, Maps and Collation*</br>
 **Objective:**</br>
1. Create a class hierarchy composed of:
    *class Person( [Pesel](https://en.wikipedia.org/wiki/PESEL), surname, first name, birthdate, nationality)
    *class Student extends Person(Student ID)
    *class Teacher extends Person(Degree, hiredate)
2. Classes that represent:
    *Department (name, employees)
    *Student Group (name)
    *Subject (name, supervising Department, lecturer, attending students)
3. Create a collection of instances from each of the classes, disallowing duplicates.
4. For extension classes storing information about Person and its derivatives ensure:
    *sorting instances based on Polish collation
    *filtering people of the selected nationality and sort their names based on the rules of their nationality.
5. Implement methods *hashCode()*, *equals()* and *Comparable.compareTo()*.
6. Create Generator to automatically generate input data composed of:
    * 100 students of random nationalities
    * 12 student groups
    * 3 departments
    * 10 subjects
    * 10 teachers of random nationalities
    
 ### **UTP Task** [7](https://github.com/patjagielski/UTP/tree/master/UTP_7/UTP_7/src)
 Title: *Stream(pipeline) Processing*</br>
 **Objective:**</br>
Create 3 utility classses for:
1. regular files/directories
2. zip archives
3. jar archives
Each class must be able to:
1. Find files or directories by name in the given, directory, zip or jar archive.
2. Find files with the given content in the given directory, zip or jar archive.

 ### **UTP Task** [8](https://github.com/patjagielski/UTP/tree/master/UTP_8/UTP_8/src)
 Title: *Input/Output Streams*</br>
 **Objective:**</br>
Extends solution from UTP Task 4 by adding the following features:
1. Store your databse in a file using **DataOutputStream** the format of the binary file by specifying what data is stored on given steps.
2. Restore database from binary file with **DataInputStream**.

 ### **UTP Task** [9](http://github.com)
 Title: *Reflection*
 **Objective:**</br>
 Implementing encapsulation, to my class for generating [Pesels](https://en.wikipedia.org/wiki/PESEL).
 Then being able to access methods that are encapsulated through *Test Classes* by using *Reflection*.
 Class contains:
 * private validation methods
 * private method extracting birth date, based on the first six digits of Pesel number
 * private method for extracting a persons sex

