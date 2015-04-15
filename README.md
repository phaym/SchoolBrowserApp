Java application for browsing students and courses in a GUI with no ORM. Also contains page solving problem described below.

##Setup Instructions
Uses Microsft SQL Server. Open SSMS and run scripts "DBScript_Step_1" then "DBScript_Step_2".

Open project in eclipse and run on tomcat server.

Go to link http://localhost/SchoolBrowserApp/StudentListing to begin.

##Tree Problem

A page that determines the level(s) of a binary tree at which a given value exists.

Take 2 inputs:  
**Value To Check**  
* Input should be a single integer value.  

**Tree**  
* Input should be a comma-delimited string that represents tree node values in a binary tree.  
* Input should be in a breadth-first, left-to-right format.

For example, the input: 4,5,9,8,6,,5,2,7,,,,8

Would result in this tree:

        Level 1                        4

                                    /      \

        Level 2                  5           9

                              /   \            \

        Level 3             8       6            5

                          /  \                      \

        Level 4         2      7                      8
         
For the tree example listed above, a value of “5” for “Value To Check”

would produce output similar to the following:
*Levels: 2, 3
