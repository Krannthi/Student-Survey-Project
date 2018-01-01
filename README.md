# Student-Survey-Project

The application will consist of a student survey server, which will connect to a
database to create and search student survey records. A web based client (i.e., student survey JSF
page) will be used to supply the data for the queries. The modules should be as follows:
1. The client should provide a simple menu to list all records, search records, and create a
new record.
2. You will continue to use the student survey user interface that you developed for the
previous assignment to create new records.
3. Develop a new facelet using JSF tags that allow users to search existing records using
four fields: last name, first name, city, or state.
4. When searching, the client should allow for any combination of the last name, first name,
city, or state. In other words, I should be able to search on just one field, a set of fields, or
all of these 4 fields.
5. The last column of all records rendered on the search result page should have a Delete
link, which allows a user to delete the corresponding record not only from the database
but also from the search result page.
6. Use Amazon RDS to provision and use a MySQL database
7.City and state should be automatically populated based on zip code. This should
be implemented using JSF’s built-in ajax support with <f:ajax ………> and
related tags.
8. Implement a RESTful web service that returns city and state given a zipcode. You
can limit the following zipcode, city, and state combination for implementation
and testing. 
