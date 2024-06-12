# restaurant

Summary of the Program:
This program is a simulation system for a take-away service. It is designed to handle various tasks related to order generation and delivery in a restaurant setting, focusing on object-oriented programming principles such as interface design, abstract classes, inheritance, and polymorphism.

Components:
Order Generation (OrderGenerator):
Function: Generates orders for a day based on the input number of orders.
Output: Creates a file orders.txt listing all the orders.

Order Delivery (OrderDelivery):
Function: Simulates the delivery process using specific parameters (e.g., grill length, time to light the grill, number of pans, etc.).It manages the delivery process of orders using different algorithms. It reads orders from a file, processes them, and outputs the results to a file. The system supports multiple algorithms for order processing, including FCFS (First Come First Serve), STS (Shortest Time to Serve), and Weight-based algorithms.

Output: Creates a file deliveries.txt with delivery details, including the number of orders delivered, the average deviation from desired delivery times, and customer satisfaction.

Classes to Run:

OrderGenerator:
How to run:
java OrderGenerator <number_of_orders>
Example:
java OrderGenerator 1000

OrderDelivery:
How to run:
java OrderDelivery <grill_length> <time_to_light_grill> <number_of_pans> <pan_capacity> <skewer_length> <chef_skewer_length> <pita_length> <algorithm>
Example:
java OrderDelivery 400 45 10 4 3 6 12 2

These classes are essential for the simulation, where OrderGenerator is used to create orders and OrderDelivery processes and delivers them based on given constraints and algorithms .


Features
Order Reading: Reads orders from a specified file.
Order Processing: Processes orders based on the selected algorithm.
Algorithm Selection: Supports multiple algorithms for order processing.
Output: Writes the processed orders and statistics to an output file.




