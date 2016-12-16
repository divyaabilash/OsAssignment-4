# OsAssignment-4
Write a program that simulates a paging system using the aging algorithm. The number of page frames is a parameter. The sequence of page references should be read from a file. For a given input file, plot the number of page faults per 1000 memory references as a function of the number of page frames available.

 Assumption and implementation.
 The input is maximum frame number to be generated and the values are stored in File.
 The values are read from the file and every page read is considered as a clock tick.
 The size of the memory is 8.For every page input, the value in memory is compare , 
 if its present then updated with the msb bit as 1. else its decremented by shift one bit to right. 
 The lowest value is replaced if there is a page fault. 
